package navigation;

import Database.DatabaseConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.crypto.Data;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/navigation.MovieDetailsNav")
public class MovieDetailsNav extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        int userId = -1;
        ArrayList<Integer> categoryIds = new ArrayList<>();
        RequestDispatcher dispatcher;

        if(user == null){
            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/startPage.jsp");
        }
        else{
            String title = request.getParameter("title");
            String action = request.getParameter("action");
            if(title != null) {
                if(action != null && action.equals("rent")) {
                    Connection conn;
                    PreparedStatement ps;
                    try {
                        conn = DatabaseConnection.initializeDatabase();
                        ps = conn.prepareStatement("SELECT id FROM account WHERE login LIKE (?)");
                        ps.setString(1, user);
                        if (ps.execute()) {
                            ResultSet rs = ps.getResultSet();
                            rs.next();
                            userId = rs.getInt(1);
                        }
                        ps.close();
                        ps = conn.prepareStatement("SELECT idCAT FROM video WHERE title LIKE (?)");
                        ps.setString(1, title);
                        if (ps.execute()) {
                            ResultSet rs = ps.getResultSet();
                            while (rs.next()) {
                                categoryIds.add(rs.getInt(1));
                            }
                        }
                        ps.close();
                        ps = conn.prepareStatement("UPDATE userpreferences SET power = power -1 WHERE idAccount = (?) AND power > 1");
                        ps.setInt(1, userId);
                        ps.executeUpdate();
                        for (Integer categoryId : categoryIds) {
                            ps.close();
                            ps = conn.prepareStatement("UPDATE userpreferences SET power = power + 2 WHERE idAccount = (?) AND idCAT = (?)");
                            ps.setInt(1, userId);
                            ps.setInt(2, categoryId);
                            ps.executeUpdate();
                        }
                        ps.close();
                        conn.close();
                    } catch (SQLException | ClassNotFoundException throwables) {
                        throwables.printStackTrace();
                    }
                }
                if(action == null) {
                    dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/MovieDetails.jsp?title=" + title);
                }
                else{
                    dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/MovieDetails.jsp?title=" + title + "&action=" + action);
                }
            }
            else {
                dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/LoggedIn.jsp");
            }
        }
        dispatcher.forward(request,response);
    }
}

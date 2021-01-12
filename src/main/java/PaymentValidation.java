import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/PaymentValidation")
public class PaymentValidation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DatabaseConnection.initializeDatabase();
            HttpSession session = request.getSession();
            String user = (String) session.getAttribute("user");
            String title = request.getParameter("title");
            String days = request.getParameter("days");
            String query = "SELECT amount FROM wallet WHERE idAccount=(SELECT id FROM account WHERE login LIKE (?))";
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ResultSet rs;
            if(ps.execute()){
                rs = ps.getResultSet();
                if(rs.next()){
                    int money = rs.getInt(1);
                    ps.close();
                    query = "SELECT cost FROM video WHERE title LIKE (?)";
                    ps = conn.prepareStatement(query);
                    ps.setString(1, title);
                    if(ps.execute()){
                        rs = ps.getResultSet();
                        if(rs.next()){
                            int cost = rs.getInt(1);
                            if(money < cost * Integer.parseInt(days)){
                                response.getWriter().write("insufficient_funds");
                            }
                            else{
                                response.getWriter().write("ok");
                            }
                        }
                        else {
                            response.getWriter().write("SQL error");
                        }
                    }
                    else {
                        response.getWriter().write("SQL error");
                    }
                }
                else {
                    response.getWriter().write("SQL error");
                }
            }
            else {
                response.getWriter().write("SQL error");
            }
        } catch (SQLException | ClassNotFoundException throwables) {
            response.getWriter().write("SQL error");
        } finally {
            try {
                ps.close();
            } catch (Exception ignored) { }
            try {
                conn.close();
            } catch (Exception ignored) { }
        }
    }
}

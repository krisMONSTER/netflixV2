import Database.DatabaseConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/GetArchive")
public class GetArchive extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        if(user == null){
            RequestDispatcher dispatcher;
            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/startPage.jsp");
            dispatcher.forward(request,response);
        }
        else{
            try {
                Connection conn = DatabaseConnection.initializeDatabase();
                String query = "SELECT v.title FROM video v, services s" +
                        " WHERE s.idAccount=(SELECT id FROM account WHERE login=?) AND v.id=s.idVideo AND s.status=0";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, user);

                if(ps.execute()){
                    ResultSet rs = ps.getResultSet();
                    StringBuilder sb = new StringBuilder();
                    sb.append("<table id=\"personal_data\" align=\"center\" width=400px>");
                    while (rs.next()){
                        sb.append("<tr>");
                        sb.append("<td class='center'><span class='title'>" + rs.getString(1) + "</span></td>");
                        sb.append("</tr>");
                    }
                    sb.append("</table>");
                    response.getWriter().write(sb.toString());
                    conn.close();
                    rs.close();
                }
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

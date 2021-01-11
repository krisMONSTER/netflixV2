import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/GetWallet")
public class GetWallet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        try {

            Connection conn = DatabaseConnection.initializeDatabase();
            String query = "SELECT cashType, amount FROM wallet AS w, account AS a WHERE a.login=(?) AND a.id=w.idAccount";
            PreparedStatement ps = conn.prepareStatement(query);
            String login = (String) request.getSession().getAttribute("user");
            if (login != null) {
                ps.setString(1, login);
                ResultSet rs;
                if (ps.execute()) {
                    rs = ps.getResultSet();
                    rs.next();
                    StringBuilder sb = new StringBuilder();
                    sb.append("<table id=\"wallet\" align=\"center\" width=200px>");
                    sb.append("<tr>" +
                            "<td id = 'left'><span class='content'>" + rs.getString("cashType") + " €</span></td>");
                    sb.append("<td id = 'right'><span class='content'>" + rs.getString("amount") + "</span></td>");
                    sb.append("</tr></table>");

                    response.getWriter().write(sb.toString());
                    conn.close();
                    rs.close();
                }
            }
        } catch (SQLException | ClassNotFoundException | IOException throwables) {
            throwables.printStackTrace();
        }

    }


}

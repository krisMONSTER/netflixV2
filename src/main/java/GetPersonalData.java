import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/GetPersonalData")
public class GetPersonalData extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        try {
            Connection conn = DatabaseConnection.initializeDatabase();
            String query = "SELECT p.firstName, p.lastName, p.country, p.address FROM profile AS p, account AS a WHERE a.login=(?) AND a.id=p.idAccount";
            PreparedStatement ps = conn.prepareStatement(query);
            String login = (String) request.getSession().getAttribute("user");
            if (login != null) {
                ps.setString(1, login);
                ResultSet rs;
                if (ps.execute()) {
                    rs = ps.getResultSet();
                    if (rs.next()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("<table id=\"personal_data\" align=\"center\" width=400px>");
                        sb.append(addRow(rs.getString(1), "first_name"));
                        sb.append(addRow(rs.getString(2), "last_name"));
                        sb.append(addRow(rs.getString(3), "country"));
                        sb.append(addRow(rs.getString(4), "address"));
                        sb.append("</table>");
                        response.getWriter().write(sb.toString());
                        conn.close();
                        rs.close();
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException | IOException throwables) {
            throwables.printStackTrace();
        }

    }

    private String addRow(String content, String label) {
        return "<tr>" +
                "<td id='left'><span class='content'>"+content+"</span><br><span id='"+label+"'></span></td>" +
                "<td id='right'><img src=\"data:image/gif;base64,R0lGODlhAQABAAD/ACwAAAAAAQABAAACADs%3D\" class='edit_data' alt='edit' height=\"50\" width=\"50\"></td>" +
                "</tr>";
    }
}

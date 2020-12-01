import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/searchMovies")
public class searchMovies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("KRYSIAMYJETALERZ");
        try {
            Connection baza = DatabaseConnection.initializeDatabase();

            PreparedStatement getvideos = baza.prepareStatement("SELECT DISTINCT title, description FROM video WHERE title LIKE (?) ORDER BY title");

            getvideos.setString(1, "%" + request.getParameter("search") + "%");
            //getvideos.setString(1, "Aarons Blood");
            ResultSet rs;
            ArrayList<String[]> data = new ArrayList<>();

            if (getvideos.execute()) {
                rs = getvideos.getResultSet();
                while (rs.next()) {
                    // rs.next();
                    data.add(new String[]{rs.getString(1), rs.getString(2)});
                    System.out.println(data);
                }
                /*request.setAttribute("data", data);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LoggedIn.jsp");
                rd.forward(request, response);
                 */

                StringBuilder reply = new StringBuilder();
                reply.append(
                        "<table border=\"1\" width=\"500\" align=\"center\">" +
                                "        <tr bgcolor=\"#7fffd4\">" +
                                "            <th><b>tytul</b></th>" +
                                "            <th><b>opis</b></th>" +
                                "        </tr>"

                );

                if (!request.getParameter("search").equals("")) {
                    for (String[] row : data) {
                        reply.append("<tr>");
                        reply.append("<td>" + row[0] + "</td>");
                        reply.append("<td>" + row[1] + "</td>");
                        reply.append("</tr>");
                    }
                }

                reply.append("</table>");

                response.getWriter().write(reply.toString());
                baza.close();
                rs.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

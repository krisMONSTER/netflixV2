import Database.DatabaseConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        response.setCharacterEncoding("UTF-8");
        try {
            Connection baza = DatabaseConnection.initializeDatabase();

            PreparedStatement getvideos = baza.prepareStatement("SELECT DISTINCT title, description FROM video WHERE title LIKE (?) ORDER BY title");

            getvideos.setString(1, "%" + request.getParameter("search") + "%");

            ResultSet rs;
            ArrayList<String[]> data = new ArrayList<>();

            if (getvideos.execute()) {
                rs = getvideos.getResultSet();
                while (rs.next()) {

                    data.add(new String[]{rs.getString(1), rs.getString(2)});

                }
                /*request.setAttribute("data", data);
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/LoggedIn.jsp");
                rd.forward(request, response);
                 */

                StringBuilder reply = new StringBuilder();



                reply.append(
                        "<table id=\"movies\" class=\"table table-bordered table-striped\" width=\"60%\" align=\"center\">" +
                                "<thead>"+
                                "        <tr>" +
                                "            <th><b><span>Title</span></b></th>" +
                                "            <th><b><span>Description</span></b></th>" +
                                "        </tr>"+
                                "</thead>"+
                                "<tbody>"



                );
                if (!request.getParameter("search").equals("")) {
                    for (String[] row : data) {
                        reply.append("<tr>");
                        reply.append("<td><span class='title'>" + row[0] + "</span></td>");
                        reply.append("<td><span>" + row[1] + "</span></td>");
                        reply.append("</tr>");
                    }
                }

                reply.append("</tbody>" +
                        "</table>"
                );


                response.getWriter().write(reply.toString());
                baza.close();
                rs.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

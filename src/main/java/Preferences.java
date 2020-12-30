import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@WebServlet("/Preferences")
public class Preferences extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { execute(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Connection database = DatabaseConnection.initializeDatabase();
            HttpSession session = request.getSession();

            PreparedStatement getVideos = database.prepareStatement("SELECT DISTINCT video.title, video.destription FROM userpreferences, account, video " +
                    "WHERE account.login=(?) AND account.id = userpreferences.idAccount AND userpreferences.idCAT = video.idCAT " +
                    "ORDER BY userpreferences.power DESC");



            getVideos.setString(1,(String)session.getAttribute("user"));



            ResultSet rs;
            ArrayList<String[]> data = new ArrayList<>();

            if (getVideos.execute()) {
                rs = getVideos.getResultSet();
                while (rs.next()) {

                    data.add(new String[]{rs.getString(1), rs.getString(2)});

                }


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
                for (String[] row : data) {
                        reply.append("<tr>");
                        reply.append("<td><span>" + row[0] + "</span></td>");
                        reply.append("<td><span>" + row[1] + "</span></td>");
                        reply.append("</tr>");
                }


                reply.append("</tbody>" +
                        "</table>"
                );



                response.getWriter().write(reply.toString());
                System.out.println((String)session.getAttribute("user"));
                database.close();
                rs.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}


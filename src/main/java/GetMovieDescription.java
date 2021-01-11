import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/GetMovieDescription")
public class GetMovieDescription extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        String title = request.getParameter("title");
        if(title != null) {
            try {
                Connection conn = DatabaseConnection.initializeDatabase();
                String query = "SELECT DISTINCT description FROM video WHERE title LIKE (?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, title);
                ResultSet rs;
                if(ps.execute()){
                    rs = ps.getResultSet();
                    if(rs.next()){
                        response.getWriter().write(rs.getString(1));
                        conn.close();
                        rs.close();
                    }
                }

            } catch (SQLException | ClassNotFoundException | IOException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

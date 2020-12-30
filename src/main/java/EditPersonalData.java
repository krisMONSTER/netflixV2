import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/EditPersonalData")
public class EditPersonalData extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        if (request.getCharacterEncoding() == null)
            request.setCharacterEncoding("UTF-8");
        try {
            Connection conn = DatabaseConnection.initializeDatabase();

            String query = "UPDATE profile " +
                    "SET firstName=(?), lastName=(?), country=(?), address=(?) " +
                    "WHERE idAccount=(SELECT id FROM account WHERE login=(?))";
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, request.getParameter("first_name"));
            ps.setString(2, request.getParameter("last_name"));
            ps.setString(3, request.getParameter("country"));
            ps.setString(4, request.getParameter("address"));
            ps.setString(5, (String) request.getSession().getAttribute("user"));

            ps.executeUpdate();
            ps.close();
            conn.close();

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Welcome");
            dispatcher.forward(request,response);
        } catch (SQLException | ClassNotFoundException | IOException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }
}

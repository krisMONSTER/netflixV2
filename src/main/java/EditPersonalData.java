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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        System.out.println("INSIDE");
        String input = request.getParameter("input");

        if (request.getCharacterEncoding() == null)
            request.setCharacterEncoding("UTF-8");

        try {
            Connection conn = DatabaseConnection.initializeDatabase();

            String query;
            PreparedStatement ps = null;
            if(input == null || input.equals("null")){
                System.out.println("CASE 1: ");
                query = "UPDATE profile " +
                        "SET firstName=(?), lastName=(?), country=(?), address=(?) " +
                        "WHERE idAccount=(SELECT id FROM account WHERE login=(?))";
                ps = conn.prepareStatement(query);

                ps.setString(1, request.getParameter("first_name"));
                ps.setString(2, request.getParameter("last_name"));
                ps.setString(3, request.getParameter("country"));
                ps.setString(4, request.getParameter("address"));
                ps.setString(5, (String) request.getSession().getAttribute("user"));
            }
            else if(input.equals("first_name_btn")){
                System.out.println("CASE 2: ");
                query = "UPDATE profile " +
                        "SET firstName=(?) " +
                        "WHERE idAccount=(SELECT id FROM account WHERE login=(?))";
                ps = conn.prepareStatement(query);

                ps.setString(1, request.getParameter("first_name"));
                ps.setString(2, (String) request.getSession().getAttribute("user"));
            }
            else if(input.equals("last_name_btn")){
                System.out.println("CASE 3: ");
                query = "UPDATE profile " +
                        "SET lastName=(?) " +
                        "WHERE idAccount=(SELECT id FROM account WHERE login=(?))";
                ps = conn.prepareStatement(query);

                ps.setString(1, request.getParameter("last_name"));
                ps.setString(2, (String) request.getSession().getAttribute("user"));
            }
            else if(input.equals("country_btn")){
                System.out.println("CASE 4: ");
                query = "UPDATE profile " +
                        "SET country=(?) " +
                        "WHERE idAccount=(SELECT id FROM account WHERE login=(?))";
                ps = conn.prepareStatement(query);

                ps.setString(1, request.getParameter("country"));
                ps.setString(2, (String) request.getSession().getAttribute("user"));
            }
            else if(input.equals("address_btn")){
                System.out.println("CASE 5: ");
                query = "UPDATE profile " +
                        "SET address=(?) " +
                        "WHERE idAccount=(SELECT id FROM account WHERE login=(?))";
                ps = conn.prepareStatement(query);

                ps.setString(1, request.getParameter("address"));
                ps.setString(2, (String) request.getSession().getAttribute("user"));
            }
            if(ps != null) {
                System.out.println("UAKTUALNIAM\n\n\n\n\n");
                ps.executeUpdate();
                ps.close();
            }
            conn.close();

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Welcome");
            dispatcher.forward(request,response);

        } catch (SQLException | ClassNotFoundException | IOException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }
}

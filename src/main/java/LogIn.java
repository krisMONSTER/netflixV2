import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/LogIn")
public class LogIn extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        try {
            conn = DatabaseConnection.initializeDatabase();
            ps = conn.prepareStatement("SELECT login,password,verified FROM account WHERE login=(?) AND password=(?)");

            ps.setString(1, request.getParameter("login"));


            //szyfrowanie hasła
            String key = Encryption.createKey(request.getParameter("login"));
            String encryptedPassword = Encryption.encrypt(request.getParameter("password"), key);
            ps.setString(2, encryptedPassword);
            //koniec

            if (request.getParameter("login").equals("") || request.getParameter("password").equals(""))
                response.getWriter().write("Fill in all gaps");
            else if (ps.execute()) {
                rs = ps.getResultSet();
                rs.next();
                String login;
                try {
                    if (rs.getInt("verified") == 1) {

                        login = rs.getString("login");
                        HttpSession session = request.getSession();
                        session.setAttribute("user", login);
                    } else {
                        out.write("User not activated!");
                    }

                } catch (SQLException e) {
                    out.write("Login not found with associated password");
                }
            }
        } catch (SQLException e) {
            out.write("SQL Error! Notify page admin!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            out.close();
            try {
                rs.close();
            } catch (Exception ignored) {
            }
            try {
                ps.close();
            } catch (Exception ignored) {
            }
            try {
                conn.close();
            } catch (Exception ignored) {
            }

        }
    }
}

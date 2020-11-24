import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("KRYSIAJEKOLACJE");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        try {
            conn = DatabaseConnection.initializeDatabase();
            ps = conn.prepareStatement("SELECT login,password,status FROM account WHERE login=(?) AND password=(?)");
            ps.setString(1,request.getParameter("login"));
            ps.setString(2,request.getParameter("password"));
            if(ps.execute()){
                rs = ps.getResultSet();
                rs.next();
                String login;
                try {
                    login = rs.getString("login");

                    response.getWriter().write("succeeded");
                }catch (SQLException e){
                    response.getWriter().write("failed");
                }
            }
        } catch (SQLException e) {
            response.getWriter().write("SQLfail");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try { rs.close(); } catch (Exception ignored) {}
            try { ps.close(); } catch (Exception ignored) {}
            try { conn.close(); } catch (Exception ignored) {}
        }
    }
}

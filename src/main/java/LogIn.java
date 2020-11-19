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
        try {
            Connection baza = DatabaseConnection.initializeDatabase();
            PreparedStatement st = baza.prepareStatement("SELECT login,password,status FROM account WHERE login=(?) AND password=(?)");
            st.setString(1,request.getParameter("login"));
            st.setString(2,request.getParameter("password"));
            //Statement stmt = null;
            //stmt = baza.createStatement();
            //ResultSet rs = stmt.executeQuery("SELECT login,password,status FROM account");
            ResultSet rs = null;
            if(st.execute()){
                rs = st.getResultSet();
                rs.next();
                String login = "";
                PrintWriter out = response.getWriter();
                try {
                    login = rs.getString("login");
                }catch (SQLException e){
                    out.println("<html><body><b>nie ma"
                            + "</b></body></html>");
                }
                System.out.println(login);
                //response.sendRedirect(request.getContextPath() + "?a=5");
                response.getOutputStream().println("<script type='text/javascript'>document.getElementById(\"messages\");</script>");
                out.println("<html><body><b>" + login
                        + "</b></body></html>");

            }
            if(st != null)
                rs.close();


                    /*
            st.setString(1,request.getParameter("login"));
            st.setString(2,request.getParameter("haslo"));
            st.setString(3,request.getParameter("email"));


            st.setInt(4,Integer.parseInt(request.getParameter("weryfikacja")));

                     */
            baza.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

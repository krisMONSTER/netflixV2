import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     try{
         Connection baza = DatabaseConnection.initializeDatabase();
         //id; login, pass, email,verifie,status
         PreparedStatement st = baza.prepareStatement("INSERT INTO account (login,password,email,verified)VALUES (?,?,?,?)");
         st.setString(1,request.getParameter("login"));
         st.setString(2,request.getParameter("haslo"));
         st.setString(3,request.getParameter("email"));
         st.setInt(4,Integer.parseInt(request.getParameter("weryfikacja")));

         st.executeUpdate();
         st.close();
         baza.close();
         PrintWriter out = response.getWriter();
         out.println("<html><body><b>Successfully Inserted"
                 + "</b></body></html>");
     }catch(Exception e ){
         e.printStackTrace();
     }
    }




}

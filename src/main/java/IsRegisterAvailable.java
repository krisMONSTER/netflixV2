import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/IsRegisterAvailable")
public class IsRegisterAvailable extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Connection baza = DatabaseConnection.initializeDatabase();
            //id; login, pass, email,verifie,status


            //Check if user already exists
            PreparedStatement ifexists = baza.prepareStatement("SELECT login, email FROM account WHERE login=(?) OR email=(?)");
            ifexists.setString(1, request.getParameter("login"));
            ifexists.setString(2, request.getParameter("email"));
            ResultSet ifexists_rs = null;
            response.setCharacterEncoding("UTF-8");

            if(request.getParameter("login").equals("")||request.getParameter("email").equals("")||request.getParameter("password").equals(""))
                response.getWriter().write("Fill in all gaps");
            else if (ifexists.execute()) {
                ifexists_rs = ifexists.getResultSet();

                //If there is a user with this email or login
                if (ifexists_rs.next()) {
                    if (ifexists_rs.getString("login").equals(request.getParameter("login"))) {
                        System.out.println("Użytkownik " + request.getParameter("login") + " juz istnieje. ");
                        response.getWriter().write("User name already taken!");
                    }
                    else {
                        response.getWriter().write("Email already in use!");
                        System.out.println("Email " + request.getParameter("email") + " jest zajety.");
                    }

                } else {
                    response.getWriter().write("yes");
                }
            }

            ifexists.close();
            baza.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

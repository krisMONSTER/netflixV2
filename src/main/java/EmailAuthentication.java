import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/authenticate")
public class EmailAuthentication extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.write("<html><body><div id='serlvetResponse' style='text-align: center;'>");
        RequestDispatcher dispatcher;
        try {
            Connection baza = DatabaseConnection.initializeDatabase();
            PreparedStatement ifauthenticated = baza.prepareStatement("SELECT login, email, verified FROM account WHERE email=(?)");

            // chyba ze tu potem jak bedzie zamieniony email na zakodowany

            System.out.println(Encryption.decrypt(request.getParameter("code"), Encryption.createKey("hasloemail")));
            ifauthenticated.setString(1, Encryption.decrypt(request.getParameter("code"), Encryption.createKey("hasloemail")));

            ResultSet ifauthent_rs;


            if (ifauthenticated.execute()) {
                ifauthent_rs = ifauthenticated.getResultSet();

                //if there is an email connected to this link
                if (ifauthent_rs.next() == true) {
                    if (ifauthent_rs.getInt("verified") == 1) {

                        out.write("<p id='errMsg' style='color: red; font-size: larger;'>This Email has already been verified." + "</p>");
                        dispatcher = request.getRequestDispatcher("/WEB-INF/Login.jsp");
                        dispatcher.include(request, response);

                    } else {
                        PreparedStatement updateverification = baza.prepareStatement("UPDATE account SET verified = 1 WHERE email=(?)");
                        updateverification.setString(1, Encryption.decrypt(request.getParameter("code"), Encryption.createKey("hasloemail")));
                        updateverification.execute();
                        out.write("<p id='errMsg' style='color: red; font-size: larger;'>You have successfully verified your email." + "</p>");
                        dispatcher = request.getRequestDispatcher("/WEB-INF/Login.jsp");
                        dispatcher.include(request, response);
                        updateverification.close();


                    }
                }
                //no email connected to this link
                else {
                    out.write("<p id='errMsg' style='color: red; font-size: larger;'>Wrong activation link." + "</p>");
                    dispatcher = request.getRequestDispatcher("/WEB-INF/Login.jsp");
                    dispatcher.include(request, response);

                }
            }
            out.write("</div></body></html>");
            out.close();

            ifauthenticated.close();
            baza.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}

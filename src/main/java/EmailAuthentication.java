import jakarta.servlet.http.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/EmailAuthentication")
public class EmailAuthentication extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("WTF");
        /*
        try {
            Connection baza = DatabaseConnection.initializeDatabase();
            PreparedStatement ifauthenticated = baza.prepareStatement("SELECT login, email, verified FROM account WHERE email=(?)");

            // chyba ze tu potem jak bedzie zamieniony email na zakodowany

            System.out.println(Encryption.decrypt(request.getParameter("code"), Encryption.createKey("hasloemail")));
            ifauthenticated.setString(1, Encryption.decrypt(request.getParameter("code"), Encryption.createKey("hasloemail")));

            ResultSet ifauthent_rs;


            PrintWriter out = response.getWriter();
            if (ifauthenticated.execute()) {
                ifauthent_rs = ifauthenticated.getResultSet();

                //if there is an email connected to this link
                if (ifauthent_rs.next() == true) {
                    if (ifauthent_rs.getInt("verified") == 1) {
                        out.println("<html><body><b>" + request.getParameter("code") + " has already been verified."
                                + "</b></body></html>");
                    } else {
                        PreparedStatement updateverification = baza.prepareStatement("UPDATE account SET verified = 1 WHERE email=(?)");

                        //tutaj tez potem trzeba deszyfrowac email xd ??

                        updateverification.setString(1, request.getParameter("code"));
                        updateverification.execute();
                        out.println("<html><body><b>" + "You have successfully verified: " + request.getParameter("code")
                                + "</b></body></html>");
                        updateverification.close();
                    }
                }
                //no email connected to this link
                else {
                    out.println("<html><body><b>" + "No such email connected to any acoount: " + request.getParameter("code")
                            + "</b></body></html>");

                }
            }

            ifauthenticated.close();
            baza.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }



         */
    }
}

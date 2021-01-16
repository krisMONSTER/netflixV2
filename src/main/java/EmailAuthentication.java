import Database.DatabaseConnection;

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
        RequestDispatcher dispatcher;
        try {
            request.setCharacterEncoding("UTF-8");
            Connection baza = DatabaseConnection.initializeDatabase();
            PreparedStatement ifauthenticated = baza.prepareStatement("SELECT login, email, verified FROM account WHERE email=(?)");

            String fixedCode = request.getParameter("code").replace(' ','+');
            System.out.println("CODE:" + fixedCode);

            ifauthenticated.setString(1, Encryption.decrypt(fixedCode, Encryption.createKey("pe")));
            System.out.println("DECRYPTED:" + Encryption.decrypt(fixedCode, Encryption.createKey("pe")));
            ResultSet ifauthent_rs;
            String toDisplay = "";

            if (ifauthenticated.execute()) {
                ifauthent_rs = ifauthenticated.getResultSet();

                //if there is an email connected to this link
                if (ifauthent_rs.next()) {
                    if (ifauthent_rs.getInt("verified") == 1) {
                        toDisplay = "This Email has already been verified.";

                    } else {
                        PreparedStatement updateverification = baza.prepareStatement("UPDATE account SET verified = 1 WHERE email=(?)");
                        updateverification.setString(1, Encryption.decrypt(fixedCode, Encryption.createKey("pe")));
                        updateverification.execute();
                        toDisplay = "You have successfully verified your email.";
                        updateverification.close();

                    }
                }

                //no email connected to this link
                else {
                    toDisplay = "Wrong activation link.";
                }

                out.print("<script type = 'text/javascript' language='JavaScript'> " +
                        "document.onreadystatechange = () =>{ if(document.readyState==='complete'){" +
                        "let snackbar = document.getElementById(\"snackbar\");\n" +
                        "        snackbar.innerHTML = \"" + toDisplay + "\";\n" +
                        "        snackbar.className = \"show\";\n" +
                        "        setTimeout(function () {\n" +
                        "            snackbar.className = snackbar.className.replace(\"show\", \"\");\n" +
                        "        }, 3000);" +
                        "}};" +
                        "</script>");

                dispatcher = request.getRequestDispatcher("/WEB-INF/Login.jsp");
                dispatcher.include(request, response);
            }

            out.close();

            ifauthenticated.close();
            baza.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}

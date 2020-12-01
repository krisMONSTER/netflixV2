import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection baza = DatabaseConnection.initializeDatabase();
            //id; login, pass, email,verifie,status


            //Check if user already exists
            PreparedStatement ifexists = baza.prepareStatement("SELECT login, email FROM account WHERE login=(?) OR email=(?)");
            ifexists.setString(1, request.getParameter("login"));
            ifexists.setString(2, request.getParameter("email"));
            ResultSet ifexists_rs = null;


            if (ifexists.execute()) {
                ifexists_rs = ifexists.getResultSet();

                //If there is a user with this email or login
                if (ifexists_rs.next() == true) {
                    if (ifexists_rs.getString("login").equals(request.getParameter("login")))
                        System.out.println("Użytkownik " + request.getParameter("login") + " juz istnieje. ");
                    else
                        System.out.println("Email " + request.getParameter("email") + " jest zajety.");

                    // TU MOŻE COŚ WYŚWIETLIĆ ŻEBY ZMIENIĆ LOGIN CZY TAM EMAIL

                    //If there is not it prepares the statement and update the database
                } else {
                    PreparedStatement st = baza.prepareStatement("INSERT INTO account (login,password,email,verified)VALUES (?,?,?,?)");
                    st.setString(1, request.getParameter("login"));

                    //szyfrowanie hasła

                    System.out.println("Login: " + request.getParameter("login"));
                    System.out.println("Haslo: " + request.getParameter("haslo"));

                    String key = Encryption.createKey(request.getParameter("login"));
                    System.out.println("Klucz: " + key);
                    String encryptedPassword = Encryption.encrypt(request.getParameter("haslo"), key);
                    System.out.println("Zaszyfrowane: " + encryptedPassword);
                    st.setString(2, encryptedPassword);
                    //koniec


                    st.setString(3, request.getParameter("email"));

                    SendMail.send(request.getParameter("email"));
                    st.setInt(4, 0);
                    st.executeUpdate();
                    st.close();
                    PrintWriter out = response.getWriter();


                    out.println("<html><body><b>Successfully Inserted"
                            + "</b></body></html>");
                }
            }

            ifexists.close();
            baza.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

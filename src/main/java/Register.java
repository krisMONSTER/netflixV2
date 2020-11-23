import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

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
                /*
                 String zaszyfrowane = request.getParameter("haslo");
                //zaszyfrowane.szyfruj
                st.setString(2,zaszyfrowane);

                */
                    String link="dupa";
                    st.setString(2, request.getParameter("haslo"));
                    st.setString(3, request.getParameter("email"));
/*
                    String email_to=request.getParameter("email");
                    String host = "localhost";
                    Properties properties = System.getProperties();
                    properties.setProperty("mail.smtp.host",host);
                    Session session = Session.getDefaultInstance(properties);
                    try{
                        MimeMessage message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(email_from));
                        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email_to));
                        message.setSubject("MoveOn Activation Link!");
                        message.setText("Hello!\n You have registered on our website MoveOn and " +
                                "before you can use our services and log in to your account, you have to confirm your registration by clicking the link below!\n"+
                                link);
                        Transport.send(message);
                        System.out.println("Sent successfully =].");
                    }catch(MessagingException mex){
                        mex.printStackTrace();
                    }
*/

                    SendMail.send(request.getParameter("email"));
                    st.setInt(4, Integer.parseInt(request.getParameter("weryfikacja")));
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

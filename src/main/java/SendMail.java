import java.io.*;
import java.util.*;
import javax.mail.Authenticator;
import javax.mail.internet.*;
import javax.mail.*;




public class SendMail
{
    final static private String email_from="uz.moveon@gmail.com";
    final static private String pass="uzmoveon123";
    public static void send(String email_to)
    {
        //create an instance of Properties Class
        Properties props = new Properties();

        /*  Specifies the IP address of your default mail server
     	      for e.g if you are using gmail server as an email sever
            you will pass smtp.gmail.com as value of mail.smtp host.
            As shown here in the code.
            Change accordingly, if your email id is not a gmail id
        */
        props.put("mail.smtp.host", "smtp.gmail.com");
        // below mentioned mail.smtp.port is optional
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        /* Pass Properties object(props) and Authenticator object
           for authentication to Session instance
        */

        Session session = Session.getInstance(props,new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(email_from,pass);
            }
        });

        try {

     	      /*  Create an instance of MimeMessage,
     	          it accept MIME types and headers
     	      */
            String link= "dupa";
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email_from));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(email_to));
            message.setSubject("MoveOn Activation Link!");
            message.setText("Hello!\n You have registered on our website MoveOn and " +
                    "before you can use our services and log in to your account, you have to confirm your registration by clicking the link below!\n"+
                    link);

            /* Transport class is used to deliver the message to the recipients */

            Transport.send(message);
            System.out.println("Wyslano xd");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

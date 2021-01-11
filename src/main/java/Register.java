
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


import javax.servlet.RequestDispatcher;
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
            RequestDispatcher dispatcher;

            PreparedStatement st = baza.prepareStatement("INSERT INTO account (login,password,email,verified)VALUES (?,?,?,?)");
            st.setString(1, request.getParameter("login"));

            //szyfrowanie hasła

            System.out.println("Login: " + request.getParameter("login"));
            System.out.println("Haslo: " + request.getParameter("password"));

            String key = Encryption.createKey(request.getParameter("login"));
            System.out.println("Klucz: " + key);
            String encryptedPassword = Encryption.encrypt(request.getParameter("password"), key);
            System.out.println("Zaszyfrowane: " + encryptedPassword);
            st.setString(2, encryptedPassword);
            //koniec


            st.setString(3, request.getParameter("email"));

            SendMail.send(request.getParameter("email"));
            st.setInt(4, 0);
            st.executeUpdate();
            st.close();

            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
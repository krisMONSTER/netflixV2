
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
import javax.xml.transform.Result;


@WebServlet("/Register")
public class Register extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Connection conn = DatabaseConnection.initializeDatabase();
            //id; login, pass, email,verifie,status
            RequestDispatcher dispatcher;

            PreparedStatement st = conn.prepareStatement("INSERT INTO account (login,password,email,verified)VALUES (?,?,?,?)");
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

            PreparedStatement ps = conn.prepareStatement("SELECT id FROM account WHERE login=(?)");
            ResultSet rs = null;
            int id_acc = 0;
            ps.setString(1, request.getParameter("login"));
            if (ps.execute()) {
                rs = ps.getResultSet();
                rs.next();
            }
            try {
                id_acc = rs.getInt("id");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            ps = conn.prepareStatement("INSERT INTO wallet (cashType, amount, idAccount) VALUES (?,?,?)");
            ps.setString(1, "EUR");
            ps.setInt(2, 0);
            ps.setInt(3, id_acc);
            ps.executeUpdate();
            ps.close();
            ps = conn.prepareStatement("INSERT INTO profile (firstName, lastName, country, address,idAccount) VALUES (?,?,?,?,?)");
            ps.setString(1, "");
            ps.setString(2, "");
            ps.setString(3, "");
            ps.setString(4, "");
            ps.setInt(5, id_acc);

            ps.executeUpdate();
            ps.close();
            conn.close();
            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Login.jsp");
            dispatcher.forward(request, response);


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
import Database.DatabaseConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "TopUpWallet", value = "/TopUpWallet")
public class TopUpWallet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            Connection conn = DatabaseConnection.initializeDatabase();
            int curr_amount = 0;
            //GetCurrentAmountOfMoneyOnWallet
            String query = "SELECT amount FROM wallet AS w, account AS a WHERE a.login=(?) AND a.id=w.idAccount";
            PreparedStatement ps = conn.prepareStatement(query);
            String login = (String) request.getSession().getAttribute("user");
            if (login != null) {
                ps.setString(1, login);
                ResultSet rs;
                if (ps.execute()) {
                    rs = ps.getResultSet();
                    rs.next();
                    curr_amount = rs.getInt("amount");
                    rs.close();
                }
                ps.close();

            }


            PreparedStatement ps2 = conn.prepareStatement("UPDATE wallet SET amount = (?) WHERE idAccount = (SELECT id FROM account WHERE login = (?))");
            //TOPS UP 50 EUR
            ps2.setInt(1, curr_amount + 50);
            ps2.setString(2, login);

            if (ps2.executeUpdate() != 0) {
                response.getWriter().write("success");
            } else {
                response.getWriter().write("failed");
            }
            ps2.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

}

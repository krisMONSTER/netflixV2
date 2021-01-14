package navigation;

import Database.DatabaseConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/navigation.EditDataNav")
public class EditDataNav extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        RequestDispatcher dispatcher;

        if (user == null) {
            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/startPage.jsp");
        } else {
            String name = "";
            String surname = "";
            String country = "";
            String address = "";
            //co to jest ten parameter xD?
            String parameter = request.getParameter("input");
            //System.out.println("Parametr: ");
            try {
                Connection conn = DatabaseConnection.initializeDatabase();
                String query = "SELECT p.firstName, p.lastName, p.country, p.address FROM profile AS p, account AS a WHERE a.login=(?) AND a.id=p.idAccount";
                PreparedStatement ps = conn.prepareStatement(query);
                String login = (String) request.getSession().getAttribute("user");
                if (login != null) {
                    ps.setString(1, login);
                    ResultSet rs;
                    if (ps.execute()) {
                        rs = ps.getResultSet();
                        rs.next();
                        name = rs.getString("p.firstName");
                        surname = rs.getString("p.lastName");
                        country = rs.getString("p.country");
                        address = rs.getString("p.address");
                    }
                    ps.close();
                    conn.close();

                }
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (name == null || name.equals("null"))
                name = "";
            if (surname == null || surname.equals("null"))
                surname = "";
            if (country == null || country.equals("null"))
                country = "";
            if (address == null || address.equals("null"))
                address = "";

            if (parameter != null) {
                dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/PersonalDataForm.jsp?input=" + request.getParameter("input") + "&first_name=" + name + "&last_name=" + surname + "&country=" + country + "&address=" + address);
                System.out.println("Parameter: !null");
            } else {
                System.out.println("Parameter: null");
                dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/PersonalDataForm.jsp?first_name=" + name + "&last_name=" + surname + "&country=" + country + "&address=" + address);
            }
        }
        dispatcher.forward(request, response);
    }
}

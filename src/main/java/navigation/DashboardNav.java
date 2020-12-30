package navigation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/navigation.DashboardNav")
public class DashboardNav extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        execute(request, response);
    }

    private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        RequestDispatcher dispatcher;

        if(user == null){
            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/startPage.jsp");
        }
        else{
            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/Dashboard.jsp");
        }
        dispatcher.forward(request,response);
    }
}

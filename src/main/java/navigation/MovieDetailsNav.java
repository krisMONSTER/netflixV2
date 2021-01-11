package navigation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/navigation.MovieDetailsNav")
public class MovieDetailsNav extends HttpServlet {
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

        if(user == null){
            dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/startPage.jsp");
        }
        else{
            String title = request.getParameter("title");
            if(title != null) {
                dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/MovieDetails.jsp?title=" + title);
            }
            else {
                dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/LoggedIn.jsp");
            }
        }
        dispatcher.forward(request,response);
    }
}

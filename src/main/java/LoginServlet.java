import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {


    private static final String LOGIN = "admin";
    private static final String PASSWORD = "123";


    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        httpServletResponse.setContentType("text/html;charset=UTF-8");
        PrintWriter out = httpServletResponse.getWriter();

        String login = httpServletRequest.getParameter("login");
        String password = httpServletRequest.getParameter("password");

        if (login.equals(LOGIN) && password.equals(PASSWORD)) {
            httpServletRequest.getSession().setAttribute("authorization", "true");
            RequestDispatcher rs = httpServletRequest.getRequestDispatcher("welcome");
            rs.forward(httpServletRequest, httpServletResponse);

        } else {
            out.println("Username or Password incorrect");
            RequestDispatcher rs = httpServletRequest.getRequestDispatcher("index.html");
            rs.include(httpServletRequest, httpServletResponse);
        }

    }
}

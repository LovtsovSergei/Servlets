import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        PrintWriter out = httpServletResponse.getWriter();


        if (httpServletRequest.getSession().getAttribute("authorization") != null
                && httpServletRequest.getSession().getAttribute("authorization").equals("true")) {
            chain.doFilter(httpServletRequest, httpServletResponse);
        } else {
            out.println("You have entered a wrong password");
            RequestDispatcher rs = request.getRequestDispatcher("index.html");
            rs.include(request, response);
        }


    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override

    public void destroy() {

    }


}
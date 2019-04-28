package Classes;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/movie")
public class MovieFilterDto implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("я был рождён чтобы защищать от нессанкционированного доступа");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession(false);
        //System.out.println("session "+session.getAttribute("primaryTitle"));
        if(session != null) {
            String login = (String)session.getAttribute("login");
            if(login != null) {
               // System.out.println("Welcome");
                filterChain.doFilter( servletRequest, servletResponse); }
            else {
                System.out.println("You shall not pass!");
                throw new ServletException("You shall not pass!");}
        } else {
            System.out.println("You shall not pass!Session=NULL");
            throw new ServletException("You shall not pass!"); }

    }

    @Override
    public void destroy() {

    }
}

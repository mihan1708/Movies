package Classes.Servlets;

import Classes.User;
import Classes.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name = "login", urlPatterns = "/user/login")
public class ServletLogin extends HttpServlet {
    @Autowired
    UserServiceImpl userService;
    String login;
    String password;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login = req.getParameter("login");
        password = req.getParameter("password");
        HttpSession session = req.getSession(true);
        User user = userService.loginUser(login,password);
        if(user!=null)
        {
            session.setAttribute("login", userService.getCurrentUser().getLogin());
            session.setAttribute("password", userService.getCurrentUser().getPassword());
            resp.getWriter().append("welcome "+session.getAttribute("login"));
        }
        else
        {
            resp.getWriter().append("dont correct data");
        }
    }
}

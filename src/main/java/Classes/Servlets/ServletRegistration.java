package Classes.Servlets;

import Classes.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "register", urlPatterns = "/user/register")
public class ServletRegistration extends HttpServlet {
    @Autowired
    UserServiceImpl userService;// = UserServiceImpl.getInstance();
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
        //resp.getWriter().write("registerServlet");
        login = req.getParameter("login");
        password = req.getParameter("password");
        if(userService.registrationUser(login,password))
        {
            resp.getWriter().append("user was register");
        }
        else
        {
            resp.getWriter().append("dont correct data\n"+login);
        }
    }

}

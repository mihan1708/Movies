package Classes.Servlets;

import Classes.MovieFilterDto;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfiguration {
    @Bean
    public ServletRegistrationBean servletHello()
    {
        ServletRegistrationBean bean = new ServletRegistrationBean(new ServletHello(),"/hello");
        bean.setLoadOnStartup(1);
        return  bean;
    }
    @Bean
    public ServletRegistrationBean servletLogin()
    {
        ServletRegistrationBean bean = new ServletRegistrationBean(new ServletLogin(),"/user/login");
        bean.setLoadOnStartup(1);
        return  bean;
    }
    @Bean
    public ServletRegistrationBean servletRegistration()
    {
        ServletRegistrationBean bean = new ServletRegistrationBean(new ServletRegistration(),"/user/register");
        bean.setLoadOnStartup(1);
        return  bean;
    }

    @Bean
    public FilterRegistrationBean servletSecurityFilter()
    {
        FilterRegistrationBean bean = new FilterRegistrationBean(new MovieFilterDto());
        bean.setFilter(new MovieFilterDto());
        bean.addUrlPatterns("/movie/*");
        return  bean;
    }

}

package ua.home.Util;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import ua.home.config.Config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();
        context.register(Config.class);

        ServletRegistration.Dynamic registration =
                servletContext.addServlet("dispatcher", new DispatcherServlet(context));

        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}

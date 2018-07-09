package system.pack.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import system.pack.configuration.DevWebApplicationContext;


/*
  	this class is responsible for charge the main configuration of the project.
	it defines:
	-the application context of the project for development environment
	-the profile (DEV, QA) for the project in the development environment
	-defining a dispatcher servlet and what urls spring mvc will mapping for the project
 */

public class Initializer implements WebApplicationInitializer {


	public void onStartup(ServletContext servletContext) throws ServletException {

		// defining the type of the configuration archive of the project, in
		// this case a configuration based on annotations
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();

		// defining the configuration archive of the project for development
		// environment
		applicationContext.register(DevWebApplicationContext.class);
		
		//
		servletContext.addListener(new ContextLoaderListener(applicationContext));

		// defining the active profile for development environment
		applicationContext.getEnvironment().setActiveProfiles("DEV");
		
		//
		applicationContext.setServletContext(servletContext);

		// defining the dispatcher servlet and what urls spring mvc will mapping
		// for the project
		Dynamic servlet = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(applicationContext));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);

	}

}

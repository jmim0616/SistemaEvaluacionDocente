package system.pack.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@ControllerAdvice
@EnableWebMvc
public class ExceptionController {

	
	@ExceptionHandler(value = Exception.class)
	public String handleError(HttpServletRequest req, Exception exception) {
		
		System.out.println("Request: " + req.getRequestURL() + " raised " + exception);
		
		req.setAttribute("urlRequest", req.getRequestURL());
		
		req.setAttribute("exceptionMessage", exception);
		
		return "error-general";
	}
	

	
	
}
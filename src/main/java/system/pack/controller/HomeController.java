package system.pack.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


	
@Controller
@RequestMapping(value = "/")
public class HomeController {
	
	
	@GetMapping(value = "/")
	public String showHomePage(Model model, HttpSession session) {
		if (session.getAttribute("SessionId") != null){
			
			return "index";
		}
		else
		{
			return "login";
		}
		
		
	}

	
}

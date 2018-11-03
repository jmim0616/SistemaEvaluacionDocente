package system.pack.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import system.pack.bointerface.UserBoInterface;
import system.pack.entity.UserEntity;

@Controller
@RequestMapping(value = "/Login")
public class LoginController {

	@Autowired
	UserBoInterface UserBoInterface;

	@RequestMapping("/login")
	public String validateuser(Model model, HttpSession session, @RequestParam Map<String, String> requestParams) {
		
		UserEntity user = UserBoInterface.ValidateUser(requestParams.get("mask"), requestParams.get("passwd"));

		if (user != null) {
			session.setAttribute("SessionId", user.getMask());
			session.setAttribute("UserType", String.valueOf(user.getUserType()));
			session.setAttribute("UserId", String.valueOf(user.getUserId()));
		}
		else{
			return "login-error";
		}
		
		return "redirect:/";

	}
	
	@RequestMapping("/logOut")
	public String closeSession(Model model, HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/";
		
	}


}

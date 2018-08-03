package system.pack.controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import system.pack.bointerface.UserBoInterface;
import system.pack.entity.TeacherEntity;
import system.pack.entity.UserEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.FacultyBean;
import system.pack.vo.TeacherBean;
import system.pack.vo.UserBean;

@Controller
@RequestMapping(value="/Users")
public class UserController {
	
	@Autowired
	UserBoInterface UserBoInterface;
	
	@GetMapping(value = "/")
	public String showUsersView(Model model,  HttpSession session) {

		model.addAttribute("user", new UserBean());
		
		return "users";
	}

	@GetMapping(value = "/Create")
	public String showCreateUserView(Model model,  HttpSession session) {

		model.addAttribute("user", new UserBean());
		
		return "user-create";
	}
	
	@GetMapping(value = "/UpdateStatus")
	public String showUpdateUserStatusView(@RequestParam(name="userId") int userId, Model model) {
		
		model.addAttribute("user", new UserBean(userId));
		
		return "user-update-status";
		
	}
	

	@PostMapping(value = "/Create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<UserBean, UserEntity> createUser(@Valid @RequestBody UserBean userBean, BindingResult bindingResult) {

		System.out.println("00000" + userBean);
		
		JsonResponse<UserBean, UserEntity> jsonResponse = new JsonResponse<UserBean, UserEntity>();

		jsonResponse = UserBoInterface.createUser(userBean, bindingResult); 

		
		return jsonResponse;
	}
	
	@PostMapping(value = "/Search", produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<UserBean, UserEntity> searchUser() {
		
		JsonResponse<UserBean, UserEntity> jsonResponse = new JsonResponse<UserBean, UserEntity>();
		
		jsonResponse = UserBoInterface.search(); 
		
		return jsonResponse;
	}
	
	@GetMapping(value = "/Data")
	public String showDataUserView(Model model) {

		model.addAttribute("user", new UserBean());
		
		return "user-data";
		
	}
	
	@PostMapping(value = "/Update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<UserBean, UserEntity> updateUser(@Valid @RequestBody UserBean userBean, BindingResult bindingResult) {

		System.out.println("00000" + userBean);
		
		JsonResponse<UserBean, UserEntity> jsonResponse = new JsonResponse<UserBean, UserEntity>();
		

		jsonResponse = UserBoInterface.update(userBean, bindingResult); 
		
		return jsonResponse;	

	}
	
	@PostMapping(value = "/UpdateStatus", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<UserBean, UserEntity> updateStatusUser(@Valid @RequestBody UserBean userBean, BindingResult bindingResult) {

		System.out.println("00000" + userBean);
		
		JsonResponse<UserBean, UserEntity> jsonResponse = new JsonResponse<UserBean, UserEntity>();

		jsonResponse = UserBoInterface.updateStatus(userBean, bindingResult); 

		
		return jsonResponse;
	

	}

}

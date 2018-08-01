package system.pack.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import system.pack.boImplementation.TeacherBoImpl;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.bointerface.UserBoInterface;
import system.pack.daoInterface.TeacherDaoJpaRepository;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.UserEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.DepartmentBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;
import system.pack.vo.UserBean;


@Controller
@RequestMapping(value="/Users")
public class UserController {

	@Autowired
	UserBoInterface userBoInterface;
	
	@GetMapping(value = "/")
	public String showUsersView(Model model) {

		model.addAttribute("user", new UserBean());
		
		return "users";
	}
	
	
	@GetMapping(value = "/Create")
	public String showInsertUserView(Model model) {
		
		model.addAttribute("user", new UserBean());
		
		return "user-create";
		
	}
	
	
	@GetMapping(value = "/Data")
	public String showDataUserView(Model model) {

		return "user-data";
		
	}
	
	@GetMapping(value = "/Update")
	public String showUpdateUserView(Model model) {
		
		model.addAttribute("user", new UserBean());
		
		return "user-update";
		
	}
	
	@GetMapping(value = "/UpdateStatus")
	public String showUpdateUserStatusView(@RequestParam(name="userId") String userId, Model model) {
		
		model.addAttribute("user", new UserBean(userId));
		
		return "user-update-status";
		
	}
	

	
	@PostMapping(value = "/Create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<UserBean, UserEntity> createUser(@Valid @RequestBody UserBean userBean, BindingResult bindingResult) {

		System.out.println("00000" + userBean);
		
		JsonResponse<UserBean, UserEntity> jsonResponse = new JsonResponse<UserBean, UserEntity>();
		
		jsonResponse = userBoInterface.create(userBean, bindingResult); 
		
		return jsonResponse;
	}
	
	
	
	@PostMapping(value = "/Search", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<UserBean, UserEntity> searchUser() {

		System.out.println("00000" );
		
		JsonResponse<UserBean, UserEntity> jsonResponse = new JsonResponse<UserBean, UserEntity>();
		
		jsonResponse = userBoInterface.search(); 
		
		return jsonResponse;
		
	}
	
	
	@PostMapping(value = "/Update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<UserBean, UserEntity> updateUser(@Valid @RequestBody UserBean userBean, BindingResult bindingResult) {

		System.out.println("00000" + userBean);
		
		JsonResponse<UserBean, UserEntity> jsonResponse = new JsonResponse<UserBean, UserEntity>();
		
		jsonResponse = userBoInterface.update(userBean, bindingResult); 
		
		return jsonResponse;
	

	}
	
	
	@PostMapping(value = "/UpdateStatus", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<UserBean, UserEntity> updateStatusTeacher(@Valid @RequestBody UserBean userBean, BindingResult bindingResult) {

		System.out.println("00000" + userBean);
		
		JsonResponse<UserBean, UserEntity> jsonResponse = new JsonResponse<UserBean, UserEntity>();
		
		jsonResponse = userBoInterface.updateStatus(userBean, bindingResult); 
		
		return jsonResponse;
	

	}
	
	
}

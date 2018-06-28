package system.pack.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;


@Controller
@RequestMapping(value="/Teachers")
public class TeacherController {

	
	
	@GetMapping(value = "/")
	public String showTeachersView(Model model) {

		model.addAttribute("teacher", new TeacherBean());
		
		return "teachers";
	}
	
	
	@GetMapping(value = "/Create")
	public String showInsertTeacherView(Model model) {
		
		model.addAttribute("teacher", new TeacherBean());
		
		return "teacher-create";
		
	}
	
	@GetMapping(value = "/CreateExcel")
	public String showInsertTeacherExcelView(Model model) {
		
		model.addAttribute("teacher", new TeacherBean());
		
		return "teacher-create-excel";
		
	}
	
	@GetMapping(value = "/Data")
	public String showDataTeacherView(Model model) {

		return "teacher-data";
		
	}
	
	@GetMapping(value = "/Update")
	public String showUpdateTeacherView(Model model) {
		
		model.addAttribute("teacher", new TeacherBean());
		
		return "teacher-update";
		
	}
	

	@GetMapping(value = "/UpdateStatus")
	public String showUpdateStatusTeacherView(Model model) {
		
		model.addAttribute("teacher", new TeacherBean());
		
		return "modal";
		
	}
	
	
	@PostMapping(value = "/Create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<TeacherBean, TeacherEntity> createTeacher(@Valid @RequestBody TeacherBean teacherBean, BindingResult bindingResult) {

		System.out.println("00000" + teacherBean);
		
		JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();
		
		if (bindingResult.hasErrors()) {
			
			Map<String, String> errorMessages = bindingResult.getFieldErrors()
					.stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
			
			jsonResponse.setErrorMessages(errorMessages);
			
			jsonResponse.setIsValid(false);
			
		} 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/CreateExcel", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<TeacherBean, TeacherEntity> createTeacherExcel(@Valid @RequestBody TeacherBean teacherBean, BindingResult bindingResult) {

		System.out.println("00000" + teacherBean);

		JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/Search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse searchTeacher(@Valid @RequestBody TeacherBean teacherBean, BindingResult bindingResult) {

		System.out.println("11111" + teacherBean);
		
		JsonResponse jsonResponse = new JsonResponse();
		
		if (bindingResult.hasErrors()) {
			
			System.out.println(bindingResult);
			
			Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

			jsonResponse.setErrorMessages(errorMessages);
			
			jsonResponse.setIsValid(false);
			
		}
		
		return jsonResponse;
		
	}
	
	
	@PostMapping(value = "/Update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse updateTeacher(@Valid @RequestBody TeacherBean teacherBean, BindingResult bindingResult) {

		System.out.println("11111" + teacherBean);
		
		JsonResponse jsonResponse = new JsonResponse();
		
		if (bindingResult.hasErrors()) {
			
			System.out.println(bindingResult);
			
			Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
					.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

			jsonResponse.setErrorMessages(errorMessages);
			
			jsonResponse.setIsValid(false);
			
		}
		
		return jsonResponse;
		
	}
	
	
	
}

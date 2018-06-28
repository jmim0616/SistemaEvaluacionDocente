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
import org.springframework.util.SystemPropertyUtils;
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


import system.pack.helper.JsonResponse;
import system.pack.vo.DepartmentBean;
import system.pack.vo.TeacherBean;


@Controller
@RequestMapping(value="/Departments")
public class DepartmentController {

	
	
	@GetMapping(value = "/")
	public String showDepartmentsView(Model model) {

		model.addAttribute("department", new DepartmentBean());
		
		return "departments";
	}
	
	
	@GetMapping(value = "/Create")
	public String showInsertDepartmentView(Model model) {
		
		model.addAttribute("department", new DepartmentBean());
		
		return "department-create";
		
	}
	
	@GetMapping(value = "/Data")
	public String showDataDepartmentView(Model model) {

		return "department-data";
		
	}
	
	@GetMapping(value = "/Update")
	public String showUpdateDepartmentView(Model model) {
		
		model.addAttribute("department", new DepartmentBean());
		
		return "department-update";
		
	}

	
	@PostMapping(value = "/Create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse createDepartment(@Valid @RequestBody DepartmentBean departmentBean, BindingResult bindingResult) {
		
		System.out.println("00000" + departmentBean);
		
		JsonResponse jsonResponse = new JsonResponse();
		
		if (bindingResult.hasErrors()) {
			
			Map<String, String> errorMessages = bindingResult.getFieldErrors()
					.stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
			
			jsonResponse.setErrorMessages(errorMessages);

			
			jsonResponse.setIsValid(false);
			
			
			
		} 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/Search", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse searchDepartment() {

		
		JsonResponse jsonResponse = new JsonResponse();

		return jsonResponse;
		
	}
	
	
	@PostMapping(value = "/Update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse updateDepartment(@Valid @RequestBody DepartmentBean departmentBean, BindingResult bindingResult) {

		System.out.println("11111" + departmentBean);
		
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

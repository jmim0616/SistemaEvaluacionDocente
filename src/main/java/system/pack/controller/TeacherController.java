package system.pack.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.springframework.ui.ModelMap;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import system.pack.boImplementation.TeacherBoImpl;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.daoInterface.TeacherDaoJpaRepository;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;


@Controller
@RequestMapping(value="/Teachers")
public class TeacherController {

	
	@Autowired
	TeacherBoInterface teacherBoInterface;
	
	@Autowired
	CommonsMultipartResolver multipartResolver;
	
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
		
		//System.out.println(excelfile.toString());
		
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
	public String showUpdateTeacherStatusView(@RequestParam(name="teacherId") String teacherId, Model model) {
		
		model.addAttribute("teacher", new TeacherBean(teacherId));
		
		return "teacher-update-status";
		
	}
	
	
	@PostMapping(value = "/Create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<TeacherBean, TeacherEntity> createTeacher(@Valid @RequestBody TeacherBean teacherBean, BindingResult bindingResult) {

		System.out.println("00000" + teacherBean);
		
		JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();
		
		jsonResponse = teacherBoInterface.create(teacherBean, bindingResult); 
		
		return jsonResponse;
	}
	
	@PostMapping("/CreateExcel")
	public String createTeacherExcel( 
			MultipartFile file) throws IOException {
	    
	    teacherBoInterface.createExcel(file);
		
		System.out.println("00000  Holi" + "");//teacherBean);

		JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();
		
		return "teacher-create-excel";
	}
	
	
	@PostMapping(value = "/Search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<TeacherBean, TeacherEntity> searchTeacher(@Valid @RequestBody TeacherBean teacherBean, BindingResult bindingResult) {

		System.out.println("00000" + teacherBean);
		
		JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();
		
		jsonResponse = teacherBoInterface.search(teacherBean, bindingResult); 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/Update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<TeacherBean, TeacherEntity> updateTeacher(@Valid @RequestBody TeacherBean teacherBean, BindingResult bindingResult) {

		System.out.println("00000" + teacherBean);
		
		JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();
		
		jsonResponse = teacherBoInterface.update(teacherBean, bindingResult); 
		
		return jsonResponse;
	

	}
	
	
	@PostMapping(value = "/UpdateStatus", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<TeacherBean, TeacherEntity> updateStatusTeacher(@Valid @RequestBody TeacherBean teacherBean, BindingResult bindingResult) {

		System.out.println("00000" + teacherBean);
		
		JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();
		
		jsonResponse = teacherBoInterface.updateStatus(teacherBean, bindingResult); 
		
		return jsonResponse;
	

	}
	
}

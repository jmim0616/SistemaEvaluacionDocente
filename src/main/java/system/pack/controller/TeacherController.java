package system.pack.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import system.pack.bointerface.TeacherBoInterface;
import system.pack.daoInterface.TeacherDaoJpaRepository;
import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.SubjectEntity;
import system.pack.bointerface.UserBoInterface;
import system.pack.entity.TeacherEntity;
import system.pack.entity.UserEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.AcademicProgramBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;


@Controller
@RequestMapping(value="/Teachers")
public class TeacherController {

	@Autowired
	UserBoInterface UserBoInterface;
	
	@Autowired
	TeacherBoInterface teacherBoInterface;
	
	@GetMapping(value = "/")
	public ModelAndView showTeachersView(Model model,  HttpSession session) {

		model.addAttribute("teacher", new TeacherBean());
		ModelAndView modelAndView = new ModelAndView();
		session.getId();
		modelAndView.addObject("thought", session.getId());
		session.setAttribute("thought", "Holi" );
		
		modelAndView.setViewName("teachers");
		System.out.println(session.getAttribute("thought"));
		
		return modelAndView;
	}	
	
	@GetMapping(value = "/Create")
	public ModelAndView showInsertTeacherView(Model model, HttpSession session) {
		
		model.addAttribute("teacher", new TeacherBean());
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(session.getAttribute("thought"));
		modelAndView.addObject("thought", "Testing");
		
		modelAndView.setViewName("teacher-create");
		return modelAndView;
		
	}
	
	@GetMapping(value = "/CreateExcel")
	public String showInsertTeacherExcelView(Model model, HttpSession session) {
		
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
	
	@GetMapping(value = "/AddSubjects")
	public String showAddSubjectsTeacherView(Model model) {
		
		model.addAttribute("teacher", new TeacherBean());
		
		return "teacher-add-subjects";
		
	}
	
	@GetMapping(value = "/Search")
	public String showSearchTeacherView(Model model) {

		return "teacher-search";
		
	}
	
	@PostMapping(value = "/GetTeachers",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<TeacherBean, TeacherEntity> getTeachers() {

		System.out.println("00000" );
		
		JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();
		
		jsonResponse = teacherBoInterface.getAllTeachers(); 
		
		return jsonResponse;
	}
	
	@PostMapping(value = "/GetSubjects",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<SubjectBean, SubjectEntity> getSubjects() {

		System.out.println("00000" );
		
		JsonResponse<SubjectBean, SubjectEntity> jsonResponse = new JsonResponse<SubjectBean, SubjectEntity>();
		
		jsonResponse = teacherBoInterface.getAllSubjects(); 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/Create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<TeacherBean, TeacherEntity> createTeacher(@Valid @RequestBody TeacherBean teacherBean, BindingResult bindingResult) {

		System.out.println("00000" + teacherBean);
		
		JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();
		
		jsonResponse = teacherBoInterface.create(teacherBean, bindingResult); 
		
		return jsonResponse;
	}
	
	@PostMapping(value = "/CreateExcel", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<TeacherBean, TeacherEntity> createTeacherExcel( 
			MultipartFile file) throws IOException {
		
		JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<>();
	   
		if (file.getSize() == 0){
			jsonResponse.setErrorMessage("Debe seleccionar un archivo en formato Excel.");
			return jsonResponse;
		}
		
	    String response = teacherBoInterface.createExcel(file);
	    
	    if (response == ""){
	    	jsonResponse.setSuccessMessage("El archivo ha sido procesado exitosamente.");
	    }
	    else
	    {
	    	jsonResponse.setErrorMessage(response);
	    }
	
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/Search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<SubjectByTeacherBean, SubjectByTeacherEntity> searchTeacher(@Valid @RequestBody TeacherBean teacherBean, BindingResult bindingResult) {

		System.out.println("00000" + teacherBean);
		
		JsonResponse<SubjectByTeacherBean, SubjectByTeacherEntity> jsonResponse = new JsonResponse<SubjectByTeacherBean, SubjectByTeacherEntity>();
		
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
	
	@PostMapping(value = "/AddSubjects", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<TeacherBean, TeacherEntity> addSubjectsTeacher(@RequestBody SubjectByTeacherBean subjectByTeacherBean, BindingResult bindingResult) {

		System.out.println("00000" + subjectByTeacherBean);
		
		JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();
		
		jsonResponse = teacherBoInterface.addSubjects(subjectByTeacherBean, bindingResult); 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/SearchSubjectsByTeacher", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<TeacherBean, TeacherEntity> searchSubjecstByTeacher(@RequestBody TeacherBean teacherBean, BindingResult bindingResult) {

		System.out.println("00000" + teacherBean);
		
		JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();
		
		jsonResponse = teacherBoInterface.searchSubjecstByTeacher(teacherBean, bindingResult); 
		
		return jsonResponse;
	}
	
}

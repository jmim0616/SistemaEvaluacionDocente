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
import system.pack.bointerface.CourseBoInterface;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.daoInterface.TeacherDaoJpaRepository;
import system.pack.entity.CourseEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.ClassVisitBean;
import system.pack.vo.CoevaluationBean;
import system.pack.vo.CourseBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;


@Controller
@RequestMapping(value="/Courses")
public class CourseController {

	
	@Autowired
	CourseBoInterface CourseBoInterface;
	
	@GetMapping(value = "/")
	public String showCoursesView(Model model) {

		model.addAttribute("course", new CourseBean());
		
		return "courses";
	}
	
	
	@GetMapping(value = "/Create")
	public String showInsertCourseView(Model model) {
		
		model.addAttribute("course", new CourseBean());
		
		return "course-create";
		
	}
	

	
	@GetMapping(value = "/Data")
	public String showDataCourseView(Model model) {

		return "course-data";
		
	}
	
	@GetMapping(value = "/Update")
	public String showUpdateCourseView(Model model) {
		
		model.addAttribute("course", new CourseBean());
		
		return "course-update";
		
	}
	
	@GetMapping(value = "/Search")
	public String showSearchCourseView(Model model) {

		return "course-search";
		
	}
	
	
	@PostMapping(value = "/Create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> createCourse(@Valid @RequestBody CourseBean courseBean, BindingResult bindingResult) {

		System.out.println("00000" + courseBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = CourseBoInterface.create(courseBean, bindingResult); 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/Search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> searchCourse(@Valid @RequestBody CourseBean courseBean, BindingResult bindingResult) {

		System.out.println("00000" + courseBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = CourseBoInterface.search(courseBean, bindingResult); 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/Update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> updateCourse(@Valid @RequestBody CourseBean courseBean, BindingResult bindingResult) {

		System.out.println("00000" + courseBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = CourseBoInterface.update(courseBean, bindingResult); 
		
		return jsonResponse;
	

	}
	
	@PostMapping(value = "/Delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> deleteCourse(@Valid @RequestBody CourseBean courseBean, BindingResult bindingResult) {

		System.out.println("00000" + courseBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = CourseBoInterface.delete(courseBean, bindingResult); 
		
		return jsonResponse;
	

	}
	
	
	@PostMapping(value = "/AddCoevaluation", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> addCoevaluationCourse(@RequestBody CoevaluationBean coevaluationBean, BindingResult bindingResult) {

		System.out.println("00000" + coevaluationBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = CourseBoInterface.addCoevaluation(coevaluationBean, bindingResult); 
		
		return jsonResponse;
	}
	
	@PostMapping(value = "/AddClassVisits", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> addCoevaluationCourse(@RequestBody ClassVisitBean classVisitBean, BindingResult bindingResult) {

		System.out.println("00000" + classVisitBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = CourseBoInterface.addClassVisits(classVisitBean, bindingResult); 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/SearchAcademicPeriodsBySubjectOfTeacher", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> searchAcademicPeriodsBySubjectOfTeacher(@RequestBody SubjectBean subjectBean, BindingResult bindingResult) {

		System.out.println("00000" + subjectBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = CourseBoInterface.searchAcademicPeriodsBySubjectOfTeacher(subjectBean, bindingResult); 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/SearchEvaluationsByAcademicPeriodOfTeacher", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> searchEvaluationsByAcademicPeriodOfTeacher(@RequestBody SubjectBean subjectBean, BindingResult bindingResult) {

		System.out.println("00000" + subjectBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = CourseBoInterface.searchEvaluationsByAcademicPeriodOfTeacher(subjectBean, bindingResult); 
		
		return jsonResponse;
	}
	
	@PostMapping(value = "/SearchEvaluationsByCourse", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> searchEvaluationsByCourse(@RequestBody CourseBean courseBean, BindingResult bindingResult) {

		System.out.println("00000" + courseBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = CourseBoInterface.searchEvaluationsByCourse(courseBean, bindingResult); 
		
		return jsonResponse;
	}
	
	@PostMapping(value = "/SearchCoursesBySubject", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> searchCoursesBySubject(@RequestBody SubjectBean subjectBean, BindingResult bindingResult) {

		System.out.println("00000" + subjectBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = CourseBoInterface.searchCoursesBySubject(subjectBean, bindingResult); 
		
		return jsonResponse;
	}
	
}

package system.pack.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import system.pack.boImplementation.TeacherBoImpl;
import system.pack.bointerface.CourseBoInterface;
import system.pack.bointerface.DepartmentBoInterface;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.daoInterface.TeacherDaoJpaRepository;
import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.CourseEntity;
import system.pack.entity.CourseFeedbackEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.fullview.Data;
import system.pack.fullview.Period;
import system.pack.fullview.Questions;
import system.pack.fullview.Row;
import system.pack.helper.JsonResponse;
import system.pack.vo.CourseFeedbackBean;
import system.pack.vo.AcademicPeriodBean;
import system.pack.vo.CourseBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;


@Controller
@RequestMapping(value="/Courses")
public class CourseController {

	
	@Autowired
	CourseBoInterface courseBoInterface;
	
	
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
	

	
	@GetMapping(value = "/CreateExcel")
	public String showCreateExcelView(Model model) {

		return "course-create-excel";
		
	}

	@GetMapping(value = "/CreateOnlineFeedBack")
	public String showCreateNotesView(Model model) {

		return "course-create-notes";
		
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
	
	
	
	@GetMapping(value = "/AddFeedback")
	public String showAddFeedbackCourseView(@RequestParam(name="groupId") String groupId, Model model) {
		
		model.addAttribute("courseFeedback", new CourseFeedbackBean(groupId));

		return "course-add-feedbacks";
		
	}
	
	
	@GetMapping(value = "/Delete")
	public String showDeleteCourseView(@RequestParam(name="groupId") String groupId, Model model) {
		
		model.addAttribute("course", new CourseBean(groupId));

		return "course-delete";
		
	}
	
	@PostMapping(value = "/GetCourses",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity>getCourses() {

		System.out.println("00000" );
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = courseBoInterface.getAllCourses(); 
		
		return jsonResponse;
	}
	
	@PostMapping(value = "/GetSubjects",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<SubjectBean, SubjectEntity> getSubjects() {

		System.out.println("00000" );
		
		JsonResponse<SubjectBean, SubjectEntity> jsonResponse = new JsonResponse<SubjectBean, SubjectEntity>();
		
		jsonResponse = courseBoInterface.getAllSubjects(); 
		
		return jsonResponse;
	}
	
	@PostMapping(value = "/GetTeachers",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<TeacherBean, TeacherEntity> getTeachers() {

		System.out.println("00000" );
		
		JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();
		
		jsonResponse = courseBoInterface.getAllTeachers(); 
		
		return jsonResponse;
	}
	
	@PostMapping(value = "/GetAcademicPeriods",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> getAcademicPeriods() {

		System.out.println("00000" );
		
		JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> jsonResponse = new JsonResponse<AcademicPeriodBean, AcademicPeriodEntity>();
		
		jsonResponse = courseBoInterface.getAllAcademicPeriods(); 
		
		return jsonResponse;
	}
	
	@PostMapping(value = "/ValidateCourseFeedbacksAdd",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<CourseFeedbackBean, CourseFeedbackEntity> validateCourseFeedbacksAdd() {

		System.out.println("00000" );
		
		JsonResponse<CourseFeedbackBean, CourseFeedbackEntity> jsonResponse = new JsonResponse<CourseFeedbackBean, CourseFeedbackEntity>();
		
		jsonResponse = courseBoInterface.validateCourseFeedbacksAdd(); 
		
		return jsonResponse;
	}
	
	@PostMapping(value = "/CreateExcel", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> createCourseExcel( 
			MultipartFile file) throws IOException {
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<>();
	   
		if (file.getSize() == 0){
			jsonResponse.setErrorMessage("Debe seleccionar un archivo en formato Excel.");
			return jsonResponse;
		}
		
	    String response = courseBoInterface.createExcel(file);
	    
	    if (response == ""){
	    	jsonResponse.setSuccessMessage("El archivo ha sido procesado exitosamente.");
	    }
	    else
	    {
	    	jsonResponse.setErrorMessage(response);
	    }
	
		return jsonResponse;
	}
	
	@PostMapping(value = "/CreateOnlineFeedBack", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> createOnlineFeedBack( 
			MultipartFile file) throws IOException {
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<>();
	   
		if (file.getSize() == 0){
			jsonResponse.setErrorMessage("Debe seleccionar un archivo en formato Excel.");
			return jsonResponse;
		}
		
	    String response = courseBoInterface.createOnlineFeedBack(file, 1);
	    
	    if (response == ""){
	    	jsonResponse.setSuccessMessage("El archivo ha sido procesado exitosamente.");
	    }
	    else
	    {
	    	jsonResponse.setErrorMessage(response);
	    }
	
		return jsonResponse;
	}
	
	@PostMapping(value = "/Create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> createCourse(@Valid @RequestBody CourseBean courseBean, BindingResult bindingResult) {

		System.out.println("00000" + courseBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = courseBoInterface.create(courseBean, bindingResult); 
		
		return jsonResponse;
	}
	
	@PostMapping(value = "/CompareView", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public Data createtest(@RequestBody CourseBean courseBean) {		
		
		Questions q1 =  new Questions("Q1", 10);
		Questions q2 =  new Questions("Q2", 20);
		Questions q3 =  new Questions("Q3", 30);
		
		List<Questions> listq = new LinkedList<>();
		listq.add(q1);
		listq.add(q2);
		listq.add(q3);		
		
		Row row = new Row("2018-01", "Sistemas", "Ing sof 1", 1024, 5, listq);
		
		List<Row> rows = new LinkedList<>();
		rows.add(row);
		
		Period period = new Period(rows);
		List<Period> periods = new LinkedList<>();
		periods.add(period);
		
		return new Data(periods);
	}
	
	
	
	@PostMapping(value = "/Search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> searchCourse(@Valid @RequestBody CourseBean courseBean, BindingResult bindingResult) {

		System.out.println("00000" + courseBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = courseBoInterface.search(courseBean, bindingResult); 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/Update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> updateCourse(@Valid @RequestBody CourseBean courseBean, BindingResult bindingResult) {

		System.out.println("00000" + courseBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = courseBoInterface.update(courseBean, bindingResult); 
		
		return jsonResponse;
	

	}
	
	@PostMapping(value = "/Delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> deleteCourse(@Valid @RequestBody CourseBean courseBean, BindingResult bindingResult) {

		System.out.println("00000" + courseBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = courseBoInterface.delete(courseBean, bindingResult); 
		
		return jsonResponse;
	

	}
	
	
	@PostMapping(value = "/AddFeedback", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> addCoevaluationCourse(@RequestBody CourseFeedbackBean courseFeedbackBean, BindingResult bindingResult) {

		System.out.println("00000" + courseFeedbackBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = courseBoInterface.addCourseFeedback(courseFeedbackBean, bindingResult); 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/SearchAcademicPeriodsBySubjectOfTeacher", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> searchAcademicPeriodsBySubjectOfTeacher(@RequestBody SubjectBean subjectBean, BindingResult bindingResult) {

		System.out.println("00000" + subjectBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = courseBoInterface.searchAcademicPeriodsBySubjectOfTeacher(subjectBean, bindingResult); 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/SearchEvaluationsByAcademicPeriodOfTeacher", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> searchEvaluationsByAcademicPeriodOfTeacher(@RequestBody SubjectBean subjectBean, BindingResult bindingResult) {

		System.out.println("00000" + subjectBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = courseBoInterface.searchEvaluationsByAcademicPeriodOfTeacher(subjectBean, bindingResult); 
		
		return jsonResponse;
	}
	
	@PostMapping(value = "/SearchEvaluationsByCourse", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> searchEvaluationsByCourse(@RequestBody CourseBean courseBean, BindingResult bindingResult) {

		System.out.println("00000" + courseBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = courseBoInterface.searchEvaluationsByCourse(courseBean, bindingResult); 
		
		return jsonResponse;
	}
	
	@PostMapping(value = "/SearchCoursesBySubject", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<CourseBean, CourseEntity> searchCoursesBySubject(@RequestBody SubjectBean subjectBean, BindingResult bindingResult) {

		System.out.println("00000" + subjectBean);
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		jsonResponse = courseBoInterface.searchCoursesBySubject(subjectBean, bindingResult); 
		
		return jsonResponse;
	}
	
}

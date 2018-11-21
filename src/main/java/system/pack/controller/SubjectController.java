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
import system.pack.bointerface.SubjectBoInterface;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.daoInterface.TeacherDaoJpaRepository;
import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.SubjectByProgramEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.AcademicProgramBean;
import system.pack.vo.DepartmentBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.SubjectByProgramBean;
import system.pack.vo.TeacherBean;


@Controller
@RequestMapping(value="/Subjects")
public class SubjectController {

	
	@Autowired
	SubjectBoInterface subjectBoInterface;
	
	@GetMapping(value = "/")
	public String showSubjectsView(Model model) {

		model.addAttribute("subject", new SubjectBean());
		
		return "subjects";
	}
	
	
	@GetMapping(value = "/Create")
	public String showInsertSubjectView(Model model) {
		
		model.addAttribute("subject", new SubjectBean());
		
		model.addAttribute("disciplinaryAreas", subjectBoInterface.getAllDisciplinaryAreas().getObjectEntityList());
		
		return "subject-create";
		
	}
	
	@GetMapping(value = "/CreateExcel")
	public String showInsertTeacherExcelView(Model model) {
		
		model.addAttribute("subject", new SubjectBean());
		
		return "subject-create-excel";
		
	}
	
	@GetMapping(value = "/Data")
	public String showDataSubjectView(Model model) {

		model.addAttribute("subject", new SubjectBean());
		
		return "subject-data";
		
	}
	
	@GetMapping(value = "/Update")
	public String showUpdateSubjectView(Model model) {

		model.addAttribute("subject", new SubjectBean());
		
		model.addAttribute("disciplinaryAreas", subjectBoInterface.getAllDisciplinaryAreas().getObjectEntityList());
		
		return "subject-update";
		
	}
	
	@GetMapping(value = "/UpdateStatus")
	public String showUpdateSubjectStatusView(@RequestParam(name="subjectId") String subjectId, Model model) {
		
		model.addAttribute("subject", new SubjectBean(subjectId));
		
		return "subject-update-status";
		
	}
	
	
	@PostMapping(value = "/GetSubjects",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<SubjectBean, SubjectEntity> getSubjects() {

		System.out.println("00000" );
		
		JsonResponse<SubjectBean, SubjectEntity> jsonResponse = new JsonResponse<SubjectBean, SubjectEntity>();
		
		jsonResponse = subjectBoInterface.getAllSubjects(); 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/GetAcademicPrograms",  produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<AcademicProgramBean, AcademicProgramEntity> getAcademicPrograms() {

		System.out.println("00000" );
		
		JsonResponse<AcademicProgramBean, AcademicProgramEntity> jsonResponse = new JsonResponse<AcademicProgramBean, AcademicProgramEntity>();
		
		jsonResponse = subjectBoInterface.getAllAcademicPrograms(); 
		
		return jsonResponse;
	}
	
	@PostMapping(value = "/Create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<SubjectBean, SubjectEntity> createSubject(@Valid @RequestBody SubjectBean subjectBean, BindingResult bindingResult) {

		System.out.println("00000" + subjectBean);
		
		JsonResponse<SubjectBean, SubjectEntity> jsonResponse = new JsonResponse<SubjectBean, SubjectEntity>();
		
		jsonResponse = subjectBoInterface.create(subjectBean, bindingResult); 
		
		return jsonResponse;
		
	}
	
	@PostMapping(value = "/CreateExcel", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<SubjectBean, SubjectEntity> createTeacherExcel(@Valid @RequestBody SubjectBean subjectBean, BindingResult bindingResult) {

		System.out.println("00000" + subjectBean);

		JsonResponse<SubjectBean, SubjectEntity> jsonResponse = new JsonResponse<SubjectBean, SubjectEntity>();
		
		return jsonResponse;
	}
	
	@PostMapping(value = "/Search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<SubjectByProgramBean, SubjectByProgramEntity> searchSubject(@RequestBody SubjectBean subjectBean, BindingResult bindingResult) {

		System.out.println("00000" + subjectBean);
		
		JsonResponse<SubjectByProgramBean, SubjectByProgramEntity>  jsonResponse = new JsonResponse<SubjectByProgramBean, SubjectByProgramEntity>();
		
		jsonResponse = subjectBoInterface.search(subjectBean, bindingResult); 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/Update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<SubjectBean, SubjectEntity> updateSubject(@Valid @RequestBody SubjectBean subjectBean, BindingResult bindingResult) {

		System.out.println("00000" + subjectBean);
		
		JsonResponse<SubjectBean, SubjectEntity> jsonResponse = new JsonResponse<SubjectBean, SubjectEntity>();
		
		jsonResponse = subjectBoInterface.update(subjectBean, bindingResult); 
		
		return jsonResponse;
	

	}
	
	
	@PostMapping(value = "/UpdateStatus", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<SubjectBean, SubjectEntity> updateStatusSubject(@Valid @RequestBody SubjectBean subjectBean, BindingResult bindingResult) {

		System.out.println("00000" + subjectBean);
		
		JsonResponse<SubjectBean, SubjectEntity> jsonResponse = new JsonResponse<SubjectBean, SubjectEntity>();
		
		jsonResponse = subjectBoInterface.updateStatus(subjectBean, bindingResult); 
		
		return jsonResponse;
	

	}
	
	
}

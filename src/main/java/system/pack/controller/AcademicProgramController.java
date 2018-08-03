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

import system.pack.bointerface.AcademicProgramBoInterface;
import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.AcademicProgramBean;
import system.pack.vo.DepartmentBean;
import system.pack.vo.FacultyBean;
import system.pack.vo.SubjectByProgramBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;


@Controller
@RequestMapping(value="/AcademicPrograms")
public class AcademicProgramController {

	@Autowired
	AcademicProgramBoInterface academicProgramBoInterface;
	
	@GetMapping(value = "/")
	public String showAcademicProgramsView(Model model) {

		model.addAttribute("academicProgram", new AcademicProgramBean());
		
		return "academicPrograms";
	}
	
	
	@GetMapping(value = "/Create")
	public String showInsertAcademicProgramView(Model model) {
		
		model.addAttribute("academicProgram", new AcademicProgramBean());
		
		model.addAttribute("faculties", academicProgramBoInterface.getAllFaculties().getObjectEntityList());
		
		return "academicProgram-create";
		
	}
	
	@GetMapping(value = "/Data")
	public String showDataAcademicProgramView(Model model) {

		model.addAttribute("academicProgram", new AcademicProgramBean());
		
		model.addAttribute("faculties", academicProgramBoInterface.getAllFaculties().getObjectEntityList());
		
		return "academicProgram-data";
		
	}
	
	@GetMapping(value = "/Update")
	public String showUpdateAcademicProgramView(Model model) {
		
		model.addAttribute("academicProgram", new AcademicProgramBean());
		
		model.addAttribute("faculties", academicProgramBoInterface.getAllFaculties().getObjectEntityList());
		
		return "academicProgram-update";
		
	}
	
	@GetMapping(value = "/addSubjects")
	public String showAddSubjectsAcademicProgramView(Model model) {
		
		model.addAttribute("academicProgram", new AcademicProgramBean());
		
		return "academicProgram-add-subject";
		
	}

	
	@PostMapping(value = "/Create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<AcademicProgramBean, AcademicProgramEntity> createAcademicProgram(@Valid @RequestBody AcademicProgramBean academicProgramBean, BindingResult bindingResult) {
		
	System.out.println("00000" + academicProgramBean);
		
		JsonResponse<AcademicProgramBean, AcademicProgramEntity> jsonResponse = new JsonResponse<AcademicProgramBean, AcademicProgramEntity>();
		
		jsonResponse = academicProgramBoInterface.create(academicProgramBean, bindingResult); 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/Search", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<AcademicProgramBean, AcademicProgramEntity> searchAcademicProgram() {

		System.out.println("00000");
		
		JsonResponse<AcademicProgramBean, AcademicProgramEntity> jsonResponse = new JsonResponse<AcademicProgramBean, AcademicProgramEntity>();
		
		jsonResponse = academicProgramBoInterface.search(); 
		
		return jsonResponse;
		
	}
	
	
	@PostMapping(value = "/Update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<AcademicProgramBean, AcademicProgramEntity> updateAcademicProgram(@Valid @RequestBody AcademicProgramBean academicProgramBean, BindingResult bindingResult) {

	System.out.println("00000" + academicProgramBean);
		
		JsonResponse<AcademicProgramBean, AcademicProgramEntity> jsonResponse = new JsonResponse<AcademicProgramBean, AcademicProgramEntity>();
		
		jsonResponse = academicProgramBoInterface.update(academicProgramBean, bindingResult); 
		
		return jsonResponse;
		
	}
	

	
}

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

import system.pack.bointerface.DisciplinaryAreaBoInterface;
import system.pack.daoInterface.DisciplinaryAreaDaoInterface;
import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.DisciplinaryAreaEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.AcademicProgramBean;
import system.pack.vo.DepartmentBean;
import system.pack.vo.DisciplinaryAreaBean;
import system.pack.vo.FacultyBean;
import system.pack.vo.TeacherBean;


@Controller
@RequestMapping(value="/DisciplinaryAreas")
public class DisciplinaryAreaController {

	@Autowired
	DisciplinaryAreaBoInterface disciplinaryAreaBoInterface;
	
	@GetMapping(value = "/")
	public String showDisciplinaryAreasView(Model model) {

		model.addAttribute("disciplinaryArea", new DisciplinaryAreaBean());
		
		return "disciplinaryAreas";
	}
	
	
	@GetMapping(value = "/Create")
	public String showInsertDisciplinaryAreaView(Model model) {
		
		model.addAttribute("disciplinaryArea", new DisciplinaryAreaBean());
		
		model.addAttribute("faculties", disciplinaryAreaBoInterface.getFaculty().getObjectEntityList());
		
		return "disciplinaryArea-create";
		
	}
	
	@GetMapping(value = "/Data")
	public String showDataDisciplinaryAreaView(Model model) {

		model.addAttribute("disciplinaryArea", new DisciplinaryAreaBean());
		
		model.addAttribute("faculties", disciplinaryAreaBoInterface.getFaculty().getObjectEntityList());
		
		return "disciplinaryArea-data";
		
	}
	
	@GetMapping(value = "/Update")
	public String showUpdateDisciplinaryAreaView(Model model) {
		
		model.addAttribute("disciplinaryArea", new DisciplinaryAreaBean());
		
		model.addAttribute("faculties", disciplinaryAreaBoInterface.getFaculty().getObjectEntityList());
		
		return "disciplinaryArea-update";
		
	}

	
	@PostMapping(value = "/Create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity> createDisciplinaryArea(@Valid @RequestBody DisciplinaryAreaBean disciplinaryAreaBean, BindingResult bindingResult) {
	
		System.out.println("00000" + disciplinaryAreaBean);
		
		JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity> jsonResponse = new JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity>();
		
		jsonResponse = disciplinaryAreaBoInterface.create(disciplinaryAreaBean, bindingResult); 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/Search", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity> searchDisciplinaryArea() {

		System.out.println("00000");
		
		JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity> jsonResponse = new JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity>();
		
		jsonResponse = disciplinaryAreaBoInterface.search(); 
		
		return jsonResponse;
		
	}
	
	
	@PostMapping(value = "/Update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity> updateDisciplinaryArea(@Valid @RequestBody DisciplinaryAreaBean disciplinaryAreaBean, BindingResult bindingResult) {

		System.out.println("00000");
		
		JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity> jsonResponse = new JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity>();
		
		jsonResponse = disciplinaryAreaBoInterface.update(disciplinaryAreaBean, bindingResult); 
		
		return jsonResponse;
		
	}
	
	
	
}

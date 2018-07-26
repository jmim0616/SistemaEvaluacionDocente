package system.pack.controller;

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

import system.pack.bointerface.AcademicPeriodBoInterface;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.AcademicPeriodBean;
import system.pack.vo.TeacherBean;

@Controller
@RequestMapping(value="/AcademicPeriods")
public class AcademicPeriodController {


	@Autowired
	AcademicPeriodBoInterface academicPeriodBoInterface;
	
	@GetMapping(value = "/")
	public String showAcademicPeriodsView(Model model) {

		model.addAttribute("academicPeriod", new AcademicPeriodBean());
		
		return "academicPeriods";
	}
	
	
	@GetMapping(value = "/Create")
	public String showInsertAcademicPeriodView(Model model) {
		
		model.addAttribute("academicPeriod", new AcademicPeriodBean());
		
		return "academicPeriod-create";
		
	}
	
	
	@GetMapping(value = "/Data")
	public String showDataAcademicPeriodView(Model model) {

		return "academicPeriod-data";
		
	}
	
	@GetMapping(value = "/Update")
	public String showUpdateAcademicPeriodView(Model model) {
		
		model.addAttribute("academicPeriod", new AcademicPeriodBean());
		
		return "academicPeriod-update";
		
	}
	
	
	@PostMapping(value = "/Create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> createAcademicPeriod(@Valid @RequestBody AcademicPeriodBean academicPeriodBean, BindingResult bindingResult) {

		System.out.println("00000" + academicPeriodBean);
		
		JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> jsonResponse = new JsonResponse<AcademicPeriodBean, AcademicPeriodEntity>();
		
		jsonResponse = academicPeriodBoInterface.create(academicPeriodBean, bindingResult); 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/Search", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> searchAcademicPeriod(@Valid @RequestBody AcademicPeriodBean academicPeriodBean, BindingResult bindingResult) {

		System.out.println("00000" + academicPeriodBean);
		
		JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> jsonResponse = new JsonResponse<AcademicPeriodBean, AcademicPeriodEntity>();
		
		jsonResponse = academicPeriodBoInterface.search(academicPeriodBean, bindingResult); 
		
		return jsonResponse;
	}
	
	
	@PostMapping(value = "/Update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> updateAcademicPeriod(@Valid @RequestBody AcademicPeriodBean academicPeriodBean, BindingResult bindingResult) {

		System.out.println("00000" + academicPeriodBean);
		
		JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> jsonResponse = new JsonResponse<AcademicPeriodBean, AcademicPeriodEntity>();
		
		jsonResponse = academicPeriodBoInterface.update(academicPeriodBean, bindingResult); 
		
		return jsonResponse;
	

	}
	

	
}

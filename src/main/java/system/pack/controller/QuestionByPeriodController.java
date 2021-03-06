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
import system.pack.bointerface.QuestionByPeriodBoInterface;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.daoInterface.TeacherDaoJpaRepository;
import system.pack.entity.QuestionByPeriodEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.QuestionBean;
import system.pack.vo.QuestionByPeriodBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;


@Controller
@RequestMapping(value="/QuestionsByPeriod")
public class QuestionByPeriodController {

	
	@Autowired
	QuestionByPeriodBoInterface questionByPeriodBoInterface;
	
	@GetMapping(value = "/")
	public String showTeachersView(Model model) {

		model.addAttribute("questionByPeriodBean", new QuestionByPeriodBean());
		
		return "questionsByPeriodBean";
	}
	
	
	@GetMapping(value = "/Create")
	public String showInsertTeacherView(Model model) {
		
		model.addAttribute("questionByPeriodBean", new QuestionByPeriodBean());
		
		return "questionByPeriodBean-create";
		
	}
	

	
	@PostMapping(value = "/Create", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	@ResponseBody
	public JsonResponse<QuestionByPeriodBean, QuestionByPeriodEntity> createTeacher(@Valid @RequestBody QuestionByPeriodBean questionByPeriodBean, BindingResult bindingResult) {

		System.out.println("00000" + questionByPeriodBean);
		
		JsonResponse<QuestionByPeriodBean, QuestionByPeriodEntity> jsonResponse = new JsonResponse<QuestionByPeriodBean, QuestionByPeriodEntity>();
		
		jsonResponse = questionByPeriodBoInterface.create(questionByPeriodBean, bindingResult); 
		
		return jsonResponse;
	}
	

	
}

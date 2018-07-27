package system.pack.bointerface;

import org.springframework.validation.BindingResult;

import system.pack.helper.JsonResponse;
import system.pack.vo.QuestionByPeriodBean;


public interface QuestionByPeriodBoInterface {

	public JsonResponse create(QuestionByPeriodBean questionByPeriodBean, BindingResult bindingResult);
	
}

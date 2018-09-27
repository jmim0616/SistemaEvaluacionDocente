package system.pack.bointerface;

import org.springframework.validation.BindingResult;

import system.pack.entity.AcademicPeriodEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.AcademicPeriodBean;
import system.pack.vo.TeacherBean;

public interface AcademicPeriodBoInterface {

	public JsonResponse create(AcademicPeriodBean academicPeriodBean, BindingResult bindingResult);
	
	public JsonResponse update(AcademicPeriodBean academicPeriodBean, BindingResult bindingResult);

	public JsonResponse search(AcademicPeriodBean academicPeriodBean, BindingResult bindingResult);

	JsonResponse getAllAcademicPeriods();
	
	
	
}

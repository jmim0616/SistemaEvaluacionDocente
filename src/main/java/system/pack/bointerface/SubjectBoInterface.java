package system.pack.bointerface;

import org.springframework.validation.BindingResult;

import system.pack.helper.JsonResponse;
import system.pack.vo.SubjectBean;
import system.pack.vo.TeacherBean;

public interface SubjectBoInterface {

	public JsonResponse create(SubjectBean subjectBean, BindingResult bindingResult);
	
	public JsonResponse update(SubjectBean subjectBean, BindingResult bindingResult);
	
	public JsonResponse updateStatus(SubjectBean subjectBean, BindingResult bindingResult);
	
	public JsonResponse search(SubjectBean subjectBean, BindingResult bindingResult);
	
	
}

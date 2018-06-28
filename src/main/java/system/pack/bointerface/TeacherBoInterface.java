package system.pack.bointerface;

import org.springframework.validation.BindingResult;

import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;

public interface TeacherBoInterface {

	public JsonResponse create(TeacherBean teacherBean, BindingResult bindingResult);
	
	public JsonResponse createExcel(TeacherBean teacherBean, BindingResult bindingResult);
	
	public JsonResponse update(TeacherBean teacherBean, BindingResult bindingResult);
	
	public JsonResponse updateStatus(TeacherBean teacherBean, BindingResult bindingResult);
	
	public JsonResponse search(TeacherBean teacherBean, BindingResult bindingResult);
	

	
}

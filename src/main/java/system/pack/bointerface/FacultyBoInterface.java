package system.pack.bointerface;

import org.springframework.validation.BindingResult;

import system.pack.helper.JsonResponse;
import system.pack.vo.DepartmentBean;
import system.pack.vo.FacultyBean;
import system.pack.vo.TeacherBean;

public interface FacultyBoInterface {

	public JsonResponse create(FacultyBean facultyBean, BindingResult bindingResult);
	
	public JsonResponse update(FacultyBean facultyBean, BindingResult bindingResult);
	
	public JsonResponse search();
	
}

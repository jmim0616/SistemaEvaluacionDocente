package system.pack.bointerface;

import org.springframework.validation.BindingResult;

import system.pack.helper.JsonResponse;
import system.pack.vo.DepartmentBean;
import system.pack.vo.TeacherBean;

public interface DepartmentBoInterface {

	public JsonResponse create(DepartmentBean departmentBean, BindingResult bindingResult);
	
	public JsonResponse update(DepartmentBean departmentBean, BindingResult bindingResult);
	
	public JsonResponse search();
	
}

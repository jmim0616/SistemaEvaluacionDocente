package system.pack.bointerface;

import org.springframework.validation.BindingResult;

import system.pack.entity.FacultyEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.AcademicProgramBean;
import system.pack.vo.DepartmentBean;
import system.pack.vo.DisciplinaryAreaBean;
import system.pack.vo.FacultyBean;
import system.pack.vo.TeacherBean;

public interface DisciplinaryAreaBoInterface {

	public JsonResponse create(DisciplinaryAreaBean disciplinaryAreaBean, BindingResult bindingResult);
	
	public JsonResponse update(DisciplinaryAreaBean disciplinaryAreaBean, BindingResult bindingResult);
	
	public JsonResponse search();

	JsonResponse getFaculty();
	
}

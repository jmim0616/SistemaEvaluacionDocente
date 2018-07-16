package system.pack.bointerface;

import org.springframework.validation.BindingResult;

import system.pack.entity.FacultyEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.AcademicProgramBean;
import system.pack.vo.DepartmentBean;
import system.pack.vo.FacultyBean;
import system.pack.vo.TeacherBean;

public interface AcademicProgramBoInterface {

	JsonResponse getAllFaculties();
	
	public JsonResponse create(AcademicProgramBean academicProgramBean, BindingResult bindingResult);
	
	public JsonResponse update(AcademicProgramBean academicProgramBean, BindingResult bindingResult);
	
	public JsonResponse search();


}

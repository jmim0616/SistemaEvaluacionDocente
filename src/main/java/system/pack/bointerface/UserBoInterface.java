package system.pack.bointerface;

import org.springframework.validation.BindingResult;

import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.SubjectByProgramBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;
import system.pack.vo.UserBean;

public interface UserBoInterface {

	public JsonResponse create(UserBean userBean, BindingResult bindingResult);
	
	public JsonResponse update(UserBean userBean, BindingResult bindingResult);
	
	public JsonResponse updateStatus(UserBean userBean, BindingResult bindingResult);
	
	public JsonResponse search();
	
}

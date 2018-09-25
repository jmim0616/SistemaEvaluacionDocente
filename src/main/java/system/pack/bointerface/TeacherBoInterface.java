package system.pack.bointerface;

import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.SubjectBean;
import system.pack.vo.SubjectByProgramBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;

public interface TeacherBoInterface {

	public JsonResponse create(TeacherBean teacherBean, BindingResult bindingResult);
	
	public JsonResponse createExcel(TeacherBean teacherBean, BindingResult bindingResult);
	
	public JsonResponse update(TeacherBean teacherBean, BindingResult bindingResult);
	
	public JsonResponse updateStatus(TeacherBean teacherBean, BindingResult bindingResult);
	
	public JsonResponse search(TeacherBean teacherBean, BindingResult bindingResult);

	public String createExcel(MultipartFile file);
	
	JsonResponse<SubjectBean, SubjectEntity> getAllSubjects();
	
	public JsonResponse addSubjects(SubjectByTeacherBean subjectByTeacherBean, BindingResult bindingResult);
	
	public JsonResponse searchSubjecstByTeacher(TeacherBean teacherBean, BindingResult bindingResult);

	JsonResponse getAllTeachers();

}

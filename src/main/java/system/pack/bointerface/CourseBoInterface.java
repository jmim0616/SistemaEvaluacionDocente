package system.pack.bointerface;

import javax.servlet.http.HttpSession;

import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.CourseEntity;
import system.pack.entity.CourseFeedbackEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.CourseFeedbackBean;
import system.pack.vo.AcademicPeriodBean;
import system.pack.vo.CourseBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.SubjectByProgramBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;

public interface CourseBoInterface {

	public JsonResponse create(CourseBean courseBean, BindingResult bindingResult);
	
	public JsonResponse update(CourseBean courseBean, BindingResult bindingResult);
	
	public JsonResponse delete(CourseBean courseBean, BindingResult bindingResult);
	
	public JsonResponse search(CourseBean courseBean, BindingResult bindingResult);
	
	public JsonResponse addCourseFeedback(CourseFeedbackBean courseFeedbackBean,
			BindingResult bindingResult, HttpSession session);
	
	public JsonResponse searchAcademicPeriodsBySubjectOfTeacher(SubjectBean subjectBean, BindingResult bindingResult);
	
	public JsonResponse searchEvaluationsByAcademicPeriodOfTeacher(SubjectBean subjectBean, BindingResult bindingResult);
	
	public JsonResponse searchEvaluationsByCourse(CourseBean courseBean, BindingResult bindingResult);
	
	public JsonResponse searchCoursesBySubject(SubjectBean subjectBean, BindingResult bindingResult);

	public String createExcel(MultipartFile file);

	JsonResponse getAllSubjects();

	JsonResponse getAllTeachers();

	JsonResponse getAllAcademicPeriods();
	
	public JsonResponse validateCourseFeedbacksAdd(CourseBean courseBean);

	public JsonResponse  getAllCourses();

	
}

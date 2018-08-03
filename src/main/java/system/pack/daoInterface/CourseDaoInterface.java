package system.pack.daoInterface;

import java.util.List;

import org.springframework.validation.BindingResult;

import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.CourseEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.CourseBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.TeacherBean;

public interface CourseDaoInterface {
	
	public void create(CourseEntity courseEntity);
	
	public void delete(CourseEntity courseEntity);
	
	public CourseEntity findById(int id);

	public List<CourseEntity> findByAcademicPeriodId(String academicPeriod);
	
	public List<CourseEntity> findByTeacherId(String teacher);
	
	public List<CourseEntity> findBySubjectId(String subject);
	
	public List<AcademicPeriodEntity> searchAcademicPeriodsBySubjectOfTeacher(SubjectBean subjectBean, BindingResult bindingResult);
	
	public List searchEvaluationsByAcademicPeriodOfTeacher(SubjectBean subjectBean, BindingResult bindingResult);
	
	public List searchEvaluationsByCourse(CourseBean courseBean, BindingResult bindingResult);
	
	public List<CourseEntity> searchCoursesBySubject(SubjectBean subjectBean, BindingResult bindingResult);

	
}

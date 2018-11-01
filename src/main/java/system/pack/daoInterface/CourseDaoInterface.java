package system.pack.daoInterface;

import java.util.List;

import org.springframework.validation.BindingResult;

import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.CourseEntity;
import system.pack.entity.CourseFeedbackEntity;
import system.pack.entity.TeacherEntity;
import system.pack.fullview.Data;
import system.pack.helper.JsonResponse;
import system.pack.vo.CourseBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.TeacherBean;

public interface CourseDaoInterface {
	
	public void create(CourseEntity courseEntity);
	
	void update(CourseEntity courseEntity);
	
	public void delete(CourseEntity courseEntity);
	
	public CourseEntity findById(int id);

	public List<CourseEntity> findByAcademicPeriodId(int academicPeriodId);
	
	public List<CourseEntity> findByTeacherId(int teacherId);
	
	public List<CourseEntity> findBySubjectId(int subjectId);
	
	CourseEntity findByGroupId(int groupId);
	
	public List<AcademicPeriodEntity> searchAcademicPeriodsBySubjectOfTeacher(SubjectBean subjectBean, BindingResult bindingResult);
	
	public List searchEvaluationsByAcademicPeriodOfTeacher(SubjectBean subjectBean, BindingResult bindingResult);
	
	public List searchEvaluationsByCourse(CourseBean courseBean, BindingResult bindingResult);
	
	public List<CourseEntity> searchCoursesBySubject(SubjectBean subjectBean, BindingResult bindingResult);

	public Data getCompareView(CourseBean courseBean);

	public List<CourseEntity> getCoursesByTeacher(String teacherId);

	public List<CourseFeedbackEntity> getFeedBacksByCourse(CourseBean courseBean);

	public List<CourseEntity> getCourses(CourseBean courseBean);
}

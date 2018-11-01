package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.QuestionByPeriodEntity;
import system.pack.entity.SubjectByTeacherEntity;


public interface QuestionByPeriodDaoInterface {
	
	public void create(QuestionByPeriodEntity questionByPeriodEntity);
	
	public List<QuestionByPeriodEntity> findByDepartmentId(int departmentId);
	
	public List<QuestionByPeriodEntity> findByCourseId(int courseId);
	
	public List<QuestionByPeriodEntity> findByQuestionId(int questionId);
	
	public List<QuestionByPeriodEntity> findByAcademicPeriodId(int academicPeriodId);

	public int getCourseId(int subjectId, int groupId, int teacherId, int academicPeriod);
	
}

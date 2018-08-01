package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.QuestionByPeriodEntity;
import system.pack.entity.SubjectByTeacherEntity;


public interface QuestionByPeriodDaoInterface {
	
	public void create(QuestionByPeriodEntity questionByPeriodEntity);
	
	public List<QuestionByPeriodEntity> findByDepartmentId(String department);
	
	public List<QuestionByPeriodEntity> findByCourseId(String course);
	
	public List<QuestionByPeriodEntity> findByQuestionId(String question);
	
	public List<QuestionByPeriodEntity> findByAcademicPeriodId(String academicPeriod);
	
}

package system.pack.converter;

import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.CourseEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.QuestionByPeriodEntity;
import system.pack.entity.QuestionEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.vo.CourseBean;
import system.pack.vo.QuestionByPeriodBean;



public class QuestionByPeriodConverter {
	
	public QuestionByPeriodConverter() {

	}

	public static QuestionByPeriodBean ConverToVO(QuestionByPeriodEntity questionByPeriodEntity) {
		
		QuestionByPeriodBean questionByPeriodBean = new QuestionByPeriodBean();
		
		questionByPeriodBean.setQuestionsByPeriodId(Integer.toString(questionByPeriodEntity.getQuestionsByPeriodId()));
		questionByPeriodBean.setDepartment(Integer.toString(questionByPeriodEntity.getDepartment().getDepartmentId()));
		questionByPeriodBean.setCourse(Integer.toString(questionByPeriodEntity.getCourse().getCourseId()));
		questionByPeriodBean.setQuestion(Integer.toString(questionByPeriodEntity.getQuestion().getQuestionId()));
		questionByPeriodBean.setAcademicPeriod(Integer.toString(questionByPeriodEntity.getAcademicPeriod().getAcademicPeriodId()));
		questionByPeriodBean.setPercentage(Integer.toString(questionByPeriodEntity.getPercentage()));
		
		return questionByPeriodBean;
		
	}

	public static QuestionByPeriodEntity ConvertToEntity1(QuestionByPeriodBean questionByPeriodBean) {
		
		QuestionByPeriodEntity questionByPeriodEntity = new QuestionByPeriodEntity();
		
		questionByPeriodEntity.setDepartment(new DepartmentEntity(Integer.parseInt(questionByPeriodBean.getDepartment())));
		questionByPeriodEntity.setCourse(new CourseEntity(Integer.parseInt(questionByPeriodBean.getCourse())));
		questionByPeriodEntity.setQuestion(new QuestionEntity(Integer.parseInt(questionByPeriodBean.getQuestion())));
		questionByPeriodEntity.setAcademicPeriod(new AcademicPeriodEntity(Integer.parseInt(questionByPeriodBean.getAcademicPeriod())));
		questionByPeriodEntity.setPercentage(Integer.parseInt(questionByPeriodBean.getPercentage()));
		
		return questionByPeriodEntity;

	}
	
	
	public static QuestionByPeriodEntity ConvertToEntity2(QuestionByPeriodBean questionByPeriodBean) {
		
		QuestionByPeriodEntity questionByPeriodEntity = new QuestionByPeriodEntity();
		
		questionByPeriodEntity.setQuestionsByPeriodId(Integer.parseInt(questionByPeriodBean.getQuestionsByPeriodId()));
		questionByPeriodEntity.setDepartment(new DepartmentEntity(Integer.parseInt(questionByPeriodBean.getDepartment())));
		questionByPeriodEntity.setCourse(new CourseEntity(Integer.parseInt(questionByPeriodBean.getCourse())));
		questionByPeriodEntity.setQuestion(new QuestionEntity(Integer.parseInt(questionByPeriodBean.getQuestion())));
		questionByPeriodEntity.setAcademicPeriod(new AcademicPeriodEntity(Integer.parseInt(questionByPeriodBean.getAcademicPeriod())));
		questionByPeriodEntity.setPercentage(Integer.parseInt(questionByPeriodBean.getPercentage()));
		
		return questionByPeriodEntity;

	}
	
	
}


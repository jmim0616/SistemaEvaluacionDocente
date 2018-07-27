package system.pack.converter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.QuestionEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.vo.AcademicPeriodBean;
import system.pack.vo.DepartmentBean;
import system.pack.vo.QuestionBean;
import system.pack.vo.TeacherBean;


public class QuestionConverter {
	
	public QuestionConverter() {

	}

	public static QuestionBean ConverToVO(QuestionEntity questionEntity) {
		
		QuestionBean questionBean = new QuestionBean();
		
		questionBean.setQuestionId(Integer.toString(questionEntity.getQuestionId()));
		questionBean.setQuestion(questionEntity.getQuestion());

		
		return questionBean;
	}

	public static QuestionEntity ConvertToEntity1(QuestionBean questionBean) {
		
		QuestionEntity questionEntity = new QuestionEntity();
		
		questionEntity.setQuestion(questionBean.getQuestion());
		
		return questionEntity;

	}
	
	public static QuestionEntity ConvertToEntity2(QuestionBean questionBean) {
		
		QuestionEntity questionEntity = new QuestionEntity();
		
		questionEntity.setQuestionId(Integer.parseInt(questionBean.getQuestionId()));
		questionEntity.setQuestion(questionBean.getQuestion());
		
		return questionEntity;

	}
	
	
}

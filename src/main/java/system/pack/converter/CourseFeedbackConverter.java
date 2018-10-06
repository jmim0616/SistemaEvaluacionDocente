package system.pack.converter;

import java.sql.Date;

import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.CoevaluationEntity;
import system.pack.entity.CourseEntity;
import system.pack.entity.CourseFeedbackEntity;
import system.pack.entity.FeedbackTypeEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.UserEntity;
import system.pack.vo.CourseFeedbackBean;
import system.pack.vo.CourseBean;

public class CourseFeedbackConverter {

	public CourseFeedbackConverter() {

	}

	public static CourseFeedbackBean ConverToVO(CourseFeedbackEntity courseFeedbackEntity) {
		
		CourseFeedbackBean courseFeedbackBean = new CourseFeedbackBean();
		
		
		courseFeedbackBean.setUser(Integer.toString(courseFeedbackEntity.getUser().getUserId()));
		courseFeedbackBean.setFeedBackType((courseFeedbackEntity.getFeedBackType().getDescription()));
		courseFeedbackBean.setCourse(Integer.toString(courseFeedbackEntity.getCourse().getCourseId()));
		courseFeedbackBean.setCreationDate(courseFeedbackEntity.getCreationDate().toString());
		courseFeedbackBean.setComment(courseFeedbackEntity.getComment());
		courseFeedbackBean.setLastModifiedDate(courseFeedbackEntity.getLastModifiedDate().toString());
		
		return courseFeedbackBean;
	}

	public static CourseFeedbackEntity ConvertToEntity1(CourseFeedbackBean courseFeedbackBean) {
		
		CourseFeedbackEntity courseFeedbackEntity = new CourseFeedbackEntity();

		courseFeedbackEntity.setUser(new UserEntity(Integer.parseInt(courseFeedbackBean.getUser())));
		courseFeedbackEntity.setFeedBackType(new FeedbackTypeEntity(Integer.parseInt(courseFeedbackBean.getFeedBackType())));
		courseFeedbackEntity.setCourse(new CourseEntity(Integer.parseInt(courseFeedbackBean.getCourse())));
		courseFeedbackEntity.setCreationDate(Date.valueOf(courseFeedbackBean.getCreationDate()));
		courseFeedbackEntity.setComment(courseFeedbackBean.getComment());
		courseFeedbackEntity.setLastModifiedDate(Date.valueOf(courseFeedbackBean.getLastModifiedDate()));
		
		return courseFeedbackEntity;

	}
	
	
	public static CourseFeedbackEntity ConvertToEntity2(CourseFeedbackBean courseFeedbackBean) {
		
		CourseFeedbackEntity courseFeedbackEntity = new CourseFeedbackEntity();

		courseFeedbackEntity.setCourseFeedBackId(Integer.parseInt(courseFeedbackBean.getCourseFeedBackId()));
		courseFeedbackEntity.setUser(new UserEntity(Integer.parseInt(courseFeedbackBean.getUser())));
		courseFeedbackEntity.setCourse(new CourseEntity(Integer.parseInt(courseFeedbackBean.getCourse())));
		courseFeedbackEntity.setCreationDate(Date.valueOf(courseFeedbackBean.getCreationDate().toString()));
		courseFeedbackEntity.setComment(courseFeedbackBean.getComment());
		courseFeedbackEntity.setLastModifiedDate(Date.valueOf(courseFeedbackBean.getLastModifiedDate().toString()));
		
		return courseFeedbackEntity;

	}
	
}

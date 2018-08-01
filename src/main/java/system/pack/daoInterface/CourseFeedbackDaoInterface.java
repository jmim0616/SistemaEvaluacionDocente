package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.CoevaluationEntity;
import system.pack.entity.CourseFeedbackEntity;


public interface CourseFeedbackDaoInterface {
	
	public void create(CourseFeedbackEntity courseFeedbackEntity);
	
	public void update(CourseFeedbackEntity courseFeedbackEntity);
	
	public List<CourseFeedbackEntity> findByFeedBackTypeId(String feedBackType);
	
	public List<CourseFeedbackEntity> findByCourseId(String course);
	
	
}

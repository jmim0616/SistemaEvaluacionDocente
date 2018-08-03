package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import system.pack.daoInterface.CourseFeedbackDaoInterface;
import system.pack.daoInterface.QuestionByPeriodDaoInterface;
import system.pack.daoInterface.SubjectByTeacherDaoInterface;

import system.pack.entity.CoevaluationEntity;
import system.pack.entity.CourseFeedbackEntity;
import system.pack.entity.QuestionByPeriodEntity;
import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.TeacherEntity;

@Repository
@Transactional
public class CoevaluationDaoImpl implements CourseFeedbackDaoInterface {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void create(CourseFeedbackEntity courseFeedbackEntity) {
		
		entityManager.merge(courseFeedbackEntity);
		
	}
	
	@Override
	public void update(CourseFeedbackEntity courseFeedbackEntity) {
		
		entityManager.merge(courseFeedbackEntity);
		
	}
	
	public List<CourseFeedbackEntity> findByFeedBackTypeId(String feedBackType) {
		
		TypedQuery<CourseFeedbackEntity> query = entityManager.createQuery("select cf from CourseFeedbackEntity cf where cf.feedBackType.getFeedBackTypeId() =:feedBackType", CourseFeedbackEntity.class);
		
		query.setParameter("feedBackType", feedBackType);
		
		List<CourseFeedbackEntity> courseFeedbacks = query.getResultList();
		
		return courseFeedbacks;
		
	}
	
	public List<CourseFeedbackEntity> findByCourseId(String course) {
		
		TypedQuery<CourseFeedbackEntity> query = entityManager.createQuery("select cf from CourseFeedbackEntity cf where cf.course.getCourseId() =:course", CourseFeedbackEntity.class);
		
		query.setParameter("course", course);
		
		List<CourseFeedbackEntity> courseFeedbacks = query.getResultList();
		
		return courseFeedbacks;
		
	}
	
	
}

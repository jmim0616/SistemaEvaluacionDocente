package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.FeedbackTypeDaoInterface;
import system.pack.daoInterface.SubjectStatusDaoInterface;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoInterface;
import system.pack.entity.FeedbackTypeEntity;
import system.pack.entity.SubjectStatusEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;

@Repository
@Transactional
public class FeedbackTypeDaoImpl implements FeedbackTypeDaoInterface {

	@Autowired
	private EntityManager entityManager;


	@Override
	public FeedbackTypeEntity findById(int id) {
		
		FeedbackTypeEntity feedbackType =  entityManager.find(FeedbackTypeEntity.class, id);
		
		return feedbackType;

	}
	
	@Override
	public FeedbackTypeEntity findByDescription(String description) {
		
		TypedQuery<FeedbackTypeEntity> query = entityManager.createQuery("select ft from FeedbackTypeEntity ft where ft.description =:description", FeedbackTypeEntity.class);
		
		query.setParameter("description", description);
		
		FeedbackTypeEntity feedbackType = query.getSingleResult();
		
		return feedbackType;
	}
	
	@Override
	public List<FeedbackTypeEntity> getAll() {
		
		TypedQuery<FeedbackTypeEntity> query = entityManager.createQuery("select ft from FeedbackTypeEntity ft", FeedbackTypeEntity.class);
		
		List<FeedbackTypeEntity> feedbackTypes = query.getResultList();
		
		return feedbackTypes;
	}
	
}
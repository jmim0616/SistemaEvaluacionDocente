package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.QuestionDaoInterface;
import system.pack.daoInterface.SubjectByTeacherDaoInterface;
import system.pack.entity.QuestionEntity;
import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.TeacherEntity;

@Repository
@Transactional
public class QuestionDaoImpl implements QuestionDaoInterface {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void create(QuestionEntity questionEntity) {
		
		entityManager.merge(questionEntity);
		
	}

	@Override
	public QuestionEntity findById(int id) {
		
		QuestionEntity questionEntity =  entityManager.find(QuestionEntity.class, id);
		
		return questionEntity;
	}
	
	
}

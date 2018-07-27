package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.ClassVisitDaoInterface;
import system.pack.daoInterface.CoevaluationDaoInterface;
import system.pack.daoInterface.QuestionByPeriodDaoInterface;
import system.pack.daoInterface.SubjectByTeacherDaoInterface;
import system.pack.entity.ClassVisitEntity;
import system.pack.entity.CoevaluationEntity;
import system.pack.entity.QuestionByPeriodEntity;
import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.TeacherEntity;

@Repository
@Transactional
public class CoevaluationDaoImpl implements CoevaluationDaoInterface {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void create(CoevaluationEntity coevaluationEntity) {
		
		entityManager.merge(coevaluationEntity);
		
	}
	
	@Override
	public void update(CoevaluationEntity coevaluationEntity) {
		
		entityManager.merge(coevaluationEntity);
		
	}

	
	
	public List<CoevaluationEntity> findByCourseId(int course) {
		
		TypedQuery<CoevaluationEntity> query = entityManager.createQuery("select ce from CoevaluationEntity ce where ce.course.getCourseId() =:course", CoevaluationEntity.class);
		
		query.setParameter("course", course);
		
		List<CoevaluationEntity> coevaluations = query.getResultList();
		
		return coevaluations;
		
	}
	
	
}

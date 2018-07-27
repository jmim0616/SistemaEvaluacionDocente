package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.ClassVisitDaoInterface;
import system.pack.daoInterface.QuestionByPeriodDaoInterface;
import system.pack.daoInterface.SubjectByTeacherDaoInterface;
import system.pack.entity.ClassVisitEntity;
import system.pack.entity.QuestionByPeriodEntity;
import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.TeacherEntity;

@Repository
@Transactional
public class ClassVisitDaoImpl implements ClassVisitDaoInterface {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void create(ClassVisitEntity classVisitEntity) {
		
		entityManager.merge(classVisitEntity);
		
	}
	
	@Override
	public void update(ClassVisitEntity classVisitEntity) {
		
		entityManager.merge(classVisitEntity);
		
	}

	
	
	public List<ClassVisitEntity> findByCourseId(int course) {
		
		TypedQuery<ClassVisitEntity> query = entityManager.createQuery("select cv from ClassVisitEntity cv where cv.course.getCourseId() =:course", ClassVisitEntity.class);
		
		query.setParameter("course", course);
		
		List<ClassVisitEntity> classVisits = query.getResultList();
		
		return classVisits;
		
	}
	
	
}

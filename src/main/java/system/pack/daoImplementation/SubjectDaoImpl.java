package system.pack.daoImplementation;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.SubjectDaoInterface;
import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;

@Repository
@Transactional
public class SubjectDaoImpl implements SubjectDaoInterface {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void create(SubjectEntity subjectEntity) {
		
		entityManager.merge(subjectEntity);
		
	}

	@Override
	public void update(SubjectEntity subjectEntity) {
		
		entityManager.merge(subjectEntity);
		
	}

	@Override
	public void updateState(SubjectEntity subjectEntity) {
		
		entityManager.merge(subjectEntity);
		
	}

	@Override
	public SubjectEntity findById(int id) {
		
		SubjectEntity subject =  entityManager.find(SubjectEntity.class, id);
		
		return subject;
		
	}

	@Override
	public SubjectEntity findByName(String name) {

		TypedQuery<SubjectEntity> query = entityManager.createQuery("select s from SubjectEntity s where s.name =:name", SubjectEntity.class);
		
		query.setParameter("name", name);
		
		SubjectEntity subject = query.getSingleResult();
		
		return subject;
		
	}

	@Override
	public SubjectEntity findByDisciplinaryAreaId(String disciplinaryArea) {
		
		TypedQuery<SubjectEntity> query = entityManager.createQuery("select s from SubjectEntity s where s.disciplinaryArea.getDisciplinaryArea() =:disciplinaryArea", SubjectEntity.class);
		
		query.setParameter("disciplinaryArea", disciplinaryArea);
		
		SubjectEntity subject = query.getSingleResult();
		
		return subject;
		
	}

	@Override
	public SubjectEntity findBySubjectStatusId(String subjectStatus) {
		
		TypedQuery<SubjectEntity> query = entityManager.createQuery("select s from SubjectEntity s where s.subjectStatus.getSubjectStatus() =:subjectStatus", SubjectEntity.class);
		
		query.setParameter("subjectStatus", subjectStatus);
		
		SubjectEntity subject = query.getSingleResult();
		
		return subject;
		
	}

	
	
}

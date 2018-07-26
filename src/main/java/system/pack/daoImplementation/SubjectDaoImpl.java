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
	public SubjectEntity findByDisciplinaryAreaId(String disciplinaryAreaId) {
		
		TypedQuery<SubjectEntity> query = entityManager.createQuery("select s from SubjectEntity s where s.disciplinaryArea.getDisciplinaryArea() =:disciplinaryAreaId", SubjectEntity.class);
		
		query.setParameter("disciplinaryAreaId", disciplinaryAreaId);
		
		SubjectEntity subject = query.getSingleResult();
		
		return subject;
		
	}

	@Override
	public SubjectEntity findBySubjectStatusId(String subjectStatusId) {
		
		TypedQuery<SubjectEntity> query = entityManager.createQuery("select s from SubjectEntity s where s.subjectStatus.getSubjectStatus() =:subjectStatusId", SubjectEntity.class);
		
		query.setParameter("subjectStatusId", subjectStatusId);
		
		SubjectEntity subject = query.getSingleResult();
		
		return subject;
		
	}

	
	
}

package system.pack.daoImplementation;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.SubjectDaoInterface;
import system.pack.entity.AcademicProgramEntity;
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

		SubjectEntity subject = entityManager.find(SubjectEntity.class, id);

		return subject;

	}
	
	@Override
	public Optional<SubjectEntity> findByIdOptional(int id) {

		TypedQuery<SubjectEntity> query = entityManager.createQuery("select s from SubjectEntity s where s.subjectId =:id",
				SubjectEntity.class);

		query.setParameter("id", id);

		Optional<SubjectEntity> subject = query.getResultList().stream().findFirst();

		return subject;

	}

	@Override
	public Optional<SubjectEntity> findByName(String name) {

		TypedQuery<SubjectEntity> query = entityManager.createQuery("select s from SubjectEntity s where s.name =:name",
				SubjectEntity.class);

		query.setParameter("name", name);

		Optional<SubjectEntity> subject = query.getResultList().stream().findFirst();

		return subject;

	}

	@Override
	public SubjectEntity findByDisciplinaryAreaId(int disciplinaryAreaId) {

		TypedQuery<SubjectEntity> query = entityManager.createQuery("select s from SubjectEntity s where s.disciplinaryArea.disciplinaryAreaId =:disciplinaryAreaId",
				SubjectEntity.class);

		query.setParameter("disciplinaryAreaId", disciplinaryAreaId);

		SubjectEntity subject = query.getSingleResult();

		return subject;

	}

	@Override
	public SubjectEntity findBySubjectStatusId(int subjectStatusId) {

		TypedQuery<SubjectEntity> query = entityManager.createQuery("select s from SubjectEntity s where s.subjectStatus.subjectStatusId =:subjectStatusId", SubjectEntity.class);

		query.setParameter("subjectStatusId", subjectStatusId);

		SubjectEntity subject = query.getSingleResult();

		return subject;

	}

	@Override
	public List<SubjectEntity> getAll() {

		TypedQuery<SubjectEntity> query = entityManager.createQuery("select s from SubjectEntity s",
				SubjectEntity.class);

		List<SubjectEntity> subjects = query.getResultList();

		return subjects;
	}

	@Override
	public boolean isValidSubjectId(int subjectId) {
		return findById(subjectId) != null;
	}

}

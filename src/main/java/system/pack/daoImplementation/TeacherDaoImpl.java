package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;

@Repository
@Transactional
public class TeacherDaoImpl implements TeacherDaoInterface {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void create(TeacherEntity teacherEntity) {

		entityManager.persist(teacherEntity);
		
	}

	@Override
	public void update(TeacherEntity teacherEntity) {
		
		entityManager.merge(teacherEntity);
		
	}

	@Override
	public void updateState(TeacherEntity teacherEntity) {
		
		entityManager.merge(teacherEntity);
		
	}

	@Override
	public List<TeacherEntity> findByName(String name) {
		
		TypedQuery<TeacherEntity> query = entityManager.createQuery("select t from TeacherEntity t where t.name =: name", TeacherEntity.class);
		
		query.setParameter("name", name);
		
		List<TeacherEntity> teachers = query.getResultList();
		
		return teachers;
	}

	@Override
	public List<TeacherEntity> findByLastName(String lastName) {
		
		TypedQuery<TeacherEntity> query = entityManager.createQuery("select t from TeacherEntity t where t.lastName =: lastName", TeacherEntity.class);
		
		query.setParameter("lastName", lastName);
		
		List<TeacherEntity> teachers = query.getResultList();
		
		return teachers;

	}

	@Override
	public List<TeacherEntity> findByIdentificationType(String identificationType) {
		
		TypedQuery<TeacherEntity> query = entityManager.createQuery("select t from TeacherEntity t where t.identificationType =: identificationType", TeacherEntity.class);
		
		query.setParameter("identificationType", identificationType);
		
		List<TeacherEntity> teachers = query.getResultList();
		
		return teachers;
		
	}

	@Override
	public List<TeacherEntity> findByTeacherStatusId(String teacherStatus) {
		
		TypedQuery<TeacherEntity> query = entityManager.createQuery("select t from TeacherEntity t where t.teacherStatus =: teacherStatus", TeacherEntity.class);
		
		query.setParameter("teacherStatus", teacherStatus);
		
		List<TeacherEntity> teachers = query.getResultList();
		
		return teachers;
		
	}
	

	
	
}

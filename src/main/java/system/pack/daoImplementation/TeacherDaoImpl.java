package system.pack.daoImplementation;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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

		entityManager.merge(teacherEntity);
		
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
	public TeacherEntity findById(int id) {
		
		TeacherEntity teacher =  entityManager.find(TeacherEntity.class, id);
		
		return teacher;
	}
	
	@Override
	public Optional<TeacherEntity> findByName(String name) {
		
		TypedQuery<TeacherEntity> query = entityManager.createQuery("select t from TeacherEntity t where t.name =:name", TeacherEntity.class);
		
		query.setParameter("name", name);
		
		Optional<TeacherEntity> teacher = query.getResultList().stream().findFirst();
		
		return teacher;
	}

	@Override
	public TeacherEntity findByLastName(String lastName) {
		
		TypedQuery<TeacherEntity> query = entityManager.createQuery("select t from TeacherEntity t where t.lastName =:lastName", TeacherEntity.class);
		
		query.setParameter("lastName", lastName);
		
		TeacherEntity teacher = query.getSingleResult();
		
		return teacher;

	}

	@Override
	public TeacherEntity findByIdentificationType(String identificationType) {
		
		TypedQuery<TeacherEntity> query = entityManager.createQuery("select t from TeacherEntity t where t.identificationType =:identificationType", TeacherEntity.class);
		
		query.setParameter("identificationType", identificationType);
		
		TeacherEntity teacher = query.getSingleResult();
		
		return teacher;
		
	}

	@Override
	public TeacherEntity findByTeacherStatusId(String teacherStatus) {
		
		TypedQuery<TeacherEntity> query = entityManager.createQuery("select t from TeacherEntity t where t.teacherStatus.getTeacherStatusId() =:teacherStatus", TeacherEntity.class);
		
		query.setParameter("teacherStatus", teacherStatus);
		
		TeacherEntity teacher = query.getSingleResult();
		
		return teacher;
		
	}

	

	
	
}

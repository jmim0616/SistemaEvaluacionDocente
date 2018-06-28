package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoInterface;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;

@Repository
@Transactional
public class TeacherStatusDaoImpl implements TeacherStatusDaoInterface {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void create(TeacherStatusEntity teacherStatusEntity) {

		entityManager.persist(teacherStatusEntity);
		
	}

	@Override
	public void update(TeacherStatusEntity teacherStatusEntity) {
		
		entityManager.merge(teacherStatusEntity);
		
	}

	@Override
	public List<TeacherStatusEntity> findById(String id) {
		
		TypedQuery<TeacherStatusEntity> query = entityManager.createQuery("select ts from TeacherStatusEntity ts where ts.id =: id", TeacherStatusEntity.class);
		
		query.setParameter("id", id);
		
		List<TeacherStatusEntity> teacherStatus = query.getResultList();
		
		return teacherStatus;
	}
	
	@Override
	public List<TeacherStatusEntity> findByStatus(String status) {
		
		TypedQuery<TeacherStatusEntity> query = entityManager.createQuery("select ts from TeacherStatusEntity ts where ts.status =: status", TeacherStatusEntity.class);
		
		query.setParameter("status", status);
		
		List<TeacherStatusEntity> teacherStatus = query.getResultList();
		
		return teacherStatus;
	}
	
	@Override
	public List<TeacherStatusEntity> getAll() {
		
		TypedQuery<TeacherStatusEntity> query = entityManager.createQuery("select ts from TeacherStatusEntity ts", TeacherStatusEntity.class);
		
		List<TeacherStatusEntity> teacherStatus = query.getResultList();
		
		return teacherStatus;
	}
	
}
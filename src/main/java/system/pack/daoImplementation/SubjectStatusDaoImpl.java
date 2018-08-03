package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.SubjectStatusDaoInterface;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoInterface;
import system.pack.entity.SubjectStatusEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;

@Repository
@Transactional
public class SubjectStatusDaoImpl implements SubjectStatusDaoInterface {

	@Autowired
	private EntityManager entityManager;


	@Override
	public SubjectStatusEntity findById(int id) {
		
		SubjectStatusEntity subjectStatus =  entityManager.find(SubjectStatusEntity.class, id);
		
		return subjectStatus;

	}
	
	@Override
	public SubjectStatusEntity findByStatus(String status) {
		
		TypedQuery<SubjectStatusEntity> query = entityManager.createQuery("select ss from SubjectStatusEntity ss where ss.status =:status", SubjectStatusEntity.class);
		
		query.setParameter("status", status);
		
		SubjectStatusEntity subjectStatus = query.getSingleResult();
		
		return subjectStatus;
	}
	
	@Override
	public List<SubjectStatusEntity> getAll() {
		
		TypedQuery<SubjectStatusEntity> query = entityManager.createQuery("select ss from SubjectStatusEntity ss", SubjectStatusEntity.class);
		
		List<SubjectStatusEntity> subjectStatus = query.getResultList();
		
		return subjectStatus;
	}
	
}
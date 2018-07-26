package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.SubjectByTeacherDaoInterface;
import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.TeacherEntity;

@Repository
@Transactional
public class SubjectByTeacherDaoImpl implements SubjectByTeacherDaoInterface {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void create(SubjectByTeacherEntity subjectByTeacherEntity) {
		
		entityManager.merge(subjectByTeacherEntity);
		
	}

	@Override
	public void update(SubjectByTeacherEntity subjectByTeacherEntity) {
		
		entityManager.merge(subjectByTeacherEntity);
		
	}

	@Override
	public SubjectByTeacherEntity findById(int id) {
		
		SubjectByTeacherEntity subjectByTeacher =  entityManager.find(SubjectByTeacherEntity.class, id);
		
		return subjectByTeacher;
	}

	@Override
	public List<SubjectByTeacherEntity> findBySubjectId(String subjectId) {

		TypedQuery<SubjectByTeacherEntity> query = entityManager.createQuery("select st from SubjectByTeacherEntity st where st.subject.getSubjectId() =:subjectId", SubjectByTeacherEntity.class);
		
		query.setParameter("subjectId", subjectId);
		
		List<SubjectByTeacherEntity> subjectsByTeacher = query.getResultList();
		
		return subjectsByTeacher;
		
	}

	@Override
	public List<SubjectByTeacherEntity> findByTeacherId(String teacherId) {
		
		TypedQuery<SubjectByTeacherEntity> query = entityManager.createQuery("select st from SubjectByTeacherEntity st where st.teacher.getTeacherId() =:teacherId", SubjectByTeacherEntity.class);
		
		query.setParameter("teacherId", teacherId);
		
		List<SubjectByTeacherEntity> subjectsByTeacher = query.getResultList();
		
		return subjectsByTeacher;
		
	}

	
	
}

package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.SubjectByTeacherDaoInterface;
import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.vo.TeacherBean;

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
	public List<SubjectByTeacherEntity> findBySubjectId(String subject) {

		TypedQuery<SubjectByTeacherEntity> query = entityManager.createQuery("select st from SubjectByTeacherEntity st where st.subject.getSubjectId() =:subject", SubjectByTeacherEntity.class);
		
		query.setParameter("subject", subject);
		
		List<SubjectByTeacherEntity> subjectsByTeacher = query.getResultList();
		
		return subjectsByTeacher;
		
	}

	@Override
	public List<SubjectByTeacherEntity> findByTeacherId(String teacher) {
		
		TypedQuery<SubjectByTeacherEntity> query = entityManager.createQuery("select st from SubjectByTeacherEntity st where st.teacher.getTeacherId() =:teacher", SubjectByTeacherEntity.class);
		
		query.setParameter("teacher", teacher);
		
		List<SubjectByTeacherEntity> subjectsByTeacher = query.getResultList();
		
		return subjectsByTeacher;
		
	}

	@Override
	public List<SubjectEntity> searchSubjecstByTeacher(TeacherBean teacherBean) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.SubjectByProgramDaoInterface;
import system.pack.daoInterface.SubjectByTeacherDaoInterface;
import system.pack.entity.SubjectByProgramEntity;
import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.TeacherEntity;

@Repository
@Transactional
public class SubjectByProgramDaoImpl implements SubjectByProgramDaoInterface {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void create(SubjectByProgramEntity subjectByProgramEntity) {
		
		entityManager.merge(subjectByProgramEntity);
		
	}

	@Override
	public void update(SubjectByProgramEntity subjectByProgramEntity) {
		
		entityManager.merge(subjectByProgramEntity);
		
	}

	@Override
	public SubjectByProgramEntity findById(int id) {
		
		SubjectByProgramEntity subjectByProgram =  entityManager.find(SubjectByProgramEntity.class, id);
		
		return subjectByProgram;
	}

	@Override
	public List<SubjectByProgramEntity> findBySubjectId(String subject) {

		TypedQuery<SubjectByProgramEntity> query = entityManager.createQuery("select sp from SubjectByProgramEntity sp where sp.subject.getSubjectId() =:subject", SubjectByProgramEntity.class);
		
		query.setParameter("subject", subject);
		
		List<SubjectByProgramEntity> subjectsByProgram = query.getResultList();
		
		return subjectsByProgram;
		
	}

	@Override
	public List<SubjectByProgramEntity> findByAcademicProgramId(String academicProgram) {
		
		TypedQuery<SubjectByProgramEntity> query = entityManager.createQuery("select sp from SubjectByProgramEntity sp where sp.academicProgram.getAcademicProgramId() =:academicProgram", SubjectByProgramEntity.class);
		
		query.setParameter("academicProgram", academicProgram);
		
		List<SubjectByProgramEntity> subjectsByProgram = query.getResultList();
		
		return subjectsByProgram;
		
	}

	
	
}

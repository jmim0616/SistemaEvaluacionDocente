package system.pack.daoInterface;

import java.util.List;
import java.util.Optional;

import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.SubjectEntity;


public interface SubjectDaoInterface {
	
	public void create(SubjectEntity subjectEntity);
	
	public void update(SubjectEntity subjectEntity);
	
	public void updateState(SubjectEntity subjectEntity);
	
	public SubjectEntity findById(int id);
	
	public Optional<SubjectEntity> findByName(String name);
	
	public SubjectEntity findByDisciplinaryAreaId(int disciplinaryAreaId);
	
	public SubjectEntity findBySubjectStatusId(int subjectStatusId);
	
	public List<SubjectEntity> getAll();

	public boolean isValidSubjectId(int subjectId);
	

}

package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.SubjectEntity;


public interface SubjectDaoInterface {
	
	public void create(SubjectEntity subjectEntity);
	
	public void update(SubjectEntity subjectEntity);
	
	public void updateState(SubjectEntity subjectEntity);
	
	public SubjectEntity findById(int id);
	
	public SubjectEntity findByName(String name);
	
	public SubjectEntity findByDisciplinaryAreaId(String disciplinaryArea);
	
	public SubjectEntity findBySubjectStatusId(String subjectStatus);
	

}

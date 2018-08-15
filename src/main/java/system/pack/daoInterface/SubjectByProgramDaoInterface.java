package system.pack.daoInterface;


import java.util.List;

import system.pack.entity.SubjectByProgramEntity;
import system.pack.entity.SubjectByTeacherEntity;


public interface SubjectByProgramDaoInterface {
	
	public void create(SubjectByProgramEntity subjectByProgramEntity);
	
	public void update(SubjectByProgramEntity subjectByProgramEntity);
	
	public SubjectByProgramEntity findById(int id);
	
	public List<SubjectByProgramEntity> findBySubjectId(int subject);
	
	public List<SubjectByProgramEntity> findByAcademicProgramId(String academicProgram);

	void deleteByAcademicProgramIdSubjectId(int academicProgram, int subject);

}

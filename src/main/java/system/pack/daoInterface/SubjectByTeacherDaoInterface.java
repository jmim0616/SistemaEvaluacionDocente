package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.SubjectByTeacherEntity;


public interface SubjectByTeacherDaoInterface {
	
	public void create(SubjectByTeacherEntity subjectByTeacherEntity);
	
	public void update(SubjectByTeacherEntity subjectByTeacherEntity);
	
	public SubjectByTeacherEntity findById(int id);
	
	public List<SubjectByTeacherEntity> findBySubjectId(String subjectId);
	
	public List<SubjectByTeacherEntity> findByTeacherId(String teacherId);
	
}

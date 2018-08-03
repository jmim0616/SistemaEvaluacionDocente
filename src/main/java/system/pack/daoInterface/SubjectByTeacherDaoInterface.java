package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.vo.TeacherBean;


public interface SubjectByTeacherDaoInterface {
	
	public void create(SubjectByTeacherEntity subjectByTeacherEntity);
	
	public void update(SubjectByTeacherEntity subjectByTeacherEntity);
	
	public SubjectByTeacherEntity findById(int id);
	
	public List<SubjectByTeacherEntity> findBySubjectId(String subject);
	
	public List<SubjectByTeacherEntity> findByTeacherId(String teacher);
	
	public List<SubjectEntity> searchSubjecstByTeacher(TeacherBean teacherBean);
	
}

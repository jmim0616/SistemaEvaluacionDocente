package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.TeacherEntity;
import system.pack.vo.TeacherBean;

public interface TeacherDaoInterface {
	
	public void create(TeacherEntity teacherEntity);
	
	public void update(TeacherEntity teacherEntity);
	
	public void updateState(TeacherEntity teacherEntity);
	
	public TeacherEntity findById(int id);
	
	public TeacherEntity findByName(String name);
	
	public TeacherEntity findByLastName(String lastName);
	
	public TeacherEntity findByIdentificationType(String identificationType);
	
	public TeacherEntity findByTeacherStatusId(String teacherStatus);

}

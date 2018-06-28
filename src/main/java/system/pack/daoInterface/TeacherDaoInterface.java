package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.TeacherEntity;
import system.pack.vo.TeacherBean;

public interface TeacherDaoInterface {
	
	public void create(TeacherEntity teacherEntity);
	
	public void update(TeacherEntity teacherEntity);
	
	public void updateState(TeacherEntity teacherEntity);
	
	public List<TeacherEntity> findByName(String name);
	
	public List<TeacherEntity> findByLastName(String lastName);
	
	public List<TeacherEntity> findByIdentificationType(String identificationType);
	
	public List<TeacherEntity> findByTeacherStatusId(String teacherStatus);

}

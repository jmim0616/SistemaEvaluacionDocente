package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.vo.TeacherBean;

public interface TeacherStatusDaoInterface {
	
	public void create(TeacherStatusEntity teacherStatusEntity);
	
	public void update(TeacherStatusEntity teacherStatusEntity);
	
	public List<TeacherStatusEntity> findById(String id);
	
	public List<TeacherStatusEntity> findByStatus(String status);
	
	public List<TeacherStatusEntity> getAll();
	

}

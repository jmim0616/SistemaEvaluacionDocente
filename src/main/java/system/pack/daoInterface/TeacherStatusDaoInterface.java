package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.vo.TeacherBean;

public interface TeacherStatusDaoInterface {
	
	public TeacherStatusEntity findById(int id);
	
	public TeacherStatusEntity findByStatus(String status);
	
	public List<TeacherStatusEntity> getAll();
	

}

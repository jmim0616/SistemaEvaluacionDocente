package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.SubjectStatusEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.vo.TeacherBean;

public interface SubjectStatusDaoInterface {
	
	public SubjectStatusEntity findById(int id);
	
	public SubjectStatusEntity findByStatus(String status);
	
	public List<SubjectStatusEntity> getAll();

}

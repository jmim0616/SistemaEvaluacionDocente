package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.DepartmentEntity;
import system.pack.entity.TeacherEntity;
import system.pack.vo.TeacherBean;

public interface DepartmentDaoInterface {
	
	public void create(DepartmentEntity departmentEntity);
	
	public void update(DepartmentEntity departmentEntity);
	
	DepartmentEntity findById(int id);
	
	public DepartmentEntity findByName(String name);

	List<DepartmentEntity> getAll();


	

}
package system.pack.daoInterface;

import java.util.List;
import java.util.Optional;

import system.pack.entity.DepartmentEntity;
import system.pack.entity.TeacherEntity;
import system.pack.vo.TeacherBean;

public interface DepartmentDaoInterface {
	
	public void create(DepartmentEntity departmentEntity);
	
	public void update(DepartmentEntity departmentEntity);
	
	DepartmentEntity findById(int id);
	
	public Optional<DepartmentEntity> findByName(String name);

	List<DepartmentEntity> getAll();

	public boolean isValidDepartmentId(int departmentId);


	

}

package system.pack.daoInterface;

import java.util.List;
import java.util.Optional;

import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.vo.TeacherBean;

public interface FacultyDaoInterface {
	
	public void create(FacultyEntity facultyEntity);
	
	public void update(FacultyEntity facultyEntity);
	
	public Optional<FacultyEntity> findByName(String name);

	List<FacultyEntity> getAll();
	

}

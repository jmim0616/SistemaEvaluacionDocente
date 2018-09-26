package system.pack.daoInterface;

import java.util.List;
import java.util.Optional;

import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.DisciplinaryAreaEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.vo.TeacherBean;

public interface DisciplinaryAreaDaoInterface {
	
	public void create(DisciplinaryAreaEntity disciplinaryAreaEntity);
	
	public void update(DisciplinaryAreaEntity disciplinaryAreaEntity);
	
	public Optional<DisciplinaryAreaEntity> findByName(String name);
	
	public List<DisciplinaryAreaEntity> findByFacultyId(int facultyId);

	List<DisciplinaryAreaEntity> getAll();
	

}

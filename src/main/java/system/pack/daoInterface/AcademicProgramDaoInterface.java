package system.pack.daoInterface;

import java.util.List;
import java.util.Optional;

import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.vo.TeacherBean;

public interface AcademicProgramDaoInterface {
	
	public void create(AcademicProgramEntity academicProgramEntity);
	
	public void update(AcademicProgramEntity academicProgramEntity);
	
	public Optional<AcademicProgramEntity> findByName(String name);
	
	public List<AcademicProgramEntity> findByFacultyId(String faculty);
	
	public List<AcademicProgramEntity> getAll();
	

}

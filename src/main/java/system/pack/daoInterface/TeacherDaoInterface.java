package system.pack.daoInterface;

import java.util.List;
import java.util.Optional;

import org.springframework.validation.BindingResult;

import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;

public interface TeacherDaoInterface {
	
	public void create(TeacherEntity teacherEntity);
	
	public void update(TeacherEntity teacherEntity);
	
	public void updateState(TeacherEntity teacherEntity);
	
	public TeacherEntity findById(int id);
	
	public Optional<TeacherEntity> findByName(String name);
	
	public TeacherEntity findByLastName(String lastName);
	
	public TeacherEntity findByIdentificationType(String identificationType);
	
	public TeacherEntity findByTeacherStatusId(int teacherStatusId);
	

}

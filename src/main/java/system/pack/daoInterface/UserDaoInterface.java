package system.pack.daoInterface;

import java.util.List;

import org.springframework.validation.BindingResult;

import system.pack.entity.FeedbackTypeEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.UserEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;

public interface UserDaoInterface {
	
	public void create(UserEntity userEntity);
	
	public void update(UserEntity userEntity);
	
	public void updateState(UserEntity userEntity);
	
	public UserEntity findById(int id);
	
	public UserEntity findByName(String name);
	
	public UserEntity findByMask(String mask);
	
	public List<UserEntity> getAll();
	

}

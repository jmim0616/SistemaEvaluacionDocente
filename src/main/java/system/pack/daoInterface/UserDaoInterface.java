package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.UserEntity;

public interface UserDaoInterface {

	public UserEntity getUserDataByMaskAndPasswd (String mask, String password);
	
	public void createUser (UserEntity userEntity);
	
	public UserEntity findById(int id);

	public List<UserEntity> getAll();

	public void update(UserEntity userEntity);
	
}

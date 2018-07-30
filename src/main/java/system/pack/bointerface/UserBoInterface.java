package system.pack.bointerface;

import org.springframework.validation.BindingResult;

import system.pack.entity.UserEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.UserBean;

public interface UserBoInterface {

	public UserEntity ValidateUser (String userName, String password);
	
	public JsonResponse createUser (UserBean userBean, BindingResult bindingResult);

	public JsonResponse<UserBean, UserEntity> search();

	public JsonResponse<UserBean, UserEntity> update(UserBean userBean, BindingResult bindingResult);

	public JsonResponse<UserBean, UserEntity> updateStatus(UserBean userBean, BindingResult bindingResult);
}

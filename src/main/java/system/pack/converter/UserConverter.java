package system.pack.converter;


import system.pack.entity.UserEntity;

import system.pack.vo.UserBean;


public class UserConverter {
	
	public UserConverter() {

	}

	public static UserBean ConverToVO(UserEntity userEntity) {
		
		UserBean userBean = new UserBean();
		

		userBean.setUserId(userEntity.getUserId());
		userBean.setName(userEntity.getName());
		userBean.setMask(userEntity.getMask());
		userBean.setPassword(userEntity.getPassword());
		userBean.setJobPosition(userEntity.getJobPosition());
		userBean.setInstitutionalMail(userEntity.getInstitutionalMail());
		userBean.setPersonalMail(userEntity.getPersonalMail());
		userBean.setStatus(userEntity.getStatus());
		userBean.setUserType(userEntity.getUserType());

		
		return userBean;
	}


	public static UserEntity ConvertToEntity(UserBean userBean) {
		
		UserEntity userEntity = new UserEntity();
		
		userEntity.setUserId(userBean.getUserId());
		userEntity.setName(userBean.getName());
		userEntity.setMask(userBean.getMask());
		userEntity.setPassword(userBean.getPassword());
		userEntity.setJobPosition(userBean.getJobPosition());
		userEntity.setInstitutionalMail(userBean.getInstitutionalMail());
		userEntity.setPersonalMail(userBean.getPersonalMail());
		userEntity.setStatus(userBean.getStatus());
		userEntity.setUserType(userBean.getUserType());

		return userEntity;

	}

}

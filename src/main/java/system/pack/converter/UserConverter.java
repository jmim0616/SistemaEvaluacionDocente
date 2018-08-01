package system.pack.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.entity.UserEntity;
import system.pack.vo.TeacherBean;
import system.pack.vo.UserBean;


public class UserConverter {
	
	public UserConverter() {

	}

	public static UserBean ConverToVO(UserEntity userEntity) {
		
		UserBean userBean = new UserBean();
		
		userBean.setUserId(Integer.toString(userEntity.getUserId()));
		userBean.setMask(userEntity.getMask());
		userBean.setPassword(userEntity.getPassword());
		userBean.setInstitutionalMail(userEntity.getInstitutionalMail());
		userBean.setPersonalMail(userEntity.getPersonalMail());
		userBean.setJobPosition(userEntity.getJobPosition());
		userBean.setName(userEntity.getName());
		userBean.setStatus(Integer.toString(userEntity.getStatus()));
		userBean.setUserType(Integer.toString(userEntity.getUserType()));
		
		return userBean;
	}

	public static UserEntity ConvertToEntity1(UserBean userBean) {
		
		UserEntity userEntity = new UserEntity();

		userEntity.setUserId(Integer.parseInt(userBean.getUserId()));
		userEntity.setMask(userBean.getMask());
		userEntity.setPassword(userBean.getPassword());
		userEntity.setInstitutionalMail(userBean.getInstitutionalMail());
		userEntity.setPersonalMail(userBean.getPersonalMail());
		userEntity.setJobPosition(userBean.getJobPosition());
		userEntity.setName(userBean.getName());
		userEntity.setStatus(Integer.parseInt(userBean.getStatus()));
		userEntity.setUserType(Integer.parseInt(userBean.getUserType()));
		
		return userEntity;

	}
	
	public static UserEntity ConvertToEntity2(UserBean userBean) {
		
		UserEntity userEntity = new UserEntity();

		userEntity.setMask(userBean.getMask());
		userEntity.setPassword(userBean.getPassword());
		userEntity.setInstitutionalMail(userBean.getInstitutionalMail());
		userEntity.setPersonalMail(userBean.getPersonalMail());
		userEntity.setJobPosition(userBean.getJobPosition());
		userEntity.setName(userBean.getName());
		userEntity.setStatus(Integer.parseInt(userBean.getStatus()));
		userEntity.setUserType(Integer.parseInt(userBean.getUserType()));
		
		return userEntity;

	}

}

package system.pack.boImplementation;


import java.util.Arrays;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;


import system.pack.bointerface.UserBoInterface;
import system.pack.converter.TeacherConverter;
import system.pack.converter.UserConverter;
import system.pack.daoInterface.UserDaoInterface;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.bointerface.UserBoInterface;
import system.pack.converter.TeacherConverter;
import system.pack.daoInterface.SubjectByTeacherDaoInterface;
import system.pack.daoInterface.SubjectByTeacherDaoJpaRepository;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.daoInterface.TeacherDaoJpaRepository;
import system.pack.daoInterface.TeacherStatusDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoJpaRepository;
import system.pack.daoInterface.UserDaoInterface;
import system.pack.daoInterface.UserDaoJpaRepository;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.entity.UserEntity;
import system.pack.helper.JsonResponse;

import system.pack.vo.FacultyBean;

import system.pack.vo.SubjectByProgramBean;
import system.pack.vo.SubjectByTeacherBean;

import system.pack.vo.TeacherBean;
import system.pack.vo.UserBean;

@Service
public class UserBoImpl implements UserBoInterface {

	@Autowired
	UserDaoInterface userDaoInterface;

	@Override
	public UserEntity ValidateUser(String mask, String password) {

		UserEntity user = userDaoInterface.getUserDataByMaskAndPasswd(mask, password);

		if (user == null) {
			return null;
		} else {
			return user;
		}
	}

	@Transactional
	@Override
	public JsonResponse<UserBean, UserEntity> createUser(UserBean userBean, BindingResult bindingResult) {
		try {

			JsonResponse<UserBean, UserEntity> jsonResponse = new JsonResponse<UserBean, UserEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				UserEntity userEntity = UserConverter.ConvertToEntity(userBean);
				
				userEntity.setStatus(1);
				
				userEntity.setUserType(1);

				userDaoInterface.createUser(userEntity);

				jsonResponse.setIsValid(true);

				jsonResponse.setSuccessMessage("El usuario ha sido guardado con exito");

			}

			return jsonResponse;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

			return null;

		}
	}


	@Transactional
	@Override
	public JsonResponse<UserBean, UserEntity> search() {
		
		try {

			JsonResponse<UserBean, UserEntity> jsonResponse = new JsonResponse<UserBean, UserEntity>();
				
				List<UserEntity> users = userDaoInterface.getAll();
				
				if (users.size() < 1) {
					
					jsonResponse.setErrorMessage("No se encontraron resultados para la busqueda");
					
				} else {
					
					jsonResponse.setObjectEntityList(users);
					
				}

			return jsonResponse;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

//			throw new RuntimeException("");

			return null;
			
		}
	}

	@Override
	public JsonResponse<UserBean, UserEntity> update(UserBean userBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<UserBean, UserEntity> jsonResponse = new JsonResponse<UserBean, UserEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				UserEntity userEntity = UserConverter.ConvertToEntity(userBean);

				userDaoInterface.update(userEntity);

				jsonResponse.setIsValid(true);

				jsonResponse.setSuccessMessage("El usuario ha sido modificado con exito.");

			}

			return jsonResponse;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

			// throw new RuntimeException("");

			return null;

		}
	}

	@Override
	public JsonResponse<UserBean, UserEntity> updateStatus(UserBean userBean, BindingResult bindingResult) {

		try {

			JsonResponse<UserBean, UserEntity> jsonResponse = new JsonResponse<UserBean, UserEntity>();
			
			UserEntity userEntity = userDaoInterface.findById(userBean.getUserId());

			if (userEntity.getStatus() == 1) {

				userEntity.setStatus(2);

			} else if (userEntity.getStatus() == 2) {

				userEntity.setStatus(1);
			}


			userDaoInterface.update(userEntity);

			jsonResponse.setSuccessMessage("El estado del usuario se ha sido modificado con exito.");

			return jsonResponse;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

			// throw new RuntimeException("");

			return null;

		}

		
	}

}

package system.pack.boImplementation;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Base64;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import system.pack.bointerface.UserBoInterface;
import system.pack.converter.UserConverter;
import system.pack.daoInterface.UserDaoInterface;
import system.pack.entity.UserEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.UserBean;

@Service
public class UserBoImpl implements UserBoInterface {

	@Autowired
	UserDaoInterface userDaoInterface;

	String superPass = "XMzDd98J03CKm2IxIWQw7g==";

	@Override
	public UserEntity ValidateUser(String mask, String password) {

		UserEntity user = null;

		user = userDaoInterface.getUserDataByMaskAndPasswd(mask, symmetricEncrypt(password, superPass));

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

				if (userDaoInterface.verifyIfUserExist(userBean.getMask())) {
					Map<String, String> errorMessages = new HashMap<>();
					errorMessages.put("mask", "El nombre de usuario ingresado ya existe.");
					jsonResponse.setErrorMessages(errorMessages);
					jsonResponse.setIsValid(false);
					return jsonResponse;
				}

				UserEntity userEntity = UserConverter.ConvertToEntity(userBean);

				userEntity.setStatus(1);

				userEntity.setUserType(1);

				userEntity.setPassword(symmetricEncrypt(userEntity.getPassword(), superPass));

				System.out.println("Pass " + userEntity.getPassword());

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

				List<UserBean> usersToShow = new LinkedList<>();

				for (UserEntity user : users) {
					UserBean userBean = new UserBean();
					userBean = UserConverter.ConverToVO(user);
					userBean.setPassword(symmetricDecrypt(userBean.getPassword(), superPass));
					usersToShow.add(userBean);
				}

				jsonResponse.setObjectBeanList(usersToShow);

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
	public JsonResponse<UserBean, UserEntity> update(UserBean userBean, BindingResult bindingResult) {

		try {

			JsonResponse<UserBean, UserEntity> jsonResponse = new JsonResponse<UserBean, UserEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				if (!userBean.getMask().equalsIgnoreCase(userDaoInterface.findById(userBean.getUserId()).getMask()))
					if (userDaoInterface.verifyIfUserExist(userBean.getMask())) {
						Map<String, String> errorMessages = new HashMap<>();
						errorMessages.put("mask", "El nombre de usuario ingresado ya existe.");
						jsonResponse.setErrorMessages(errorMessages);
						jsonResponse.setIsValid(false);
						return jsonResponse;
					}

				System.out.println("Update user " + userBean);
				
				UserEntity userEntity = UserConverter.ConvertToEntity(userBean);

				userEntity.setPassword(symmetricEncrypt(userEntity.getPassword(), superPass));

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

	public static String symmetricEncrypt(String text, String secretKey) {
		byte[] raw;
		String encryptedString;
		SecretKeySpec skeySpec;
		byte[] encryptText = text.getBytes();
		Cipher cipher;
		try {
			raw = Base64.decodeBase64(secretKey);
			skeySpec = new SecretKeySpec(raw, "AES");
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			encryptedString = Base64.encodeBase64String(cipher.doFinal(encryptText));
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
		return encryptedString;
	}

	public static String symmetricDecrypt(String text, String secretKey) {
		Cipher cipher;
		String encryptedString;
		byte[] encryptText = null;
		byte[] raw;
		SecretKeySpec skeySpec;
		try {
			raw = Base64.decodeBase64(secretKey);
			skeySpec = new SecretKeySpec(raw, "AES");
			encryptText = Base64.decodeBase64(text);
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			encryptedString = new String(cipher.doFinal(encryptText));
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
		return encryptedString;
	}

}

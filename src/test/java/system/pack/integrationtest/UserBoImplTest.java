package system.pack.integrationtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import system.pack.boImplementation.UserBoImpl;
import system.pack.daoInterface.UserDaoInterface;
import system.pack.entity.UserEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.UserBean;

@RunWith(MockitoJUnitRunner.class)
public class UserBoImplTest {
	
	@Mock
	UserDaoInterface userDaoInterface;
	
	@Mock
	BindingResult bindingResult;
	
	@InjectMocks
	UserBoImpl userBoImpl;

	@Test
	public void givingValidUserDataWhenValidateUserThenReturnUserEntity(){
		
		// Arrange
		UserEntity userEntity = Mockito.mock(UserEntity.class);
		when(userDaoInterface.getUserDataByMaskAndPasswd(anyString(), anyString())).thenReturn(userEntity);
		
		// Assert
		assertNotNull(userBoImpl.ValidateUser(anyString(), anyString()));
	}
	
	@Test
	public void givingInvalidUserDataWhenValidateUserThenReturnNull(){
		
		// Arrange
		when(userDaoInterface.getUserDataByMaskAndPasswd(anyString(), anyString())).thenReturn(null);
		
		// Assert
		assertNull(userBoImpl.ValidateUser(anyString(), anyString()));
	}
	
	@Test
	public void givingValidUserWhenCreateUserThenReturnValidJsonResponse(){
		
		when(bindingResult.hasErrors()).thenReturn(false);
		UserBean userBean = Mockito.mock(UserBean.class);
		
		JsonResponse<UserBean, UserEntity> jsonResponse = userBoImpl.createUser(userBean, bindingResult);
		
		assertTrue(jsonResponse.getIsValid());		
	}
	
	@Test
	public void givingInvalidUserWhenCreateUserThenReturnInvalidJsonResponse(){
		
		// Arrange
		
		when(bindingResult.hasErrors()).thenReturn(true);
		UserBean userBean = Mockito.mock(UserBean.class);
		LinkedList<FieldError> errors = new LinkedList<FieldError>();
		errors.add(new FieldError("Object", "field", "defaultMessage"));
		when(bindingResult.getFieldErrors()).thenReturn(errors);
		
		// Act
		JsonResponse<UserBean, UserEntity> jsonResponse = userBoImpl.createUser(userBean, bindingResult);
		
		// Assert
		assertFalse(jsonResponse.getIsValid());		
		assertEquals(1, bindingResult.getFieldErrors().size());
	}
	
	@Test
	public void givingFoundUsersWhenSearchThenReturnListOfUsers (){
		
		List<UserEntity> users = new LinkedList<>();
		users.add(Mockito.mock(UserEntity.class));
		when(userDaoInterface.getAll()).thenReturn(users);
		
		JsonResponse<UserBean, UserEntity> jsonResponse = userBoImpl.search();
		
		assertEquals(users, jsonResponse.getObjectEntityList());
		
	}
	
	@Test
	public void givingNoUsersFoundWhenSearchThenReturnErrorMessage (){
		
		// Arrange
		List<UserEntity> users = new LinkedList<>();
		when(userDaoInterface.getAll()).thenReturn(users);
		
		// Act
		JsonResponse<UserBean, UserEntity> jsonResponse = userBoImpl.search();

		// Assert
		assertNotNull(jsonResponse.getErrorMessage());
		
	}
	
	@Test
	public void givingValidUserWhenUpdateUserThenReturnValidJsonResponse(){
		
		when(bindingResult.hasErrors()).thenReturn(false);
		UserBean userBean = Mockito.mock(UserBean.class);
		
		JsonResponse<UserBean, UserEntity> jsonResponse = userBoImpl.update(userBean, bindingResult);
		
		assertTrue(jsonResponse.getIsValid());		
	}
	
	@Test
	public void givingInvalidUserWhenUpdateUserThenReturnInvalidJsonResponse(){
		
		// Arrange
		when(bindingResult.hasErrors()).thenReturn(true);
		UserBean userBean = Mockito.mock(UserBean.class);
		LinkedList<FieldError> errors = new LinkedList<FieldError>();
		errors.add(new FieldError("Object", "field", "defaultMessage"));
		when(bindingResult.getFieldErrors()).thenReturn(errors);
		
		// Act
		JsonResponse<UserBean, UserEntity> jsonResponse = userBoImpl.update(userBean, bindingResult);
		
		// Assert
		assertFalse(jsonResponse.getIsValid());		
		assertEquals(1, bindingResult.getFieldErrors().size());
	}
	
	@Test
	public void whenUpdateStatusThenUpdateItAndReturnJsonResponse (){
		
		UserEntity userEntity = Mockito.mock(UserEntity.class);
		UserBean userBean = Mockito.mock(UserBean.class);
		when(userEntity.getStatus()).thenReturn(1);
		when(userDaoInterface.findById(anyInt())).thenReturn(userEntity);
		
		JsonResponse<UserBean, UserEntity> jsonResponse = userBoImpl.updateStatus(userBean, bindingResult);
		
		assertNotNull(jsonResponse.getSuccessMessage());
	}
	
}

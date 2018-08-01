package system.pack.boImplementation;

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
import system.pack.vo.SubjectByProgramBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;
import system.pack.vo.UserBean;

@Service
public class UserBoImpl implements UserBoInterface {


	@Autowired
	UserDaoInterface userDaoInterface;
	
	@Autowired
	UserDaoJpaRepository userDaoJpaRepository;

	@Transactional
	@Override
	public JsonResponse<UserBean, UserEntity> create(UserBean userBean, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public JsonResponse<UserBean, UserEntity> update(UserBean userBean, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public JsonResponse<UserBean, UserEntity> updateStatus(UserBean userBean, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public JsonResponse<UserBean, UserEntity> search() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

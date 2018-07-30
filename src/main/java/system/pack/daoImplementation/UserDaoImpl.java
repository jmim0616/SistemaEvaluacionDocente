package system.pack.daoImplementation;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.UserDaoInterface;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.UserEntity;

@Repository
@Transactional
public class UserDaoImpl implements UserDaoInterface {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public UserEntity getUserDataByMaskAndPasswd(String mask, String password) {
		
		Query query = entityManager.createNativeQuery
				("select "
						+ "*"
						+ " from Users t "
						+ "USE INDEX (Users_index1214) "
						+ "where t.mask =:mask "
						+ "and t.password = :passwd"
						, UserEntity.class);
		
		query.setParameter("mask", mask);
		
		query.setParameter("passwd", password);
		
		List<UserEntity> userList  = query.getResultList();
		
		UserEntity user = null;
		
		if (!userList.isEmpty()){
			user = userList.get(0);
		}
		
		return user;
	}

	@Override
	public void createUser(UserEntity userEntity) {
		
		entityManager.merge(userEntity);
		
	}
	
	@Override
	public UserEntity findById(int id) {
		
		System.out.println("Id " + id);
		
		UserEntity userEntity =  entityManager.find(UserEntity.class, id);
		
		System.out.println("user" + userEntity.toString());
		
		return userEntity;
	}

	@Override
	public List<UserEntity> getAll() {
		// TODO Auto-generated method stub
		TypedQuery<UserEntity> query = entityManager.createQuery("select f from UserEntity f", UserEntity.class);
		
		List<UserEntity> users = query.getResultList();
		
		return users;
	}

	@Override
	public void update(UserEntity userEntity) {
		
		entityManager.merge(userEntity);
		
	}

}

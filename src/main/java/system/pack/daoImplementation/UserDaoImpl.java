package system.pack.daoImplementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.daoInterface.UserDaoInterface;
import system.pack.entity.TeacherEntity;
import system.pack.entity.UserEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;

@Repository
@Transactional
public class UserDaoImpl implements UserDaoInterface {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void create(UserEntity userEntity) {

		entityManager.merge(userEntity);
		
	}

	@Override
	public void update(UserEntity userEntity) {
		
		entityManager.merge(userEntity);
		
	}

	@Override
	public void updateState(UserEntity userEntity) {
		
		entityManager.merge(userEntity);
		
	}

	@Override
	public UserEntity findById(int id) {
		
		UserEntity user =  entityManager.find(UserEntity.class, id);
		
		return user;
	}
	
	@Override
	public UserEntity findByName(String name) {
		
		TypedQuery<UserEntity> query = entityManager.createQuery("select u from UserEntity u where u.name =:name", UserEntity.class);
		
		query.setParameter("name", name);
		
		UserEntity user = query.getSingleResult();
		
		return user;
	}

	@Override
	public UserEntity findByMask(String mask) {
		
		TypedQuery<UserEntity> query = entityManager.createQuery("select u from UserEntity u where u.mask =:mask", UserEntity.class);
		
		query.setParameter("mask", mask);
		
		UserEntity user = query.getSingleResult();
		
		return user;

	}

	@Override
	public List<UserEntity> getAll() {
		
		TypedQuery<UserEntity> query = entityManager.createQuery("select u from UserEntity u", UserEntity.class);

		List<UserEntity> users = query.getResultList();
		
		return users;
		
	}
	
	
}

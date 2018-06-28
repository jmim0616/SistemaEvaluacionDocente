package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.DepartmentDaoInterface;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;

@Repository
@Transactional
public class DepartmentDaoImpl implements DepartmentDaoInterface {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void create(DepartmentEntity departmentEntity) {

		entityManager.persist(departmentEntity);
		
	}

	@Override
	public void update(DepartmentEntity departmentEntity) {
		
		entityManager.merge(departmentEntity);
		
	}
	
	@Override
	public List<DepartmentEntity> findByName(String name) {
		
		TypedQuery<DepartmentEntity> query = entityManager.createQuery("select d from DepartmentEntity d where d.name =: name", DepartmentEntity.class);
		
		query.setParameter("name", name);
		
		List<DepartmentEntity> departments = query.getResultList();
		
		return departments;
	}



	
	
}

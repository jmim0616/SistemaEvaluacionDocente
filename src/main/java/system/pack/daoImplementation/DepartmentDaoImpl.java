package system.pack.daoImplementation;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.DepartmentDaoInterface;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;

@Repository
@Transactional
public class DepartmentDaoImpl implements DepartmentDaoInterface {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void create(DepartmentEntity departmentEntity) {

		entityManager.merge(departmentEntity);
		
	}

	@Override
	public void update(DepartmentEntity departmentEntity) {
		
		entityManager.merge(departmentEntity);
		
	}
	
	@Override
	public DepartmentEntity findById(int id) {
		
		DepartmentEntity department =  entityManager.find(DepartmentEntity.class, id);
		
		return department;
	}
	
	@Override
	public Optional<DepartmentEntity> findByName(String name) {
		
		TypedQuery<DepartmentEntity> query = entityManager.createQuery("select d from DepartmentEntity d where d.name =:name", DepartmentEntity.class);
		
		query.setParameter("name", name);
		
		Optional<DepartmentEntity> department = query.getResultList().stream().findFirst();
		
		return department;
	}

	@Override
	public List<DepartmentEntity> getAll() {
		
		TypedQuery<DepartmentEntity> query = entityManager.createQuery("select d from DepartmentEntity d", DepartmentEntity.class);
		
		List<DepartmentEntity> departments = query.getResultList();
		
		return departments;
	}

	@Override
	public boolean isValidDepartmentId(int departmentId) {
		return findById(departmentId) != null;
	}

	
	
}

package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.DepartmentDaoInterface;
import system.pack.daoInterface.FacultyDaoInterface;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;

@Repository
@Transactional
public class FacultyDaoImpl implements FacultyDaoInterface {

	@Autowired
	private EntityManager entityManager;

	
	@Override
	public void create(FacultyEntity facultyEntity) {

		entityManager.persist(facultyEntity);
		
	}

	@Override
	public void update(FacultyEntity facultyEntity) {
		
		entityManager.merge(facultyEntity);
		
	}
	
	@Override
	public List<FacultyEntity> findByName(String name) {
		
		TypedQuery<FacultyEntity> query = entityManager.createQuery("select f from FacultyEntity f where f.name =: name", FacultyEntity.class);
		
		query.setParameter("name", name);
		
		List<FacultyEntity> departments = query.getResultList();
		
		return departments;
	}
	
	@Override
	public List<FacultyEntity> findByDepartmentId(String department) {
		
		TypedQuery<FacultyEntity> query = entityManager.createQuery("select f from FacultyEntity f where f.department =: department", FacultyEntity.class);
		
		query.setParameter("department", department);
		
		List<FacultyEntity> faculties = query.getResultList();
		
		return faculties;
	}


	
	
}

package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.AcademicProgramDaoInterface;
import system.pack.daoInterface.DepartmentDaoInterface;
import system.pack.daoInterface.DisciplinaryAreaDaoInterface;
import system.pack.daoInterface.FacultyDaoInterface;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.DisciplinaryAreaEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;

@Repository
@Transactional
public class DisciplinaryAreaDaoImpl implements DisciplinaryAreaDaoInterface {

	@Autowired
	private EntityManager entityManager;

	
	@Override
	public void create(DisciplinaryAreaEntity disciplinaryAreaEntity){

		entityManager.persist(disciplinaryAreaEntity);
		
	}

	@Override
	public void update(DisciplinaryAreaEntity disciplinaryAreaEntity){
		
		entityManager.merge(disciplinaryAreaEntity);
		
	}
	
	@Override
	public List<DisciplinaryAreaEntity> findByName(String name) {
		
		TypedQuery<DisciplinaryAreaEntity> query = entityManager.createQuery("select da from DisciplinaryAreaEntity da where ap.name =: name", DisciplinaryAreaEntity.class);
		
		query.setParameter("name", name);
		
		List<DisciplinaryAreaEntity> disciplinaryAreas = query.getResultList();
		
		return disciplinaryAreas;
	}
	
	@Override
	public List<DisciplinaryAreaEntity> findByFacultyId(String faculty) {
		
		TypedQuery<DisciplinaryAreaEntity> query = entityManager.createQuery("select da from DisciplinaryAreaEntity da where da.faculty =: faculty", DisciplinaryAreaEntity.class);
		
		query.setParameter("faculty", faculty);
		
		List<DisciplinaryAreaEntity> disciplinaryAreas = query.getResultList();
		
		return disciplinaryAreas;
	}


	
	
}

package system.pack.daoImplementation;

import java.util.List;
import java.util.Optional;

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

		entityManager.merge(disciplinaryAreaEntity);
		
	}

	@Override
	public void update(DisciplinaryAreaEntity disciplinaryAreaEntity){
		
		entityManager.merge(disciplinaryAreaEntity);
		
	}
	
	@Override
	public Optional<DisciplinaryAreaEntity> findByName(String name) {
		
		TypedQuery<DisciplinaryAreaEntity> query = entityManager.createQuery("select da from DisciplinaryAreaEntity da where da.name =:name", DisciplinaryAreaEntity.class);
		
		query.setParameter("name", name);
		
		Optional<DisciplinaryAreaEntity> disciplinaryArea = query.getResultList().stream().findFirst();
		
		return disciplinaryArea;
	}
	
	
	@Override
	public List<DisciplinaryAreaEntity> findByFacultyId(int facultyId) {
		
		TypedQuery<DisciplinaryAreaEntity> query = entityManager.createQuery("select da from DisciplinaryAreaEntity da where da.faculty.facultyId =:facultyId", DisciplinaryAreaEntity.class);
		
		query.setParameter("facultyId", facultyId);
		
		List<DisciplinaryAreaEntity> disciplinaryAreas = query.getResultList();
		
		return disciplinaryAreas;
	}
	
	@Override
	public List<DisciplinaryAreaEntity> getAll() {
		
	TypedQuery<DisciplinaryAreaEntity> query = entityManager.createQuery("select da from DisciplinaryAreaEntity da", DisciplinaryAreaEntity.class);
		
		List<DisciplinaryAreaEntity> disciplinaryAreas = query.getResultList();
		
		return disciplinaryAreas;
	}


	
	
}

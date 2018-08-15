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
import system.pack.daoInterface.FacultyDaoInterface;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;

@Repository
@Transactional
public class AcademicProgramDaoImpl implements AcademicProgramDaoInterface {

	@Autowired
	private EntityManager entityManager;

	
	@Override
	public void create(AcademicProgramEntity academicProgramEntity){

		entityManager.merge(academicProgramEntity);
		
	}

	@Override
	public void update(AcademicProgramEntity academicProgramEntity){
		
		entityManager.merge(academicProgramEntity);
		
	}
	
	@Override
	public Optional<AcademicProgramEntity> findByName(String name) {
		
		TypedQuery<AcademicProgramEntity> query = entityManager.createQuery("select ap from AcademicProgramEntity ap where ap.name =:name", AcademicProgramEntity.class);
		
		query.setParameter("name", name);
		
		Optional<AcademicProgramEntity> academicProgram = query.getResultList().stream().findFirst();
		
		return academicProgram;
	}
	
	@Override
	public List<AcademicProgramEntity> findByFacultyId(int facultyId) {
		
		TypedQuery<AcademicProgramEntity> query = entityManager.createQuery("select ap from AcademicProgramEntity ap where ap.faculty.facultyId =:facultyId", AcademicProgramEntity.class);
		
		query.setParameter("facultyId", facultyId);
		
		List<AcademicProgramEntity> academicPrograms = query.getResultList();
		
		return academicPrograms;
	}

	@Override
	public List<AcademicProgramEntity> getAll() {
		
	TypedQuery<AcademicProgramEntity> query = entityManager.createQuery("select ap from AcademicProgramEntity ap", AcademicProgramEntity.class);
		
		List<AcademicProgramEntity> academicPrograms = query.getResultList();
		
		return academicPrograms;
	}


	
	
}

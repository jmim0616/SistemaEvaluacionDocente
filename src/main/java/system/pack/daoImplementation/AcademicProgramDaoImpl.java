package system.pack.daoImplementation;

import java.util.List;

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
	public AcademicProgramEntity findByName(String name) {
		
		TypedQuery<AcademicProgramEntity> query = entityManager.createQuery("select ap from AcademicProgramEntity ap where ap.name =:name", AcademicProgramEntity.class);
		
		query.setParameter("name", name);
		
		AcademicProgramEntity academicProgram = query.getSingleResult();
		
		return academicProgram;
	}
	
	@Override
	public List<AcademicProgramEntity> findByFacultyId(String faculty) {
		
		TypedQuery<AcademicProgramEntity> query = entityManager.createQuery("select ap from AcademicProgramEntity ap where ap.faculty.getFacultyId() =:faculty", AcademicProgramEntity.class);
		
		query.setParameter("faculty", faculty);
		
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

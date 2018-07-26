package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.AcademicPeriodDaoInterface;
import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.TeacherEntity;


@Repository
@Transactional
public class AcademicPeriodDaoImpl implements AcademicPeriodDaoInterface {

	
	@Autowired
	private EntityManager entityManager;
	
	
	@Override
	public void create(AcademicPeriodEntity academicPeriodEntity) {
		
		entityManager.merge(academicPeriodEntity);
		
	}

	@Override
	public void update(AcademicPeriodEntity academicPeriodEntity) {
		
		entityManager.merge(academicPeriodEntity);
		
	}


	@Override
	public AcademicPeriodEntity findById(int id) {

		AcademicPeriodEntity academicPeriod=  entityManager.find(AcademicPeriodEntity.class, id);
		
		return academicPeriod;
		
	}

	@Override
	public AcademicPeriodEntity findByName(String name) {
	
		TypedQuery<AcademicPeriodEntity> query = entityManager.createQuery("select ap from AcademicPeriodEntity ap where ap.name =:name", AcademicPeriodEntity.class);
		
		query.setParameter("name", name);
		
		AcademicPeriodEntity academicPeriod = query.getSingleResult();
		
		return academicPeriod;
		
	}

	@Override
	public AcademicPeriodEntity findByInitialDate(String initialDate) {

		TypedQuery<AcademicPeriodEntity> query = entityManager.createQuery("select ap from AcademicPeriodEntity ap where ap.initialDate =:initialDate", AcademicPeriodEntity.class);
		
		query.setParameter("initialDate", initialDate);
		
		AcademicPeriodEntity academicPeriod = query.getSingleResult();
		
		return academicPeriod;
		
	}

	@Override
	public AcademicPeriodEntity findByEndDate(String endDate) {
		
		TypedQuery<AcademicPeriodEntity> query = entityManager.createQuery("select ap from AcademicPeriodEntity ap where ap.endDate =:endDate", AcademicPeriodEntity.class);
		
		query.setParameter("endDate", endDate);
		
		AcademicPeriodEntity academicPeriod = query.getSingleResult();
		
		return academicPeriod;
	}

	@Override
	public List<AcademicPeriodEntity> findByYear(String year) {
		
		TypedQuery<AcademicPeriodEntity> query = entityManager.createQuery("select ap from AcademicPeriodEntity ap where ap.name like '%year%'", AcademicPeriodEntity.class);
		
		query.setParameter("endDate", year);
		
		List<AcademicPeriodEntity> academicPeriods = query.getResultList();
		
		return academicPeriods;
		
	}
	
	

}

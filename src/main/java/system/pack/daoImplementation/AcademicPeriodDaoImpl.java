package system.pack.daoImplementation;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.AcademicPeriodDaoInterface;
import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.CourseEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.UserEntity;


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
	public Optional<AcademicPeriodEntity> findByName(String name) {
	
		TypedQuery<AcademicPeriodEntity> query = entityManager.createQuery("select ap from AcademicPeriodEntity ap where ap.name =:name", AcademicPeriodEntity.class);
		
		query.setParameter("name", name);
		
		Optional<AcademicPeriodEntity> academicPeriod = query.getResultList().stream().findFirst();
		
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
		
		TypedQuery<AcademicPeriodEntity> query = entityManager.createQuery("select ap from AcademicPeriodEntity ap where ap.name like CONCAT('%',:year,'%')", AcademicPeriodEntity.class);
		
		query.setParameter("year", year);
		
		List<AcademicPeriodEntity> academicPeriods = query.getResultList();
		
		return academicPeriods;
		
	}

	@Override
	public int getAcademicPeriodByName(String academicPeriodName) {
		
		int academicPeriodId = 0;
		
		Query query = entityManager.createNativeQuery
				("select "
						+ "academicPeriodId"
						+ " from academic_periods t "
						+ "USE INDEX (academicPeriods_index1218) "
						+ "where t.name =:name "
						);
		
		query.setParameter("name", academicPeriodName);
		
		List<Object[]> courseEntities  = query.getResultList();
		
		if (!courseEntities.isEmpty()){
			Object result = courseEntities.get(0);
			if (result instanceof Integer){
				academicPeriodId = (Integer) result;
			}
		}
		
		return academicPeriodId;
	}
	
	
	@Override
	public AcademicPeriodEntity getlastRecord() {
		
		TypedQuery<AcademicPeriodEntity> query = entityManager.createQuery("select max(ap) from AcademicPeriodEntity ap", AcademicPeriodEntity.class);
		
		AcademicPeriodEntity academicPeriod = query.getSingleResult();
		
		return academicPeriod;
		
	}

	@Override
	public List<Integer> getPeriodsToProcess() {
		
		Query query = entityManager.createNativeQuery(
				"select academicPeriodId from ( " +
						"select academicPeriodId " +
						"from academic_periods t " +
						"order by initialDate DESC)t limit 3 ");
		
		return query.getResultList();

	}
	
	

}

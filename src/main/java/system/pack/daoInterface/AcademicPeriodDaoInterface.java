package system.pack.daoInterface;

import java.util.List;
import java.util.Optional;

import system.pack.entity.AcademicPeriodEntity;


public interface AcademicPeriodDaoInterface {
	
	public void create(AcademicPeriodEntity academicPeriodEntity);
	
	public void update(AcademicPeriodEntity academicPeriodEntity);
	
	public AcademicPeriodEntity findById(int id);
	
	public Optional<AcademicPeriodEntity> findByName(String name);
	
	public AcademicPeriodEntity findByInitialDate(String initialDate);
	
	public AcademicPeriodEntity findByEndDate(String endDate);
	
	public List<AcademicPeriodEntity> findByYear(String year);

	public AcademicPeriodEntity getlastRecord();
	
}

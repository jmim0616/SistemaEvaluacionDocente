package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.ClassVisitEntity;
import system.pack.entity.CoevaluationEntity;



public interface CoevaluationDaoInterface {
	
	public void create(CoevaluationEntity coevaluationEntity);
	
	public void update(CoevaluationEntity coevaluationEntity);
	
	public List<CoevaluationEntity> findByCourseId(int course);
	
	
}

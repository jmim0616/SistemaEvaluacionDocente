package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.ClassVisitEntity;



public interface ClassVisitDaoInterface {
	
	public void create(ClassVisitEntity classVisitEntity);
	
	public void update(ClassVisitEntity classVisitEntity);
	
	public List<ClassVisitEntity> findByCourseId(int course);
	
	
}

package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.FeedbackTypeEntity;
import system.pack.entity.SubjectStatusEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.vo.TeacherBean;

public interface FeedbackTypeDaoInterface {
	
	public FeedbackTypeEntity findById(int id);
	
	public FeedbackTypeEntity findByDescription(String description);
	
	public List<FeedbackTypeEntity> getAll();

}

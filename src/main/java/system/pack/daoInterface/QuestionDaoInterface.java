package system.pack.daoInterface;

import java.util.List;

import system.pack.entity.QuestionEntity;
import system.pack.entity.SubjectByTeacherEntity;


public interface QuestionDaoInterface {
	
	public void create(QuestionEntity questionEntity);
	
	public QuestionEntity findById(int id);
	

	
}

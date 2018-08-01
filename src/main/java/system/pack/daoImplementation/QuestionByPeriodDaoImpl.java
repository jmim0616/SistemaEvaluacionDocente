package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.QuestionByPeriodDaoInterface;
import system.pack.daoInterface.SubjectByTeacherDaoInterface;
import system.pack.entity.QuestionByPeriodEntity;
import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.TeacherEntity;

@Repository
@Transactional
public class QuestionByPeriodDaoImpl implements QuestionByPeriodDaoInterface {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public void create(QuestionByPeriodEntity questionByPeriodEntity) {
		
		entityManager.merge(questionByPeriodEntity);
		
	}

	public List<QuestionByPeriodEntity> findByDepartmentId(String department) {
		
		TypedQuery<QuestionByPeriodEntity> query = entityManager.createQuery("select qp from QuestionByPeriodEntity qp where qp.department.getDepartmentId() =:department", QuestionByPeriodEntity.class);
		
		query.setParameter("department", department);
		
		List<QuestionByPeriodEntity> questionsByPeriod = query.getResultList();
		
		return questionsByPeriod;
	}
	
	
	public List<QuestionByPeriodEntity> findByCourseId(String course) {
		
		TypedQuery<QuestionByPeriodEntity> query = entityManager.createQuery("select qp from QuestionByPeriodEntity qp where qp.course.getCourseId() =:course", QuestionByPeriodEntity.class);
		
		query.setParameter("course", course);
		
		List<QuestionByPeriodEntity> questionsByPeriod = query.getResultList();
		
		return questionsByPeriod;
		
	}
	
	public List<QuestionByPeriodEntity> findByQuestionId(String question) {
		
		TypedQuery<QuestionByPeriodEntity> query = entityManager.createQuery("select qp from QuestionByPeriodEntity qp where qp.question.getQuestionId() =:question", QuestionByPeriodEntity.class);
		
		query.setParameter("question", question);
		
		List<QuestionByPeriodEntity> questionsByPeriod = query.getResultList();
		
		return questionsByPeriod;
		
	}
	
	public List<QuestionByPeriodEntity> findByAcademicPeriodId(String academicPeriod) {
		
		TypedQuery<QuestionByPeriodEntity> query = entityManager.createQuery("select qp from QuestionByPeriodEntity qp where qp.academicPeriod.getAcademicPeriodId() =:academicPeriod", QuestionByPeriodEntity.class);
		
		query.setParameter("academicPeriod", academicPeriod);
		
		List<QuestionByPeriodEntity> questionsByPeriod = query.getResultList();
		
		return questionsByPeriod;
		
	}





	
	
}

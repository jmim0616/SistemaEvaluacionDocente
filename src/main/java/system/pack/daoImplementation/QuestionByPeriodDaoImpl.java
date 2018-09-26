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

	public List<QuestionByPeriodEntity> findByDepartmentId(int departmentId) {
		
		TypedQuery<QuestionByPeriodEntity> query = entityManager.createQuery("select qp from QuestionByPeriodEntity qp where qp.department.departmentId =:departmentId", QuestionByPeriodEntity.class);
		
		query.setParameter("departmentId", departmentId);
		
		List<QuestionByPeriodEntity> questionsByPeriod = query.getResultList();
		
		return questionsByPeriod;
	}
	
	
	public List<QuestionByPeriodEntity> findByCourseId(int courseId) {
		
		TypedQuery<QuestionByPeriodEntity> query = entityManager.createQuery("select qp from QuestionByPeriodEntity qp where qp.course.courseId =:courseId", QuestionByPeriodEntity.class);
		
		query.setParameter("courseId", courseId);
		
		List<QuestionByPeriodEntity> questionsByPeriod = query.getResultList();
		
		return questionsByPeriod;
		
	}
	
	public List<QuestionByPeriodEntity> findByQuestionId(int questionId) {
		
		TypedQuery<QuestionByPeriodEntity> query = entityManager.createQuery("select qp from QuestionByPeriodEntity qp where qp.question.questionIds =:questionId", QuestionByPeriodEntity.class);
		
		query.setParameter("questionId", questionId);
		
		List<QuestionByPeriodEntity> questionsByPeriod = query.getResultList();
		
		return questionsByPeriod;
		
	}
	
	public List<QuestionByPeriodEntity> findByAcademicPeriodId(int academicPeriodId) {
		
		TypedQuery<QuestionByPeriodEntity> query = entityManager.createQuery("select qp from QuestionByPeriodEntity qp where qp.academicPeriod.academicPeriodId =:academicPeriodId", QuestionByPeriodEntity.class);
		
		query.setParameter("academicPeriodId", academicPeriodId);
		
		List<QuestionByPeriodEntity> questionsByPeriod = query.getResultList();
		
		return questionsByPeriod;
		
	}





	
	
}

package system.pack.daoImplementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import system.pack.daoInterface.CourseFeedbackDaoInterface;
import system.pack.entity.CourseEntity;
import system.pack.entity.CourseFeedbackEntity;

@Repository
@Transactional
public class CourseFeedbackDaoImpl implements CourseFeedbackDaoInterface {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void create(CourseFeedbackEntity courseFeedbackEntity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CourseFeedbackEntity courseFeedbackEntity) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<CourseFeedbackEntity> findByFeedBackTypeId(int feedBackTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseFeedbackEntity> findByCourseId(int courseId) {

		TypedQuery<CourseFeedbackEntity> query = entityManager.createQuery("select cf from CourseFeedbackEntity cf where cf.course.courseId =:courseId", CourseFeedbackEntity.class);

		query.setParameter("courseId", courseId);

		List<CourseFeedbackEntity> courseFeedbacks = query.getResultList();

		return courseFeedbacks;
	}

}

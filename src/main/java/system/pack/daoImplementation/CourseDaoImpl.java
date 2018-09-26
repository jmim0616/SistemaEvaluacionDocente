package system.pack.daoImplementation;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import system.pack.daoInterface.CourseDaoInterface;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.CourseEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.CourseBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.TeacherBean;

@Repository
@Transactional
public class CourseDaoImpl implements CourseDaoInterface {

	@Autowired
	private EntityManager entityManager;

	@Override
	public void create(CourseEntity courseEntity) {

		entityManager.merge(courseEntity);
		
	}

	@Override
	public void delete(CourseEntity courseEntity) {
		
		entityManager.remove(courseEntity);
		
	}


	@Override
	public CourseEntity findById(int id) {
		
		CourseEntity course =  entityManager.find(CourseEntity.class, id);
		
		return course;
	}
	
	@Override
	public List<CourseEntity> findByAcademicPeriodId(int academicPeriodId) {
		
		TypedQuery<CourseEntity> query = entityManager.createQuery("select c from CourseEntity c where c.academicPeriod.academicPeriodId =:academicPeriodId", CourseEntity.class);
		
		query.setParameter("academicPeriodId", academicPeriodId);
		
		List<CourseEntity> courses = query.getResultList();
		
		return courses;
		
	}
	
	@Override
	public List<CourseEntity> findByTeacherId(int teacherId) {
		
		TypedQuery<CourseEntity> query = entityManager.createQuery("select c from CourseEntity c where c.teacher.teacherId =:teacherId", CourseEntity.class);
		
		query.setParameter("teacherId", teacherId);
		
		List<CourseEntity> courses = query.getResultList();
		
		return courses;
		
	}
	
	@Override
	public List<CourseEntity> findBySubjectId(int subjectId) {
		
		TypedQuery<CourseEntity> query = entityManager.createQuery("select c from CourseEntity c where c.subject.subjectId =:subjectId", CourseEntity.class);
		
		query.setParameter("subjectId", subjectId);
		
		List<CourseEntity> courses = query.getResultList();
		
		return courses;
		
	}

	@Override
	public List<AcademicPeriodEntity> searchAcademicPeriodsBySubjectOfTeacher(SubjectBean subjectBean,
			BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List searchEvaluationsByAcademicPeriodOfTeacher(SubjectBean subjectBean, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List searchEvaluationsByCourse(CourseBean courseBean, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CourseEntity> searchCoursesBySubject(SubjectBean subjectBean, BindingResult bindingResult) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

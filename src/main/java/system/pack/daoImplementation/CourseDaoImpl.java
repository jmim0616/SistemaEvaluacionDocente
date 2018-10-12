package system.pack.daoImplementation;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import system.pack.daoInterface.AcademicPeriodDaoInterface;
import system.pack.daoInterface.CourseDaoInterface;
import system.pack.daoInterface.SubjectDaoInterface;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.CourseEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.fullview.Data;
import system.pack.fullview.Period;
import system.pack.fullview.Questions;
import system.pack.fullview.Row;
import system.pack.fullview.RowHeader;
import system.pack.helper.JsonResponse;
import system.pack.vo.CourseBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.TeacherBean;

@Repository
@Transactional
public class CourseDaoImpl implements CourseDaoInterface {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private SubjectDaoInterface subjectDaoInterface;
	
	@Autowired
	private AcademicPeriodDaoInterface academicPeriodDaoImpl;

	@Override
	public void create(CourseEntity courseEntity) {

		entityManager.merge(courseEntity);

	}

	@Override
	public void update(CourseEntity courseEntity) {

		entityManager.merge(courseEntity);

	}

	@Override
	public void delete(CourseEntity courseEntity) {

		entityManager.remove(courseEntity);

	}

	@Override
	public CourseEntity findById(int id) {

		CourseEntity course = entityManager.find(CourseEntity.class, id);

		return course;
	}

	@Override
	public CourseEntity findByGroupId(int groupId) {

		TypedQuery<CourseEntity> query = entityManager
				.createQuery("select c from CourseEntity c where c.groupId =:groupId", CourseEntity.class);

		query.setParameter("groupId", groupId);

		CourseEntity courseEntity = query.getSingleResult();

		return courseEntity;
	}

	@Override
	public List<CourseEntity> findByAcademicPeriodId(int academicPeriodId) {

		TypedQuery<CourseEntity> query = entityManager.createQuery(
				"select c from CourseEntity c where c.academicPeriod.academicPeriodId =:academicPeriodId",
				CourseEntity.class);

		query.setParameter("academicPeriodId", academicPeriodId);

		List<CourseEntity> courses = query.getResultList();

		return courses;

	}

	@Override
	public List<CourseEntity> findByTeacherId(int teacherId) {

		TypedQuery<CourseEntity> query = entityManager
				.createQuery("select c from CourseEntity c where c.teacher.teacherId =:teacherId", CourseEntity.class);

		query.setParameter("teacherId", teacherId);

		List<CourseEntity> courses = query.getResultList();

		return courses;

	}

	@Override
	public List<CourseEntity> findBySubjectId(int subjectId) {

		TypedQuery<CourseEntity> query = entityManager
				.createQuery("select c from CourseEntity c where c.subject.subjectId =:subjectId", CourseEntity.class);

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

	@Override
	public Data getCompareView(CourseBean courseBean) {
		
		courseBean.setAcademicPeriod("2018-2");
		
		System.out.println("CourseBean2 " + courseBean);
		
		Optional<SubjectEntity> subjectEntity = null;
		int academicPeriodId = 0;
		List<Integer> periodsToProcess = new LinkedList<>();
		
		String sql = "select " +  "distinct (courses.courseId) courseId, " + "academic_periods.name periodName, " + "departments.name departmentName, " + "subjects.name signatureName, "
				+ "courses.teacherId, " + "courses.groupId, " + "courses.isVirtual " + "from 	academic_periods, "
				+ "courses use index (Courses_index1192), " + "subjects use index (PRIMARY), "
				+ "questions_by_period use index (courseId), " + "departments use index (PRIMARY) "
				+ "where	courses.academicPeriodId = academic_periods.academicPeriodId "
				+ "and	questions_by_period.courseId = courses.courseId " 
				+ "and	departments.departmentId = questions_by_period.departmentId "
				+ "and	subjects.subjectId = courses.subjectId ";
		
		System.out.println("Sql");
		
		if (courseBean.getCourseId() != null){
			sql = sql + " and courses.courseId = :courseId";
		}
		
		System.out.println("Sql " + sql);
		
		if (courseBean.getTeacher() != null){
			sql = sql + " and courses.teacherId = :teacherId";
		}
		
		System.out.println("Sql " + sql);
		
		if (courseBean.getSubject() != null){
			subjectEntity = subjectDaoInterface.findByName(courseBean.getSubject());
			sql = sql + " and courses.subjectId = :subjectId";
		}
		
		System.out.println("Sql " + sql);
		
		if (courseBean.getAcademicPeriod() != null){
			academicPeriodId = academicPeriodDaoImpl.getAcademicPeriodByName(courseBean.getAcademicPeriod());
			periodsToProcess.add(academicPeriodId);
			sql = sql + " and academic_periods.academicPeriodId = :academicPeriodId";
		}
		else{
			periodsToProcess = academicPeriodDaoImpl.getPeriodsToProcess();
		}
		
		System.out.println("Sql " + sql);
		
		if (courseBean.getCourseId() == null && periodsToProcess.size() == 0){
			return null;
		}
		
		System.out.println("Past valid");
		
		for (Integer period : periodsToProcess){
			
			Query query = entityManager.createNativeQuery (sql);
			
			if (courseBean.getCourseId() != null){
				query.setParameter("courseId", courseBean.getCourseId());
			}

			if (courseBean.getTeacher() != null){
				query.setParameter("teacherId", courseBean.getTeacher());
			}
			
			if (courseBean.getSubject() != null){
				query.setParameter("subjectId", subjectEntity.get().getSubjectId());
			}
			
			if (period != null){
				query.setParameter("academicPeriodId", period);
			}
			System.out.println("Last Sql " + sql);
			
			List<Object[]> rows  = query.getResultList();
			
			System.out.println("Count: "  + rows.size() + "Row " + rows.get(0));
		}		

		return null;
	}

}

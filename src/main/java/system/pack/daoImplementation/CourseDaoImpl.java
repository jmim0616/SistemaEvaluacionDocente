package system.pack.daoImplementation;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import system.pack.entity.CourseFeedbackEntity;
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

		System.out.println("CourseBean2 " + courseBean);

		Optional<SubjectEntity> subjectEntity = null;
		int academicPeriodId = 0;
		List<Integer> periodsToProcess = new LinkedList<>();

		String sql = "select " + "distinct (courses.courseId) courseId, " + "academic_periods.name periodName, "
				+ "departments.name departmentName, " + "subjects.name signatureName, " + "courses.teacherId, "
				+ "courses.groupId, " + "courses.isVirtual " + "from 	academic_periods, "
				+ "courses use index (Courses_index1192), " + "subjects use index (PRIMARY), "
				+ "questions_by_period use index (courseId), " + "departments use index (PRIMARY) "
				+ "where	courses.academicPeriodId = academic_periods.academicPeriodId "
				+ "and	questions_by_period.courseId = courses.courseId "
				+ "and	departments.departmentId = questions_by_period.departmentId "
				+ "and	subjects.subjectId = courses.subjectId ";

		System.out.println("Sql");

		if (!courseBean.getCourseId().equals("")) {
			sql = sql + " and courses.courseId = :courseId";
		}

		System.out.println("Sql " + sql);

		if (!courseBean.getTeacher().equals("")) {
			sql = sql + " and courses.teacherId = :teacherId";
		}

		System.out.println("Sql " + sql);

		if (!courseBean.getSubject().equals("")) {
			subjectEntity = subjectDaoInterface.findByName(courseBean.getSubject());
			sql = sql + " and courses.subjectId = :subjectId";
		}

		System.out.println("Sql " + sql);

		if (!courseBean.getAcademicPeriod().equals("")) {
			academicPeriodId = academicPeriodDaoImpl.getAcademicPeriodByName(courseBean.getAcademicPeriod());
			periodsToProcess.add(academicPeriodId);
			sql = sql + " and academic_periods.academicPeriodId = :academicPeriodId";
		} else {
			periodsToProcess = academicPeriodDaoImpl.getPeriodsToProcess();
		}

		System.out.println("Sql " + sql);

		if (courseBean.getCourseId() == null && periodsToProcess.size() == 0) {
			return null;
		}

		System.out.println("Past valid");

		List<Period> periodsToSend = new LinkedList<>();
		for (Integer period : periodsToProcess) {

			System.out.println("Period " + period);
			
			System.out.println("Sql pre" + sql );
			
			String sqlPeriod = sql + " and academic_periods.academicPeriodId = :academicPeriodId";
			Query query = entityManager.createNativeQuery(sqlPeriod);

			if (!courseBean.getCourseId().equals("")) {
				query.setParameter("courseId", courseBean.getCourseId());
			}

			if (!courseBean.getTeacher().equals("")) {
				query.setParameter("teacherId", courseBean.getTeacher());
			}

			if (!courseBean.getSubject().equals("")) {
				System.out.println("courseBean.getSubject()" + "|" + courseBean.getSubject() + "|");
				query.setParameter("subjectId", subjectEntity.get().getSubjectId());
			}

			if (period != null) {
				query.setParameter("academicPeriodId", period);
			}
			System.out.println("Last Sql " + sqlPeriod);

			List<Object[]> rows = query.getResultList();

			if (rows.size() > 0) {
				List<Row> rowsToSend = new LinkedList<>();
				for (Object[] row : rows) {
					RowHeader header = new RowHeader();
					header.setCourseId((int) row[0]);
					header.setPeriodName(row[1].toString());
					header.setDepartmentName(row[2].toString());
					header.setSignatureName(row[3].toString());
					header.setTeacherId((int) row[4]);
					header.setGroupId((int) row[5]);
					header.setIsVirtual(row[6].toString());
					System.out.println("Header " + header);

					String sqlQuestions = "select " + "questions.question, " + "questions_by_period.percentage "
							+ "from 	questions_by_period, " + "questions "
							+ "where 	questions_by_period.courseId = :courseId "
							+ "and	 	questions.questionId = questions_by_period.questionId "
							+ "order by questions_by_period.questionId";

					query = entityManager.createNativeQuery(sqlQuestions);
					query.setParameter("courseId", header.getCourseId());

					rows = query.getResultList();

					List<Questions> questionsToSend = new LinkedList<>();
					for (Object[] questions : rows) {
						Questions question = new Questions();
						question.setQuestion(questions[0].toString());
						question.setResponse((int) questions[1]);
						questionsToSend.add(question);
					}

					rowsToSend.add(new Row(header, questionsToSend));
				}

				periodsToSend.add(new Period(rowsToSend));
			}

		}

		return new Data(periodsToSend);
	}

	@Override
	public List<CourseEntity> getCoursesByTeacher(String teacherId) {

		String sql = "Select * from courses where teacherId = :teacherId";
		Query query = entityManager.createNativeQuery(sql, CourseEntity.class);

		query.setParameter("teacherId", teacherId);

		return query.getResultList();
	}

	@Override
	public List<CourseFeedbackEntity> getFeedBacksByCourse(CourseBean courseBean) {
		String sql = "select * from coursefeedbacks where courseId = :courseId";
		Query query = entityManager.createNativeQuery(sql, CourseFeedbackEntity.class);
		query.setParameter("courseId", courseBean.getCourseId());
		List<CourseFeedbackEntity> list = query.getResultList();

		System.out.println("Step on");
		return list;
	}

	@Override
	public List<CourseEntity> getCourses(CourseBean courseBean) {
		String sql = "Select * from courses where 1=1";
		if (!courseBean.getGroupId().equals("")) {
			sql += " and groupId = :groupId";
		}
		if (!courseBean.getAcademicPeriod().equals("")) {
			int academicPeriod = academicPeriodDaoImpl.getAcademicPeriodByName(courseBean.getAcademicPeriod());
			if (academicPeriod != 0) {
				sql += " and academicPeriodId = :academicPeriodId";
			}
			else{
				sql += " and -1 = 1";
			}
		}
		if (!courseBean.getTeacher().equals("")) {
			sql += " and teacherId = :teacherId";
		}
		if (!courseBean.getSubject().equals("")) {
			Optional<SubjectEntity> signature = subjectDaoInterface.findByName(courseBean.getSubject());
			if (signature.isPresent()) {
				if (signature.get().getSubjectId() != 0) {
					sql += " and subjectId = :subjectId";
				}
			}
			else{
				sql += " and -1 = 1";
			}

		}
		Query query = entityManager.createNativeQuery(sql, CourseEntity.class);
		if (!courseBean.getGroupId().equals("")) {
			query.setParameter("groupId", courseBean.getGroupId());
		}
		if (!courseBean.getAcademicPeriod().equals("")) {
			int academicPeriod = academicPeriodDaoImpl.getAcademicPeriodByName(courseBean.getAcademicPeriod());
			if (academicPeriod != 0) {
				query.setParameter("academicPeriodId", academicPeriod);
			}
		}
		if (!courseBean.getTeacher().equals("")) {
			query.setParameter("teacherId", courseBean.getTeacher());
		}
		if (!courseBean.getSubject().equals("")) {
			Optional<SubjectEntity> signature = subjectDaoInterface.findByName(courseBean.getSubject());
			if (signature.isPresent()) {
				if (signature.get().getSubjectId() != 0) {
					query.setParameter("subjectId", signature.get().getSubjectId());
				}
			}

		}
		return query.getResultList();
	}

}

package system.pack.helper;
//package system.pack.helper;
//
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.persistence.EntityManager;
//import javax.persistence.Query;
//import javax.persistence.TypedQuery;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import hibernate_jpa_tutorial_beginners.jpa_hibernate.JpaHibernateApplication;
//import hibernate_jpa_tutorial_beginners.jpa_hibernate.entities.Course;
//import hibernate_jpa_tutorial_beginners.jpa_hibernate.entities.Student;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = JpaHibernateApplication.class)
//public class JPQLTest {
//
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	EntityManager entity_manager;
//
//	@org.junit.Before
//	public void Before() {
//
//		logger.info("*******************");
//
//	}
//
//	@Test
//	public void jpql_basic() {
//
//		List result = entity_manager.createQuery("select c From Course c").getResultList();
//
//		logger.info("select c From Course c -> {}", result);
//
//	}
//
//	@Test
//	public void jpql_typed() {
//
//		// List<Course> list_courses = entity_manager.createQuery("select c From
//		// Course c", Course.class).getResultList();
//		// ó
//		// así
//		TypedQuery<Course> query = entity_manager.createQuery("select c From Course c", Course.class);
//
//		List<Course> resultlist = query.getResultList();
//
//		logger.info("select c From Course c TYPED -> {}", resultlist);
//
//	}
//
//	@Test
//	public void jpql_where() {
//
//		TypedQuery<Course> query = entity_manager.createQuery("select c From Course c where name like '%vlad%'",
//				Course.class);
//
//		List<Course> resultlist = query.getResultList();
//
//		logger.info("select c From Course c where name like '%vlad%' -> {}", resultlist);
//
//	}
//
//	@Test
//	public void jpql_named_query_basic() {
//
//		Query query = entity_manager.createNamedQuery("query_get_all_courses");
//
//		List resultlist = query.getResultList();
//
//		logger.info("Named Query - select c From Course c -> {}", resultlist);
//	}
//
//	@Test
//	public void jpql_named_query_typed() {
//
//		TypedQuery<Course> query = entity_manager.createNamedQuery("query_get_all_courses", Course.class);
//
//		List<Course> resultlist = query.getResultList();
//
//		logger.info("Named Query - select c From Course c TYPED -> {}", resultlist);
//
//	}
//
//	@Test
//	public void jpql_named_query_where() {
//
//		TypedQuery<Course> query = entity_manager.createNamedQuery("query_get_all_courses_where", Course.class);
//
//		String parameter = "%vlad%";
//
//		query.setParameter("name", parameter);
//
//		List<Course> resultlist = query.getResultList();
//
//		logger.info("Named Query - select c From Course c where name like '%vlad%' -> {}", resultlist);
//
//	}
//
//	@Test
//	public void jpql_courses_without_students() {
//
//		TypedQuery<Course> query = entity_manager.createQuery("select c from Course c where c.students is empty",
//				Course.class);
//
//		List<Course> resultlist = query.getResultList();
//
//		logger.info("Results -> {}", resultlist);
//
//	}
//
//	@Test
//	public void jpql_courses_withatleast2_students() {
//
//		TypedQuery<Course> query = entity_manager.createQuery("select c from Course c where size (c.students) >= 2",
//				Course.class);
//
//		List<Course> resultlist = query.getResultList();
//
//		logger.info("Results -> {}", resultlist);
//
//	}
//
//	@Test
//	public void jpql_courses_ordered_by_students() {
//
//		TypedQuery<Course> query = entity_manager.createQuery("select c from Course c order by size (c.students) desc",
//				Course.class);
//
//		List<Course> resultlist = query.getResultList();
//
//		logger.info("Results -> {}", resultlist);
//
//	}
//
//	@Test
//	public void jpql_students_with_passports_in_a_certain_pattern() {
//
//		TypedQuery<Student> query = entity_manager
//				.createQuery("select s from Student s where s.passport.number like '%123%'", Student.class);
//
//		List<Student> resultlist = query.getResultList();
//
//		logger.info("Results -> {}", resultlist);
//
//	}
//
//	@Test
//
//	public void join() {
//
//		Query query = entity_manager.createQuery("select c, s from Course c JOIN c.students s");
//
//		List<Object[]> resultlist = query.getResultList();
//
//		logger.info("Results -> {}", resultlist.size());
//
//		for (Object[] result : resultlist) {
//
//			logger.info("Course{} Student{}", result[0], result[1]);
//
//		}
//	}
//
//	
//	
//	@Test
//	public void left_join() {
//
//		Query query = entity_manager.createQuery("select c, s from Course c LEFT JOIN c.students s");
//
//		List<Object[]> resultlist = query.getResultList();
//
//		logger.info("Results -> {}", resultlist.size());
//
//		for (Object[] result : resultlist) {
//
//			logger.info("Course{} Student{}", result[0], result[1]);
//
//		}
//
//	}
//	
//	
//
//	@Test
//	public void cross_join() {
//
//		Query query = entity_manager.createQuery("select c, s from Course c , Student  s");
//
//		List<Object[]> resultlist = query.getResultList();
//
//		logger.info("Results -> {}", resultlist.size());
//
//		for (Object[] result : resultlist) {
//
//			logger.info("Course{} Student{}", result[0], result[1]);
//
//		}
//
//	}
//	
//	
//	
//	
//	
//
//}

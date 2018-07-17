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
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Join;
//import javax.persistence.criteria.JoinType;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
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
//public class CriteriaQueryTest {
//
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	EntityManager em;
//
//	@org.junit.Before
//	public void Before() {
//
//		logger.info("*******************");
//
//	}
//
//	@Test
//	public void all_courses() {
//		// "Select c From Course c"
//
//		// 1. Use Criteria Builder to create a Criteria Query returning the
//		// expected result object
//		//definir que tipo de objeto se va a retornar para la query
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
//
//		// 2. Define roots for tables which are involved in the query 
//		//Definir entidades con las que se estara trabajando(from tabla1, tabla2)
//		Root<Course> courseRoot = cq.from(Course.class);
//
//		// 3. Define Predicates etc using Criteria Builder
//		//Colocar Condiciones que vaya a tener la query
//
//		// 4. Add Predicates etc to the Criteria Query
//
//		// 5. Build the TypedQuery using the entity manager and criteria query
//		//Ejecutar la query
//		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
//
//		List<Course> resultList = query.getResultList();
//
//		logger.info("Typed Query -> {}", resultList);
//		// [Course[JPA in 50 Steps], Course[Spring in 50 Steps], Course[Spring
//		// Boot in 100 Steps]]
//	}
//
//	
//	@Test
//	public void all_courses_having_name_course() {
//		// "Select c From Course c where name like '%course' "
//
//		// 1. Use Criteria Builder to create a Criteria Query returning the
//		// expected result object
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
//
//		// 2. Define roots for tables which are involved in the query
//		Root<Course> courseRoot = cq.from(Course.class);
//
//		// 3. Define Predicates etc using Criteria Builder
//		Predicate likenamecourse = cb.like(courseRoot.get("name"), "%course%");
//
//		// 4. Add Predicates etc to the Criteria Query
//		cq.where(likenamecourse);
//
//		// 5. Build the TypedQuery using the entity manager and criteria query
//		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
//
//		List<Course> resultList = query.getResultList();
//
//		logger.info("Typed Query -> {}", resultList);
//		// [Course[Spring Boot in 100 Steps]]
//	}
//	
//	
//	@Test
//	public void all_courses_without_students() {
//		// "Select c From Course c where c.students is empty"
//
//		// 1. Use Criteria Builder to create a Criteria Query returning the
//		// expected result object
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
//
//		// 2. Define roots for tables which are involved in the query
//		Root<Course> courseRoot = cq.from(Course.class);
//
//		// 3. Define Predicates etc using Criteria Builder
//		Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));
//
//		// 4. Add Predicates etc to the Criteria Query
//		cq.where(studentsIsEmpty);
//
//		// 5. Build the TypedQuery using the entity manager and criteria query
//		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
//
//		List<Course> resultList = query.getResultList();
//
//		logger.info("Typed Query -> {}", resultList);
//		// [Course[Spring in 50 Steps]]
//	}
//	
//	
//	
//	@Test
//	public void join() {
//		// "Select c From Course c join c.students s"
//
//		// 1. Use Criteria Builder to create a Criteria Query returning the
//		// expected result object
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
//
//		// 2. Define roots for tables which are involved in the query
//		Root<Course> courseRoot = cq.from(Course.class);
//
//		// 3. Define Predicates etc using Criteria Builder
//		Join<Object, Object> join = courseRoot.join("students");
//
//		// 4. Add Predicates etc to the Criteria Query
//
//		// 5. Build the TypedQuery using the entity manager and criteria query
//		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
//
//		List<Course> resultList = query.getResultList();
//
//		logger.info("Typed Query -> {}", resultList);
//		// [Course[JPA in 50 Steps], Course[JPA in 50 Steps], Course[JPA in 50
//		// Steps], Course[Spring Boot in 100 Steps]]
//	}
//	
//	
//
//	@Test
//	public void left_join() {
//		// "Select c From Course c left join c.students s"
//
//		// 1. Use Criteria Builder to create a Criteria Query returning the
//		// expected result object
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
//
//		// 2. Define roots for tables which are involved in the query
//		Root<Course> courseRoot = cq.from(Course.class);
//
//		// 3. Define Predicates etc using Criteria Builder
//		Join<Object, Object> join = courseRoot.join("students", JoinType.LEFT);
//
//		// 4. Add Predicates etc to the Criteria Query
//
//		// 5. Build the TypedQuery using the entity manager and criteria query
//		TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));
//
//		List<Course> resultList = query.getResultList();
//
//		logger.info("Typed Query -> {}", resultList);
//		// [Course[JPA in 50 Steps], Course[JPA in 50 Steps], Course[JPA in 50
//		// Steps], Course[Spring in 50 Steps], Course[Spring Boot in 100 Steps]]
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//}

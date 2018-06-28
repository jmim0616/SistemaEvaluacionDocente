//package system.pack.helper;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
//
//import javax.persistence.EntityGraph;
//import javax.persistence.EntityManager;
//import javax.persistence.Subgraph;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Isolation;
//import org.springframework.transaction.annotation.Transactional;
//
//import hibernate_jpa_tutorial_beginners.jpa_hibernate.JpaHibernateApplication;
//import hibernate_jpa_tutorial_beginners.jpa_hibernate.entities.Course;
//import hibernate_jpa_tutorial_beginners.jpa_hibernate.entities.Review;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes=JpaHibernateApplication.class)
//public class PerformanceTuningTest {
//	
//	
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//	
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
//	
//	
//	@Test
//	@Transactional
//	public void creatingNPlusOneProblem() {
//		
//
//		List<Course> list_courses = entity_manager.createNamedQuery("query_get_all_courses", Course.class).getResultList();
//		
//		for (Course course : list_courses) {
//		
//			logger.info("Course -> {} Students -> {}", course, course.getStudents());
//			
//		}		
//
//	}
//
//	
//	@Test
//	@Transactional
//	public void solvingNPlusOneProblem_EntityGraph() {
//
//		EntityGraph<Course> createEntityGraph = entity_manager.createEntityGraph(Course.class);		
//		
//		Subgraph<Object> addSubgraph = createEntityGraph.addSubgraph("students");
//		
//		List<Course> list_courses = entity_manager.createNamedQuery("query_get_all_courses", Course.class)
//				.setHint("javax.persistence.loadgraph", createEntityGraph)
//				.getResultList();
//		
//		for (Course course : list_courses) {
//		
//			logger.info("Course -> {} Students -> {}", course, course.getStudents());
//			
//		}		
//
//	}
//	
//	
//	@Test
//	@Transactional
//	public void solvingNPlusOneProblem_JoinFetch() {
//		
//
//		List<Course> list_courses = entity_manager.createQuery("select c from Course c JOIN FETCH c.students s", Course.class).getResultList();
//		
//		for (Course course : list_courses) {
//		
//			logger.info("Course -> {} Students -> {}", course, course.getStudents() );
//			
//		}		
//
//	}
//	
//	
//	@Test
//	@Transactional
//	public void NPlusOneProblem_Join() {
//		
//
//		List<Course> list_courses = entity_manager.createNamedQuery("query_get_all_courses_join", Course.class).getResultList();
//		
//		for (Course course : list_courses) {
//		
//			logger.info("Course -> {} Students -> {}", course, course.getStudents() );
//			
//		}		
//
//	}
//	
//	
//}

package system.pack.helper;
//package system.pack.helper;
//
//import static org.junit.Assert.*;
//
//import javax.persistence.EntityManager;
//
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
//public class CourseRepositoryTest {
//	
//	
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//	
//	@Autowired
//	CourseRepository course_repository;
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
//	public void findById_basic() {
//		
//		logger.info("*******************findById_basic");
//		
//		Course course = course_repository.findByid(1001L);
//		
//		assertNotNull(course);
//		
//	}
//	
//	
//	@Test
//	@Transactional
//	public void findById_basic_firstLevelCacheDemo() {
//		
//
////		Course course1 = course_repository.findByid(1001L);
////		logger.info("First Course retrieve {}", course1);
//		
//		Course course1 = new Course(1001L,"asdasd");
//		course_repository.save(course1);
//		
//		entity_manager.flush();
//		
//		course1.setName("asdasd");
//		
//	
//		
////		Course course2= course_repository.findByid(1001L);
////		logger.info("First Course retrieve - 1 {}", course2);
//
//		
//		
//	}
//	
//	
//	
//	
//	@Test
//	@DirtiesContext //-> Spring resetea los datos despues correr este test en forma automatica
//	public void deleteById_basic() {
//		
//		logger.info("*******************deleteById_basic");
//		
//		Course course = course_repository.findByid(1001L);
//		
//		course_repository.deleById(1001L);;
//		
//		course.setisDeleted(true);
//		
//		logger.info("Course Deleted -> {}", course.getisDeleted());
//		
//		Course course_deleted = course_repository.findByid(1001L);
//		
//		assertNull(course_deleted);
//		
//	}
//	
//	
//	@Test
//	@DirtiesContext //-> Spring resetea los datos despues correr este test en forma automatica
//	public void save_basic() {
//		
//		logger.info("*******************save_basic");
//		
//		//get a course
//		Course course_find = course_repository.findByid(1002L);
//		//assert
//		//check course finded
//		assertNotNull(course_find);
//		
//		//update details course finded
//		course_find.setName("vlad2");
//		
//		//save course finded and updated
//		course_repository.save(course_find);
//		
//		logger.info("course -> {}", course_find);
//		
//		//assert
//		//check course updated
//		Course course_updated = course_repository.findByid(1001L);
//		assertEquals("vlad1-Update", course_updated.getName());
//		
//	}
//	
//
//
//
//	
//	@Test
//	@DirtiesContext 
//	@Transactional
//	public void retrieveReviewsForCourse() {
//		//get a course
//		Course course = course_repository.findByid(1001L);
//		logger.info("course -> {}", course);
//		logger.info("course.getReviews(); -> {}", course.getReviews());
//		
//		
//		
//	}
//	
//	
//	@Test
//	@DirtiesContext 
//	@Transactional(isolation=Isolation.READ_UNCOMMITTED)
//	public void retrieveCourseForReview() {
//		//get a course
//		Review review = entity_manager.find(Review.class,5001L);
//		logger.info("review -> {}", review);
//		//logger.info("review.getCourse(); -> {}", review.getCourse());
//		 
//	
//		
//	}
//	
//	
//}

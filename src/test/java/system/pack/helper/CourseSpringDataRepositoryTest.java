//package system.pack.helper;
//
//import static org.junit.Assert.*;
//
//import java.awt.print.Pageable;
//import java.util.Optional;
//
//import javax.persistence.EntityManager;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Repository;
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
//@SpringBootTest(classes = JpaHibernateApplication.class)
//public class CourseSpringDataRepositoryTest {
//
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	@Autowired
//	CourseSpringDataRepository course_spring_data_repository;
//
//	@Test
//	public void findById_CoursePresent() {
//
//		Optional<Course> courseOptional = course_spring_data_repository.findById(1001L);
//
//		assertTrue(courseOptional.isPresent());
//
//		logger.info("findById_CoursePresent -> {}", courseOptional.isPresent());
//
//	}
//
//	@Test
//	public void findById_CourseNotPresent() {
//
//		Optional<Course> courseOptional = course_spring_data_repository.findById(20001L);
//
//		assertFalse(courseOptional.isPresent());
//
//		logger.info(" findById_CourseNotPresent -> {}", courseOptional.isPresent());
//
//	}
//
//	@Test
//	public void playAroundWithSpringDataRepository() {
//
//		Course course = new Course("Course VLAD1");
//
//		course_spring_data_repository.save(course);
//
//		course.setName("Course VLAD1 - Updated");
//
//		course_spring_data_repository.save(course);
//
//		logger.info("Courses -> {}", course_spring_data_repository.findAll());
//
//		logger.info("Courses Count -> {}", course_spring_data_repository.count());
//
//	}
//
//	@Test
//	public void sort() {
//
//		Sort sort = new Sort(Sort.Direction.DESC, "id").and(new Sort(Sort.Direction.ASC, "name"));
//
//		logger.info("Sorted Courses -> {}", course_spring_data_repository.findAll(sort));
//		// Cursos sin ordenar por id en forma descendente
//		// Courses -> [Course [id=1001, name=course1], Course [id=1002,
//		// name=course2], Course [id=1003, name=course3]]
//
//	}
//
////	@Test
////	public void pagination() {
////		PageRequest pageRequest = PageRequest.of(0, 3);
////		Page<Course> firstPage = course_spring_data_repository.findAll(pageRequest);
////		logger.info("First Page -> {} ", firstPage.getContent());
////		
////		Pageable secondPageable = (Pageable) firstPage.nextPageable();
////		Page<Course> secondPage = course_spring_data_repository.findAll(secondPageable);
////		logger.info("Second Page -> {} ", secondPage.getContent());
////	}
//	
//	
//	
//	@Test
//	public void findUsingName() {
//
//		logger.info("findByName Courses -> {}", course_spring_data_repository.findByName("course1"));
//		
//	}
//	
//	
//	@Test
//	public void findUsingStudentsName() {
//		logger.info("findUsingStudentsName -> {} ", course_spring_data_repository.findByName("student1"));
//	}
//	
//	
//	
//	
//	
//	
//
//}

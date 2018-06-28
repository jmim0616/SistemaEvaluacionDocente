//package system.pack.helper;
//
//import static org.junit.Assert.*;
//
//import javax.persistence.EntityManager;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import hibernate_jpa_tutorial_beginners.jpa_hibernate.JpaHibernateApplication;
//import hibernate_jpa_tutorial_beginners.jpa_hibernate.entities.Address;
//import hibernate_jpa_tutorial_beginners.jpa_hibernate.entities.Course;
//import hibernate_jpa_tutorial_beginners.jpa_hibernate.entities.Passport;
//import hibernate_jpa_tutorial_beginners.jpa_hibernate.entities.Student;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes=JpaHibernateApplication.class)
//public class StudentRepositoryTest {
//	
//	
//	private Logger logger = LoggerFactory.getLogger(this.getClass());
//	
//	@Autowired
//	StudentRepository student_repository;
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
//	@Transactional
//	public void SomeTest() {
//		//DB operation 1 - retireve student
//		Student student = entity_manager.find(Student.class, 2001L);
//		//DB operation 2 - retireve passport
//		Passport passport = student.getPassport();
//		//DB operation 3 - update passport
//		passport.setNumber("A12345Updated");
//		//entity_manager.merge(passport);
//		//DB operation 4 - update student
//		student.setName("student1 - updated");
//		//entity_manager.merge(student);
//		
//		entity_manager.flush();
//		
//	}
//	
//	@Test
//	@Transactional
//	public void save_passport() {
//		Passport passport = new Passport("555");
//		
//		Student student = new Student("bla");
//		
//		student.setPassport(passport);
//
//		
//
//		
//	}
//
//	@Test
//	@Transactional
//	public void retrieveStudentAndPassportDetails() {
//		
//		Student student = entity_manager.find(Student.class, 2001L);
//		
//		logger.info("Student -> {}", student);
//		logger.info("Student - Passport -> {}", student.getPassport());
//		
//	}
//	
//	
//	@Test
//	@Transactional
//	public void setAddressDetailsForStudent() {
//		
//		Student student = entity_manager.find(Student.class, 2001L);
//		
//		student.setAddress(new Address("calle1", "calle2", "cali"));
//		
//		entity_manager.flush();
//		
//		logger.info("Student -> {}", student);
//		
//		
//	}
//	
//	@Test
//	@Transactional
//	public void retrievePassportAndAsociatedStudentDetails() {
//		
//		Passport passport = entity_manager.find(Passport.class, 4001L); 
//		
//		logger.info("passport -> {}", passport);
//		logger.info("Passport - Student -> {}", passport.getStudent());
//		
//	}
//	
//	
//	
//	@Test
//	@Transactional
//	public void retrieveStudentAndCourses() {
//		
//		Student student = entity_manager.find(Student.class, 2001L);
//		
//		logger.info("student -> {}", student);
//		logger.info("student.getCourses() -> {}", student.getCourses());
//				
//	}
//	
//	
//	@Test
//	@Transactional
//	public void retrieveCourseAndStudents() {
//		
//		Course course = entity_manager.find(Course.class, 1001L);
//		
//		logger.info("course -> {}", course);
//		logger.info("course.getStudents() -> {}", course.getStudents());
//				
//	}
//
//	
//
//
//
//	
//	
//}

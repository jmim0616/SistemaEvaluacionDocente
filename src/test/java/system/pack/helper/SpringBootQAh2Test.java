package system.pack.helper;
//package system.pack.helper;
//
//import java.util.List;
//import java.util.Optional;
//
//import javax.annotation.Resource;
//
//import org.aspectj.lang.annotation.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import hibernate_jpa_tutorial_beginners.jpa_hibernate.JpaHibernateApplication;
//import hibernate_jpa_tutorial_beginners.jpa_hibernate.entities.Course;
//
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = JpaHibernateApplication.class)
//public class SpringBootQAh2Test {
//  
//    @Autowired
//    private CourseSpringDataRepository course_spring_data_repository;
//    
//    private Logger logger = LoggerFactory.getLogger(this.getClass());
//	
//    @org.junit.Before
//    public void before(){
//    	
//    	System.out.println("***************");
//    	
//    }
//    
//    @Test
//    public void save() {
//    	
//        course_spring_data_repository.save(new Course(1L,"test00000"));
//        
//       Optional<Course> course = course_spring_data_repository.findById(1001L);
//        
//       List<Course> courses = course_spring_data_repository.findAll();
//  
//       logger.info("Course -> {}", course);
//       
//        logger.info("Courses -> {}", courses);
//        
//    }
//    
//    
//    
//    
//}
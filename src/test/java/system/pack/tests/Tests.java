package system.pack.tests;


import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import system.pack.configuration.QaApplicationContext;
import system.pack.daoInterface.TeacherDaoJpaRepository;
import system.pack.daoInterface.TeacherStatusDaoJpaRepository;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={QaApplicationContext.class})
@ActiveProfiles(value="QA")
@WebAppConfiguration 
public class Tests {

	@Autowired
	TeacherStatusDaoJpaRepository teacherStatusDaoJpaRepository;
	
	@Autowired
	TeacherDaoJpaRepository teachersDaoJpaRepository;



	
	@Test
	@DirtiesContext 
	@Transactional
	public void test1() {
		
		teacherStatusDaoJpaRepository.save(new TeacherStatusEntity(1));
		
		teachersDaoJpaRepository.save(new TeacherEntity(1, new TeacherStatusEntity(1), "vlad", "woz", 1, "asd", "qwe", "zxc", "1@gmail.com", "2@gmail.com", 1, 2, "100 años"));
		
		TeacherEntity teacher = teachersDaoJpaRepository.findByName("vlad");
		
//		Optional<TeacherEntity> teacher1 = teachersDaoJpaRepository.findById(1);

		System.out.println("00000 " + teacher);
		
	}
	
	
	

}

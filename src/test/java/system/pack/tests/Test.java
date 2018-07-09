package system.pack.tests;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import system.pack.configuration.QaApplicationContext;
import system.pack.daoInterface.TeacherDaoJpaRepository;
import system.pack.entity.TeacherEntity;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={QaApplicationContext.class})
@ActiveProfiles(value="QA")
public class Test {

	@Autowired
	TeacherDaoJpaRepository teachersDaoJpaRepository;


	
	@org.junit.Test
	public void test1() {
		
		TeacherEntity teacher = teachersDaoJpaRepository.findByName("vlad");
		
//		Optional<TeacherEntity> teacher1 = teachersDaoJpaRepository.findById(1);

		System.out.println("00000 " + teacher);
		
	}
	
	
	

}

package system.pack.integrationtest;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import system.pack.configuration.QaApplicationContext;
import system.pack.daoInterface.SubjectDaoInterface;
import system.pack.daoInterface.SubjectDaoJpaRepository;
import system.pack.daoInterface.SubjectStatusDaoInterface;
import system.pack.daoInterface.SubjectStatusDaoJpaRepository;
import system.pack.entity.TeacherStatusEntity;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { QaApplicationContext.class })
@ActiveProfiles(value = "QA")
@WebAppConfiguration
public class SubjectBoImplTest extends Mockito {

	@Autowired
	SubjectStatusDaoInterface subjectStatusDaoInterface;

	@Autowired
	SubjectStatusDaoJpaRepository subjectStatusDaoJpaRepository;
	
	@Autowired
	SubjectDaoInterface subjectDaoInterface;

	@Autowired
	SubjectDaoJpaRepository subjectDaoJpaRepository;
	

	
	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);
		
		

		
	}

	
	@After
	public void tearDown() {

	}
	
	
	@Test
	@DirtiesContext
	@Transactional
	public void testCreate() {
//		fail("Not yet implemented");
	
		System.out.println(subjectStatusDaoJpaRepository.findAll());
	
	}

	@Test
	@DirtiesContext
	@Transactional
	public void testUpdate() {
//		fail("Not yet implemented");
	}

	@Test
	@DirtiesContext
	@Transactional
	public void testUpdateStatus() {
//		fail("Not yet implemented");
	}

	@Test
	@DirtiesContext
	@Transactional
	public void testSearch() {
		
//		fail("Not yet implemented");
	
	}
	
	@Test
	@DirtiesContext
	@Transactional
	public void testGetAllDisciplinaryAreas() {
//		fail("Not yet implemented");
	}

	@Test
	@DirtiesContext
	@Transactional
	public void testGetAllAcademicPrograms() {
//		fail("Not yet implemented");
	}



}

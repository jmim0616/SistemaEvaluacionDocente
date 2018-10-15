package system.pack.integrationtest;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
import org.springframework.validation.BindingResult;

import system.pack.bointerface.TeacherBoInterface;
import system.pack.configuration.QaApplicationContext;
import system.pack.converter.TeacherConverter;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.daoInterface.TeacherDaoJpaRepository;
import system.pack.daoInterface.TeacherStatusDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoJpaRepository;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.vo.TeacherBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { QaApplicationContext.class })
@ActiveProfiles(value = "QA")
@WebAppConfiguration
public class TeacherBoImplTest extends Mockito {

	@Autowired
	TeacherBoInterface teacherBoInterface;

	@Autowired
	TeacherStatusDaoJpaRepository teacherStatusDaoJpaRepository;

	@Autowired
	TeacherStatusDaoInterface teacherStatusDaoInterface;
	
	@Autowired
	TeacherDaoInterface teacherDaoInterface;

	@Autowired
	TeacherDaoJpaRepository teacherDaoJpaRepository;


	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);

		teacherStatusDaoJpaRepository.save(new TeacherStatusEntity(1, "Activo"));
		teacherStatusDaoJpaRepository.save(new TeacherStatusEntity(2, "Inactivo"));
		
	}

	@After
	public void tearDown() {

	}

	@Test
	@DirtiesContext
	@Transactional
	public void testCreate() {

		// arrange

		TeacherBean teacherBean = new TeacherBean("12345", "", "Pedro", "Casas", "1", "Ingeniero de Sistemas",
				"Maestria en Ingenieria", "Doctorado en Ingenieria", "pedro.casas@uao.edu.co", "pedro_casas@gmailcom", "9999999999", "9999999",
				"20 años como auditor");
		
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);
		

		// act

		teacherBoInterface.create(teacherBean, bindingResult);

		// assert

		Assert.assertNotNull(teacherDaoInterface.findById(Integer.parseInt(teacherBean.getTeacherId())));

	}

	@Test
	@DirtiesContext
	@Transactional
	public void testNotCreate() {

		// arrange

		TeacherBean teacherBean = new TeacherBean("12345", "", "Pedro", "Casas", "1", "Ingeniero de Sistemas",
				"Maestria en Ingenieria", "", "pedro.casas@uao.edu.co", "pedro_casas@gmailcom", "9999999999", "9999999",
				"20 años como auditor");
		
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		
		// act

		teacherBoInterface.create(teacherBean, bindingResult);

		// assert

		Assert.assertNull(teacherDaoInterface.findById(Integer.parseInt(teacherBean.getTeacherId())));

	}

	@Test
	@DirtiesContext
	@Transactional
	public void testCreateExcel() {
		fail("Not yet implemented");
	}

	@Test
	@DirtiesContext
	@Transactional
	public void testUpdate() {

		// arrange

		TeacherBean teacherBeanInitial = new TeacherBean("12345", "1", "Pedro", "Casas", "1", "Ingeniero de Sistemas",
				"Maestria en Ingenieria", "Doctorado en Ingenieria", "pedro.casas@uao.edu.co", "pedro_casas@gmailcom", "9999999999", "9999999",
				"20 años como auditor");
		
		teacherDaoJpaRepository.save(TeacherConverter.ConvertToEntity(teacherBeanInitial));
		
		TeacherBean teacherBeanUpdated = new TeacherBean("12345", "1", "Pedro Alberto", "Casas Rojas", "2", "Ingeniero de Sistemas",
				"Maestria en Ingenieria", "Doctorado en Ingenieria", "pedro.casas@uao.edu.co", "pedro_casas@gmailcom", "9999999999", "9999999",
				"20 años como auditor");
		
		int teacherId = 12345;
		
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);
		
		// act

		teacherBoInterface.update(teacherBeanUpdated, bindingResult);

		// assert
		
		Assert.assertEquals(TeacherConverter.ConvertToEntity(teacherBeanUpdated).getName(), teacherDaoInterface.findById(teacherId).getName());
		Assert.assertEquals(TeacherConverter.ConvertToEntity(teacherBeanUpdated).getLastName(), teacherDaoInterface.findById(teacherId).getLastName());
		Assert.assertEquals(TeacherConverter.ConvertToEntity(teacherBeanUpdated).getIdentificationType(), teacherDaoInterface.findById(teacherId).getIdentificationType());

	}

	@Test
	@DirtiesContext
	@Transactional
	public void testNotUpdate() {

		// arrange

		TeacherBean teacherBeanInitial = new TeacherBean("12345", "1", "Pedro", "Casas", "1", "Ingeniero de Sistemas",
				"Maestria en Ingenieria", "", "pedro.casas@uao.edu.co", "pedro_casas@gmailcom", "9999999999", "9999999",
				"20 años como auditor");
		
		teacherDaoJpaRepository.save(TeacherConverter.ConvertToEntity(teacherBeanInitial));
		
		TeacherBean teacherBeanUpdated = new TeacherBean("12345", "1", "Pedro Alberto", "Casas Rojas", "2", "Ingeniero de Sistemas",
				"Maestria en Ingenieria", "", "pedro.casas@uao.edu.co", "pedro_casas@gmailcom", "9999999999", "9999999",
				"20 años como auditor");
		
		int teacherId = 12345;
		
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		
		// act

		teacherBoInterface.update(teacherBeanUpdated, bindingResult);

		// assert

		Assert.assertEquals(TeacherConverter.ConvertToEntity(teacherBeanInitial).getName(), teacherDaoInterface.findById(teacherId).getName());
		Assert.assertEquals(TeacherConverter.ConvertToEntity(teacherBeanInitial).getLastName(), teacherDaoInterface.findById(teacherId).getLastName());
		Assert.assertEquals(TeacherConverter.ConvertToEntity(teacherBeanInitial).getIdentificationType(), teacherDaoInterface.findById(teacherId).getIdentificationType());

	
	}

	
	@Test
	@DirtiesContext
	@Transactional
	public void testUpdateStatus() {
		
		// arrange

		TeacherBean teacherBeanInitial = new TeacherBean("12345", "1", "Pedro", "Casas", "1", "Ingeniero de Sistemas",
				"Maestria en Ingenieria", "", "pedro.casas@uao.edu.co", "pedro_casas@gmailcom", "9999999999", "9999999",
				"20 años como auditor");
		
		teacherDaoJpaRepository.save(TeacherConverter.ConvertToEntity(teacherBeanInitial));
		
		TeacherBean teacherBeanStatusUpdated = new TeacherBean();
		teacherBeanStatusUpdated.setTeacherId("12345");
		teacherBeanStatusUpdated.setTeacherStatus("Activo");
		
		BindingResult bindingResult = null;
		
		// act
		
		teacherBoInterface.updateStatus(teacherBeanStatusUpdated, bindingResult);

		// assert


		Assert.assertEquals(2, teacherDaoJpaRepository.findById(Integer.parseInt(teacherBeanStatusUpdated.getTeacherId())).get().getTeacherStatus().getTeacherStatusId());

			
	}

	
	@Test
	@DirtiesContext
	@Transactional
	public void testSearch() {
		
		// arrange

		TeacherBean teacherBeanInitial = new TeacherBean("12345", "1", "Pedro", "Casas", "1", "Ingeniero de Sistemas",
				"Maestria en Ingenieria", "", "pedro.casas@uao.edu.co", "pedro_casas@gmailcom", "9999999999", "9999999",
				"20 años como auditor");
		
		teacherDaoJpaRepository.save(TeacherConverter.ConvertToEntity(teacherBeanInitial));

		TeacherBean teacherBeanSearch = new TeacherBean();
		teacherBeanSearch.setTeacherId("12345");
		
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);
		

		// act

		teacherBoInterface.search(teacherBeanSearch, bindingResult);

		// assert
		
		Assert.assertNotNull(teacherDaoInterface.findById(Integer.parseInt(teacherBeanSearch.getTeacherId())));
		
	}
	
	@Test
	@DirtiesContext
	@Transactional
	public void testNotSearch() {
		
		// arrange

		TeacherBean teacherBeanInitial = new TeacherBean("12345", "1", "Pedro", "Casas", "1", "Ingeniero de Sistemas",
				"Maestria en Ingenieria", "", "pedro.casas@uao.edu.co", "pedro_casas@gmailcom", "9999999999", "9999999",
				"20 años como auditor");
		
		teacherDaoJpaRepository.save(TeacherConverter.ConvertToEntity(teacherBeanInitial));

		TeacherBean teacherBeanSearch = new TeacherBean();
		teacherBeanSearch.setTeacherId("67890");
		
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);
		

		// act

		teacherBoInterface.search(teacherBeanSearch, bindingResult);

		// assert
		
		Assert.assertNull(teacherDaoInterface.findById(Integer.parseInt(teacherBeanSearch.getTeacherId())));
		
	}


}

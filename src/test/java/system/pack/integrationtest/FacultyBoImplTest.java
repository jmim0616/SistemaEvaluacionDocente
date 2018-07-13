package system.pack.integrationtest;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Assert;
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
import org.springframework.validation.BindingResult;

import system.pack.bointerface.DepartmentBoInterface;
import system.pack.bointerface.FacultyBoInterface;
import system.pack.configuration.QaApplicationContext;
import system.pack.converter.DepartmentConverter;
import system.pack.converter.FacultyConverter;
import system.pack.daoInterface.DepartmentDaoInterface;
import system.pack.daoInterface.DepartmentDaoJpaRepository;
import system.pack.daoInterface.FacultyDaoInterface;
import system.pack.daoInterface.FacultyDaoJpaRepository;
import system.pack.entity.DepartmentEntity;
import system.pack.vo.DepartmentBean;
import system.pack.vo.FacultyBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { QaApplicationContext.class })
@ActiveProfiles(value = "QA")
@WebAppConfiguration
public class FacultyBoImplTest extends Mockito{

	
	@Autowired
	FacultyBoInterface facultyBoInterface;

	@Autowired
	DepartmentDaoInterface departmentDaoInterface;

	@Autowired
	DepartmentDaoJpaRepository departmentDaoJpaRepository;
	
	@Autowired
	FacultyDaoInterface facultyDaoInterface;

	@Autowired
	FacultyDaoJpaRepository facultyDaoJpaRepository;

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);

		DepartmentBean departmentBeanInitial1 = new DepartmentBean();
		departmentBeanInitial1.setName("Operaciones y sistemas");

		departmentDaoJpaRepository.save(DepartmentConverter.ConvertToEntity1(departmentBeanInitial1));
		
		
	}

	@After
	public void tearDown() {

	}
	

	@Test
	@DirtiesContext
	@Transactional
	public void testCreate() {
		
		// arrange

		FacultyBean facultyBean = new FacultyBean();
		facultyBean.setName("Ingenieria");
		
		int departmentId = departmentDaoJpaRepository.findByName("Operaciones y sistemas").getDepartmentId();
		facultyBean.setDepartment(String.valueOf(departmentId));
		

		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);

		// act

		facultyBoInterface.create(facultyBean, bindingResult);

		// assert

		Assert.assertNotNull(facultyDaoInterface.findByName(facultyBean.getName()));
		
	}
	
	
	@Test
	@DirtiesContext
	@Transactional
	public void testNotCreate() {
		
		// arrange

		FacultyBean facultyBean = new FacultyBean();
		facultyBean.setName("Ingenieria");
		
		int departmentId = departmentDaoJpaRepository.findByName("Operaciones y sistemas").getDepartmentId();

		facultyBean.setDepartment(String.valueOf(departmentId));
		

		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);

		try {

			// act

			facultyBoInterface.create(facultyBean, bindingResult);

			// assert

			facultyDaoInterface.findByName(facultyBean.getName());
			fail();

		} catch (Exception e) {

			System.out.println("Mensaje " + e.getMessage());

		}
		
	}
	

	@Test
	@DirtiesContext
	@Transactional
	public void testUpdate() {
		
		// arrange

		FacultyBean facultyBeanInitial = new FacultyBean();
		facultyBeanInitial.setName("Ingenieria");
		
		DepartmentEntity department = departmentDaoJpaRepository.findByName("Operaciones y sistemas");
		facultyBeanInitial.setDepartment(String.valueOf(department.getDepartmentId()));
		
		
		facultyDaoJpaRepository.save(FacultyConverter.ConvertToEntity1(facultyBeanInitial));

		int facultyId = facultyDaoJpaRepository.findByName("Ingenieria").getFacultyId();

		FacultyBean facultyBeanUpdated = new FacultyBean(String.valueOf(facultyId), String.valueOf(department.getName()), "Administracion");

		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);

		// act

		facultyBoInterface.update(facultyBeanUpdated, bindingResult);

		// assert

		Assert.assertEquals(facultyBeanUpdated.getName(),
				facultyDaoJpaRepository.findById(facultyId).getName());
		
	}
	
	
	@Test
	@DirtiesContext
	@Transactional
	public void testNotUpdate() {
		
		// arrange

		FacultyBean facultyBeanInitial = new FacultyBean();
		facultyBeanInitial.setName("Ingenieria");
		
		DepartmentEntity department = departmentDaoJpaRepository.findByName("Operaciones y sistemas");
		facultyBeanInitial.setDepartment(String.valueOf(department.getDepartmentId()));
		
		
		facultyDaoJpaRepository.save(FacultyConverter.ConvertToEntity1(facultyBeanInitial));

		int facultyId = facultyDaoJpaRepository.findByName("Ingenieria").getFacultyId();

		FacultyBean facultyBeanUpdated = new FacultyBean(String.valueOf(facultyId), String.valueOf(department.getName()), "Administracion");

		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);

		// act

		facultyBoInterface.update(facultyBeanUpdated, bindingResult);

		// assert

		Assert.assertEquals(facultyBeanInitial.getName(), facultyDaoJpaRepository.findById(facultyId).getName());
		
	}
	

	@Test
	@DirtiesContext
	@Transactional
	public void testSearch() {
		
		// arrange

		FacultyBean facultyBeanInitial = new FacultyBean();
		facultyBeanInitial.setName("Ingenieria");
		
		DepartmentEntity department = departmentDaoJpaRepository.findByName("Operaciones y sistemas");
		facultyBeanInitial.setDepartment(String.valueOf(department.getDepartmentId()));
		
		
		facultyDaoJpaRepository.save(FacultyConverter.ConvertToEntity1(facultyBeanInitial));

		// act

		facultyBoInterface.search();

		// assert

		Assert.assertTrue(facultyDaoInterface.getAll().size() > 0);
		
	}
	
	
	@Test
	@DirtiesContext
	@Transactional
	public void testNotSearch() {
		
		// arrange

		
		// act

		facultyBoInterface.search();

		// assert

		Assert.assertTrue(facultyDaoInterface.getAll().size() < 1);
		
	}
	

}

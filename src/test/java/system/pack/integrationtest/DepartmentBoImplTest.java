package system.pack.integrationtest;

import static org.junit.Assert.*;

import java.util.List;

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
import system.pack.configuration.QaApplicationContext;
import system.pack.converter.DepartmentConverter;
import system.pack.converter.TeacherConverter;
import system.pack.daoInterface.DepartmentDaoInterface;
import system.pack.daoInterface.DepartmentDaoJpaRepository;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.vo.DepartmentBean;
import system.pack.vo.TeacherBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { QaApplicationContext.class })
@ActiveProfiles(value = "QA")
@WebAppConfiguration
public class DepartmentBoImplTest extends Mockito {

	@Autowired
	DepartmentBoInterface departmentBoInterface;

	@Autowired
	DepartmentDaoInterface departmentDaoInterface;

	@Autowired
	DepartmentDaoJpaRepository departmentDaoJpaRepository;

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

		// arrange

		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setName("Operaciones y sistemas");

		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);

		// act

		departmentBoInterface.create(departmentBean, bindingResult);

		// assert

		Assert.assertNotNull(departmentDaoInterface.findByName(departmentBean.getName()));

	}

	@Test
	@DirtiesContext
	@Transactional
	public void testNotCreate() {

		// arrange

		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setName("Operaciones y sistemas");

		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);

		try {

			// act

			departmentBoInterface.create(departmentBean, bindingResult);

			// assert

			departmentDaoInterface.findByName(departmentBean.getName());
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

		DepartmentBean departmentBeanInitial = new DepartmentBean();
		departmentBeanInitial.setName("Operaciones y sistemas");

		departmentDaoJpaRepository.save(DepartmentConverter.ConvertToEntity1(departmentBeanInitial));

		int departmentId = departmentDaoJpaRepository.findByName("Operaciones y sistemas").getDepartmentId();

		DepartmentBean departmentBeanUpdated = new DepartmentBean(String.valueOf(departmentId), "Innovación en Ingenieria");

		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);

		// act

		departmentBoInterface.update(departmentBeanUpdated, bindingResult);

		// assert

		Assert.assertEquals(departmentBeanUpdated.getName(),
				departmentDaoJpaRepository.findById(departmentId).getName());

	}
	
	@Test
	@DirtiesContext
	@Transactional
	public void testNotUpdate() {

		// arrange

		DepartmentBean departmentBeanInitial = new DepartmentBean();
		departmentBeanInitial.setName("Operaciones y sistemas");

		departmentDaoJpaRepository.save(DepartmentConverter.ConvertToEntity1(departmentBeanInitial));

		int departmentId = departmentDaoJpaRepository.findByName("Operaciones y sistemas").getDepartmentId();
		
		DepartmentBean departmentBeanUpdated = new DepartmentBean(String.valueOf(departmentId), "Innovación en Ingenieria");

		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);

		// act

		departmentBoInterface.update(departmentBeanUpdated, bindingResult);

		// assert

		Assert.assertEquals(departmentBeanInitial.getName(), departmentDaoJpaRepository.findById(departmentId).getName());

	}

	@Test
	@DirtiesContext
	@Transactional
	public void testSearch() {
		
		// arrange

		DepartmentBean departmentBeanInitial = new DepartmentBean();
		departmentBeanInitial.setName("Operaciones y sistemas");

		departmentDaoJpaRepository.save(DepartmentConverter.ConvertToEntity1(departmentBeanInitial));

		// act

		departmentBoInterface.search();

		// assert

		Assert.assertTrue(departmentDaoInterface.getAll().size() > 0);
	}
	
	@Test
	@DirtiesContext
	@Transactional
	public void testNotSearch() {
		
		// arrange


		// act

		departmentBoInterface.search();

		// assert

		Assert.assertTrue(departmentDaoInterface.getAll().size() < 1);
	}
	

}

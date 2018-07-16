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

import system.pack.bointerface.AcademicProgramBoInterface;
import system.pack.bointerface.DisciplinaryAreaBoInterface;
import system.pack.configuration.QaApplicationContext;
import system.pack.converter.AcademicProgramConverter;
import system.pack.converter.DepartmentConverter;
import system.pack.converter.DisciplinaryAreaConverter;
import system.pack.converter.FacultyConverter;
import system.pack.daoInterface.AcademicProgramDaoInterface;
import system.pack.daoInterface.AcademicProgramDaoJpaRepository;
import system.pack.daoInterface.DepartmentDaoInterface;
import system.pack.daoInterface.DepartmentDaoJpaRepository;
import system.pack.daoInterface.DisciplinaryAreaDaoInterface;
import system.pack.daoInterface.DisciplinaryAreaDaoJpaRepository;
import system.pack.daoInterface.FacultyDaoInterface;
import system.pack.daoInterface.FacultyDaoJpaRepository;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.vo.AcademicProgramBean;
import system.pack.vo.DepartmentBean;
import system.pack.vo.DisciplinaryAreaBean;
import system.pack.vo.FacultyBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { QaApplicationContext.class })
@ActiveProfiles(value = "QA")
@WebAppConfiguration
public class DisciplinaryAreaBoImplTest extends Mockito {

	@Autowired
	DisciplinaryAreaBoInterface disciplinaryAreaBoInterface;
	
	@Autowired
	FacultyDaoInterface facultyDaoInterface;

	@Autowired
	FacultyDaoJpaRepository facultyDaoJpaRepository;

	@Autowired
	DepartmentDaoInterface departmentDaoInterface;

	@Autowired
	DepartmentDaoJpaRepository departmentDaoJpaRepository;

	@Autowired
	DisciplinaryAreaDaoInterface disciplinaryAreaDaoInterface;

	@Autowired
	DisciplinaryAreaDaoJpaRepository disciplinaryAreaDaoJpaRepository;

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);

		FacultyBean facultyBeanInitial = new FacultyBean();
		facultyBeanInitial.setName("Ingenieria");
		
		facultyDaoJpaRepository.save(FacultyConverter.ConvertToEntity1(facultyBeanInitial));

		DepartmentBean departmentBeanInitial = new DepartmentBean();
		departmentBeanInitial.setName("Operaciones y sistemas");
		
		FacultyEntity facultyEntity = facultyDaoJpaRepository.findByName("Ingenieria");
		departmentBeanInitial.setFaculty(String.valueOf(facultyEntity.getFacultyId()));

		departmentDaoJpaRepository.save(DepartmentConverter.ConvertToEntity1(departmentBeanInitial));

		

	}

	@After
	public void tearDown() {

	}

	@Test
	@DirtiesContext
	@Transactional
	public void testCreate() {

		// arrange

		DisciplinaryAreaBean disciplinaryAreaBean = new DisciplinaryAreaBean();
		disciplinaryAreaBean.setName("Area Discipolinaria Uno");

		DepartmentEntity departmentEntity = departmentDaoJpaRepository.findByName("Operaciones y sistemas");
		disciplinaryAreaBean.setDepartment(String.valueOf(departmentEntity.getDepartmentId()));

		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);

		// act

		disciplinaryAreaBoInterface.create(disciplinaryAreaBean, bindingResult);

		// assert

		Assert.assertNotNull(disciplinaryAreaDaoInterface.findByName(disciplinaryAreaBean.getName()));

	}

	@Test
	@DirtiesContext
	@Transactional
	public void testNotCreate() {

		// arrange

		DisciplinaryAreaBean disciplinaryAreaBean = new DisciplinaryAreaBean();
		disciplinaryAreaBean.setName("Area Discipolinaria Uno");

		DepartmentEntity departmentEntity = departmentDaoJpaRepository.findByName("Operaciones y sistemas");
		disciplinaryAreaBean.setDepartment(String.valueOf(departmentEntity.getDepartmentId()));

		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);

		try {

			// act

			disciplinaryAreaBoInterface.create(disciplinaryAreaBean, bindingResult);

			// assert

			disciplinaryAreaDaoInterface.findByName(disciplinaryAreaBean.getName());
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

		DisciplinaryAreaBean disciplinaryAreaInitial = new DisciplinaryAreaBean();
		disciplinaryAreaInitial.setName("Area Discipolinaria Uno");

		DepartmentEntity departmentEntity = departmentDaoJpaRepository.findByName("Operaciones y sistemas");
		disciplinaryAreaInitial.setDepartment(String.valueOf(departmentEntity.getDepartmentId()));

		disciplinaryAreaDaoJpaRepository.save(DisciplinaryAreaConverter.ConvertToEntity1(disciplinaryAreaInitial));

		int disciplinaryAreaId = disciplinaryAreaDaoJpaRepository.findByName("Area Discipolinaria Uno")
				.getDisciplinaryAreaId();

		DisciplinaryAreaBean disciplinaryAreaUpdated = new DisciplinaryAreaBean(String.valueOf(disciplinaryAreaId),
				String.valueOf(departmentEntity.getName()), "Area Discipolinaria Dos");

		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);

		// act

		disciplinaryAreaBoInterface.update(disciplinaryAreaUpdated, bindingResult);

		// assert

		Assert.assertEquals(disciplinaryAreaUpdated.getName(),
				disciplinaryAreaDaoJpaRepository.findById(disciplinaryAreaId).getName());

	}

	@Test
	@DirtiesContext
	@Transactional
	public void testNotUpdate() {

		// arrange

		DisciplinaryAreaBean disciplinaryAreaInitial = new DisciplinaryAreaBean();
		disciplinaryAreaInitial.setName("Area Discipolinaria Uno");

		DepartmentEntity departmentEntity = departmentDaoJpaRepository.findByName("Operaciones y sistemas");
		disciplinaryAreaInitial.setDepartment(String.valueOf(departmentEntity.getDepartmentId()));

		disciplinaryAreaDaoJpaRepository.save(DisciplinaryAreaConverter.ConvertToEntity1(disciplinaryAreaInitial));

		int disciplinaryAreaId = disciplinaryAreaDaoJpaRepository.findByName("Area Discipolinaria Uno")
				.getDisciplinaryAreaId();

		DisciplinaryAreaBean disciplinaryAreaUpdated = new DisciplinaryAreaBean(String.valueOf(disciplinaryAreaId),
				String.valueOf(departmentEntity.getName()), "Area Discipolinaria Dos");

		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);

		// act

		disciplinaryAreaBoInterface.update(disciplinaryAreaUpdated, bindingResult);

		// assert

		Assert.assertEquals(disciplinaryAreaInitial.getName(),
				disciplinaryAreaDaoJpaRepository.findById(disciplinaryAreaId).getName());

	}

	@Test
	@DirtiesContext
	@Transactional
	public void testSearch() {

		// arrange

		DisciplinaryAreaBean disciplinaryAreaInitial = new DisciplinaryAreaBean();
		disciplinaryAreaInitial.setName("Area Discipolinaria Uno");

		DepartmentEntity departmentEntity = departmentDaoJpaRepository.findByName("Operaciones y sistemas");
		disciplinaryAreaInitial.setDepartment(String.valueOf(departmentEntity.getDepartmentId()));

		disciplinaryAreaDaoJpaRepository.save(DisciplinaryAreaConverter.ConvertToEntity1(disciplinaryAreaInitial));

		// act

		disciplinaryAreaBoInterface.search();

		// assert

		Assert.assertTrue(disciplinaryAreaDaoInterface.getAll().size() > 0);

	}

	
	 @Test
	 @DirtiesContext
	 @Transactional
	 public void testNotSearch() {
	
	 // arrange
	
	
	
	 // act
	
	 disciplinaryAreaBoInterface.search();
	
	 // assert
	
	 Assert.assertTrue(disciplinaryAreaDaoInterface.getAll().size() < 1);
	
	 }

}

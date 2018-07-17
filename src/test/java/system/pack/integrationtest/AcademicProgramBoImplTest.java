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
import system.pack.bointerface.FacultyBoInterface;
import system.pack.configuration.QaApplicationContext;
import system.pack.converter.AcademicProgramConverter;
import system.pack.converter.DepartmentConverter;
import system.pack.converter.FacultyConverter;
import system.pack.daoInterface.AcademicProgramDaoInterface;
import system.pack.daoInterface.AcademicProgramDaoJpaRepository;
import system.pack.daoInterface.DepartmentDaoInterface;
import system.pack.daoInterface.DepartmentDaoJpaRepository;
import system.pack.daoInterface.FacultyDaoInterface;
import system.pack.daoInterface.FacultyDaoJpaRepository;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.vo.AcademicProgramBean;
import system.pack.vo.DepartmentBean;
import system.pack.vo.FacultyBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { QaApplicationContext.class })
@ActiveProfiles(value = "QA")
@WebAppConfiguration
public class AcademicProgramBoImplTest extends Mockito {

	@Autowired
	AcademicProgramBoInterface academicProgramBoInterface;

	@Autowired
	DepartmentDaoInterface departmentDaoInterface;

	@Autowired
	DepartmentDaoJpaRepository departmentDaoJpaRepository;

	@Autowired
	FacultyDaoInterface facultyDaoInterface;

	@Autowired
	FacultyDaoJpaRepository facultyDaoJpaRepository;

	@Autowired
	AcademicProgramDaoInterface academicProgramDaoInterface;

	@Autowired
	AcademicProgramDaoJpaRepository academicProgramDaoJpaRepository;

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

		AcademicProgramBean academicProgramBean = new AcademicProgramBean();
		academicProgramBean.setName("Ingenieria Informatica");

		int facultyId = facultyDaoJpaRepository.findByName("Ingenieria").getFacultyId();
		academicProgramBean.setFaculty(String.valueOf(facultyId));

		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);

		// act

		academicProgramBoInterface.create(academicProgramBean, bindingResult);

		// assert

		Assert.assertNotNull(academicProgramDaoInterface.findByName(academicProgramBean.getName()));

	}

	@Test
	@DirtiesContext
	@Transactional
	public void testNotCreate() {

		// arrange

		AcademicProgramBean academicProgramBean = new AcademicProgramBean();
		academicProgramBean.setName("Ingenieria Informatica");

		int facultyId = facultyDaoJpaRepository.findByName("Ingenieria").getFacultyId();
		academicProgramBean.setFaculty(String.valueOf(facultyId));

		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);

		try {

			// act

			academicProgramBoInterface.create(academicProgramBean, bindingResult);

			// assert

			academicProgramDaoInterface.findByName(academicProgramBean.getName());
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

		AcademicProgramBean academicProgramBeanInitial = new AcademicProgramBean();
		academicProgramBeanInitial.setName("Ingenieria Informatica");

		FacultyEntity facultyEntity = facultyDaoJpaRepository.findByName("Ingenieria");
		academicProgramBeanInitial.setFaculty(String.valueOf(facultyEntity.getFacultyId()));

		academicProgramDaoJpaRepository.save(AcademicProgramConverter.ConvertToEntity1(academicProgramBeanInitial));

		int academicProgramId = academicProgramDaoJpaRepository.findByName("Ingenieria Informatica").getAcademicProgramId();

		AcademicProgramBean academicProgramUpdated = new AcademicProgramBean(String.valueOf(academicProgramId),
				String.valueOf(facultyEntity.getName()), "Ingenieria Multimedia");

		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);

		// act

		academicProgramBoInterface.update(academicProgramUpdated, bindingResult);

		// assert

		Assert.assertEquals(academicProgramUpdated.getName(), academicProgramDaoJpaRepository.findById(academicProgramId).getName());

	}
	
	@Test
	@DirtiesContext
	@Transactional
	public void testNotUpdate() {

		// arrange

		AcademicProgramBean academicProgramBeanInitial = new AcademicProgramBean();
		academicProgramBeanInitial.setName("Ingenieria Informatica");

		FacultyEntity facultyEntity = facultyDaoJpaRepository.findByName("Ingenieria");
		academicProgramBeanInitial.setFaculty(String.valueOf(facultyEntity.getFacultyId()));

		academicProgramDaoJpaRepository.save(AcademicProgramConverter.ConvertToEntity1(academicProgramBeanInitial));

		int academicProgramId = academicProgramDaoJpaRepository.findByName("Ingenieria Informatica").getAcademicProgramId();

		AcademicProgramBean academicProgramUpdated = new AcademicProgramBean(String.valueOf(academicProgramId),
				String.valueOf(facultyEntity.getName()), "Ingenieria Multimedia");

		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);

		// act

		academicProgramBoInterface.update(academicProgramUpdated, bindingResult);

		// assert

		Assert.assertEquals(academicProgramBeanInitial.getName(), academicProgramDaoJpaRepository.findById(academicProgramId).getName());

	}

	
	@Test
	@DirtiesContext
	@Transactional
	public void testSearch() {
		
		// arrange

		AcademicProgramBean academicProgramBeanInitial = new AcademicProgramBean();
		academicProgramBeanInitial.setName("Ingenieria Informatica");

		FacultyEntity facultyEntity = facultyDaoJpaRepository.findByName("Ingenieria");
		academicProgramBeanInitial.setFaculty(String.valueOf(facultyEntity.getFacultyId()));

		academicProgramDaoJpaRepository.save(AcademicProgramConverter.ConvertToEntity1(academicProgramBeanInitial));

		// act

		academicProgramBoInterface.search();

		// assert

		Assert.assertTrue(academicProgramDaoInterface.getAll().size() > 0);
		
	}
	
	
	@Test
	@DirtiesContext
	@Transactional
	public void testNotSearch() {
		
		// arrange


		
		// act

		academicProgramBoInterface.search();

		// assert

		Assert.assertTrue(academicProgramDaoInterface.getAll().size() < 1);
		
	}

}

package system.pack.boImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import system.pack.bointerface.AcademicProgramBoInterface;
import system.pack.bointerface.DepartmentBoInterface;
import system.pack.bointerface.FacultyBoInterface;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.converter.AcademicProgramConverter;
import system.pack.converter.FacultyConverter;
import system.pack.daoInterface.AcademicProgramDaoInterface;
import system.pack.daoInterface.AcademicProgramDaoJpaRepository;
import system.pack.daoInterface.DepartmentDaoInterface;
import system.pack.daoInterface.DepartmentDaoJpaRepository;
import system.pack.daoInterface.FacultyDaoInterface;
import system.pack.daoInterface.FacultyDaoJpaRepository;
import system.pack.daoInterface.SubjectByProgramDaoInterface;
import system.pack.daoInterface.SubjectByProgramDaoJpaRepository;
import system.pack.daoInterface.SubjectByTeacherDaoInterface;
import system.pack.daoInterface.SubjectByTeacherDaoJpaRepository;
import system.pack.daoInterface.TeacherStatusDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoJpaRepository;
import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.AcademicProgramBean;
import system.pack.vo.DepartmentBean;
import system.pack.vo.FacultyBean;
import system.pack.vo.SubjectByProgramBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;

@Service
public class AcademicProgramBoImpl implements AcademicProgramBoInterface {

	@Autowired
	FacultyDaoJpaRepository facultyDaoJpaRepository;

	@Autowired
	FacultyDaoInterface facultyDaoInterface;
	
	@Autowired
	AcademicProgramDaoInterface academicProgramDaoInterface;
	
	@Autowired
	AcademicProgramDaoJpaRepository academicProgramDaoJpaRepository;
	

	
	
	@Transactional
	@Override
	public JsonResponse<FacultyBean, FacultyEntity> getAllFaculties() {
		
		JsonResponse<FacultyBean, FacultyEntity> jsonResponse = new JsonResponse<FacultyBean, FacultyEntity>();
		
		List<FacultyEntity> faculties = facultyDaoInterface.getAll();
		
		jsonResponse.setObjectEntityList(faculties);
		
		return jsonResponse;
		
	}
	
	
	@Transactional
	@Override
	public JsonResponse<AcademicProgramBean, AcademicProgramEntity> create(AcademicProgramBean academicProgramBean, BindingResult bindingResult) {
		try {

			JsonResponse<AcademicProgramBean, AcademicProgramEntity> jsonResponse = new JsonResponse<AcademicProgramBean, AcademicProgramEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				AcademicProgramEntity academicProgramEntity = AcademicProgramConverter.ConvertToEntity1(academicProgramBean);

				academicProgramDaoInterface.create(academicProgramEntity);

				jsonResponse.setIsValid(true);

				jsonResponse.setSuccessMessage("El programa academico ha sido guardado con exito");

			}

			return jsonResponse;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

//			throw new RuntimeException("");

			return null;
			
		}
	}

	@Transactional
	@Override
	public JsonResponse<AcademicProgramBean, AcademicProgramEntity> update(AcademicProgramBean academicProgramBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<AcademicProgramBean, AcademicProgramEntity> jsonResponse = new JsonResponse<AcademicProgramBean, AcademicProgramEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {
				
				FacultyEntity facultyEntity = facultyDaoInterface.findByName(academicProgramBean.getFaculty());

				academicProgramBean.setFaculty(Integer.toString(facultyEntity.getFacultyId()));
				
				AcademicProgramEntity academicProgramEntity = AcademicProgramConverter.ConvertToEntity2(academicProgramBean);

				academicProgramDaoInterface.update(academicProgramEntity);

				jsonResponse.setIsValid(true);

				jsonResponse.setSuccessMessage("El programa academico ha sido modificado con exito");

			}

			return jsonResponse;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

//			throw new RuntimeException("");

			return null;
			
		}
	}


	@Transactional
	@Override
	public JsonResponse<AcademicProgramBean, AcademicProgramEntity> search() {
		
		try {

			JsonResponse<AcademicProgramBean, AcademicProgramEntity> jsonResponse = new JsonResponse<AcademicProgramBean, AcademicProgramEntity>();
				
				List<AcademicProgramEntity> academicPrograms = academicProgramDaoInterface.getAll();
				
				if (academicPrograms.size() < 1) {
					
					jsonResponse.setErrorMessage("No se encontraron resultados para la busqueda");
					
				} else {
					
					jsonResponse.setObjectEntityList(academicPrograms);
					
				}

			return jsonResponse;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

//			throw new RuntimeException("");

			return null;
			
		}
	}
	

	
}

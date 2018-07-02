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
import system.pack.bointerface.DisciplinaryAreaBoInterface;
import system.pack.bointerface.FacultyBoInterface;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.converter.AcademicProgramConverter;
import system.pack.converter.DisciplinaryAreaConverter;
import system.pack.daoInterface.DepartmentDaoInterface;
import system.pack.daoInterface.DepartmentDaoJpaRepository;
import system.pack.daoInterface.DisciplinaryAreaDaoInterface;
import system.pack.daoInterface.FacultyDaoInterface;
import system.pack.daoInterface.FacultyDaoJpaRepository;
import system.pack.daoInterface.TeacherStatusDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoJpaRepository;
import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.DisciplinaryAreaEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.AcademicProgramBean;
import system.pack.vo.DepartmentBean;
import system.pack.vo.DisciplinaryAreaBean;
import system.pack.vo.FacultyBean;
import system.pack.vo.TeacherBean;

@Service
public class DisciplinaryAreaBoImpl implements DisciplinaryAreaBoInterface {

	@Autowired
	DisciplinaryAreaDaoInterface disciplinaryAreaDaoInterface;

	@Autowired
	FacultyDaoJpaRepository facultyDaoJpaRepository;

	@Autowired
	FacultyDaoInterface facultyDaoInterface;
	
	
	@Transactional
	@Override
	public JsonResponse<FacultyBean, FacultyEntity> getFaculty() {
		
		JsonResponse<FacultyBean, FacultyEntity> jsonResponse = new JsonResponse<FacultyBean, FacultyEntity>();
		
		List<FacultyEntity> faculties = facultyDaoInterface.getAll();
		
		jsonResponse.setObjectEntityList(faculties);
		
		return jsonResponse;
		
	}
	
	
	@Transactional
	@Override
	public JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity> create(DisciplinaryAreaBean disciplinaryAreaBean, BindingResult bindingResult) {
		try {

			JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity> jsonResponse = new JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				DisciplinaryAreaEntity disciplinaryAreaEntity = DisciplinaryAreaConverter.ConvertToEntity1(disciplinaryAreaBean);

				disciplinaryAreaDaoInterface.create(disciplinaryAreaEntity);

				jsonResponse.setIsValid(true);

				jsonResponse.setSuccessMessage("El area disciplinaria ha sido guardada con exito");

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
	public JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity> update(DisciplinaryAreaBean disciplinaryAreaBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity> jsonResponse = new JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {
				
				FacultyEntity facultyEntity = facultyDaoInterface.findByName(disciplinaryAreaBean.getFaculty());

				disciplinaryAreaBean.setFaculty(Integer.toString(facultyEntity.getFacultyId()));
				
				DisciplinaryAreaEntity disciplinaryAreaEntity = DisciplinaryAreaConverter.ConvertToEntity2(disciplinaryAreaBean);

				disciplinaryAreaDaoInterface.update(disciplinaryAreaEntity);

				jsonResponse.setIsValid(true);

				jsonResponse.setSuccessMessage("El area disciplinaria ha sido modificada con exito");

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
	public JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity> search() {
		
		try {

			JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity> jsonResponse = new JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity>();
				
				List<DisciplinaryAreaEntity> disciplinaryAreas = disciplinaryAreaDaoInterface.getAll();
				
				if (disciplinaryAreas.size() < 1) {
					
					jsonResponse.setErrorMessage("No se encontraron resultados para la busqueda");
					
				} else {
					
					jsonResponse.setObjectEntityList(disciplinaryAreas);;
					
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

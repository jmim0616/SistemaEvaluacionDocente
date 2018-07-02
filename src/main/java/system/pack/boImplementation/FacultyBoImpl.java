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

import system.pack.bointerface.DepartmentBoInterface;
import system.pack.bointerface.FacultyBoInterface;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.converter.FacultyConverter;
import system.pack.converter.TeacherConverter;
import system.pack.daoInterface.DepartmentDaoInterface;
import system.pack.daoInterface.DepartmentDaoJpaRepository;
import system.pack.daoInterface.FacultyDaoInterface;
import system.pack.daoInterface.FacultyDaoJpaRepository;
import system.pack.daoInterface.TeacherStatusDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoJpaRepository;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.DepartmentBean;
import system.pack.vo.FacultyBean;
import system.pack.vo.TeacherBean;

@Service
public class FacultyBoImpl implements FacultyBoInterface {

	@Autowired
	DepartmentDaoJpaRepository departmentDaoJpaRepository;

	@Autowired
	DepartmentDaoInterface departmentDaoInterface;
	
	@Autowired
	FacultyDaoJpaRepository facultyDaoJpaRepository;

	@Autowired
	FacultyDaoInterface facultyDaoInterface;
	
	@Transactional
	@Override
	public JsonResponse<DepartmentBean, DepartmentEntity> getDepartment() {
		
		JsonResponse<DepartmentBean, DepartmentEntity> jsonResponse = new JsonResponse<DepartmentBean, DepartmentEntity>();
		
		List<DepartmentEntity> departments = departmentDaoInterface.getAll();
		
		jsonResponse.setObjectEntityList(departments);
		
		return jsonResponse;
		
	}
	
	@Transactional
	@Override
	public JsonResponse<FacultyBean, FacultyEntity> create(FacultyBean facultyBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<FacultyBean, FacultyEntity> jsonResponse = new JsonResponse<FacultyBean, FacultyEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				FacultyEntity facultyEntity = FacultyConverter.ConvertToEntity1(facultyBean);

				facultyDaoInterface.create(facultyEntity);

				jsonResponse.setIsValid(true);

				jsonResponse.setSuccessMessage("La facultad ha sido guardada con exito");

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
	public JsonResponse<FacultyBean, FacultyEntity> update(FacultyBean facultyBean, BindingResult bindingResult) {
		try {

			JsonResponse<FacultyBean, FacultyEntity> jsonResponse = new JsonResponse<FacultyBean, FacultyEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				DepartmentEntity departmentEntity = departmentDaoInterface.findByName(facultyBean.getDepartment());
				
				facultyBean.setDepartment(Integer.toString(departmentEntity.getDepartmentId()));
				
				FacultyEntity facultyEntity = FacultyConverter.ConvertToEntity2(facultyBean);

				facultyDaoInterface.update(facultyEntity);

				jsonResponse.setIsValid(true);

				jsonResponse.setSuccessMessage("La facultad ha sido guardada con exito");

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
	public JsonResponse<FacultyBean, FacultyEntity> search() {
		
		try {

			JsonResponse<FacultyBean, FacultyEntity> jsonResponse = new JsonResponse<FacultyBean, FacultyEntity>();
				
				List<FacultyEntity> faculties = facultyDaoInterface.getAll();
				
				if (faculties.size() < 1) {
					
					jsonResponse.setErrorMessage("No se encontraron resultados para la busqueda");
					
				} else {
					
					jsonResponse.setObjectEntityList(faculties);;
					
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

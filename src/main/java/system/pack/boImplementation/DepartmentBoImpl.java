package system.pack.boImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import system.pack.bointerface.DepartmentBoInterface;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.converter.DepartmentConverter;
import system.pack.converter.TeacherConverter;
import system.pack.daoInterface.DepartmentDaoInterface;
import system.pack.daoInterface.DepartmentDaoJpaRepository;
import system.pack.daoInterface.FacultyDaoInterface;
import system.pack.daoInterface.FacultyDaoJpaRepository;
import system.pack.daoInterface.TeacherStatusDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoJpaRepository;
import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.DepartmentBean;
import system.pack.vo.FacultyBean;
import system.pack.vo.TeacherBean;

@Service
public class DepartmentBoImpl implements DepartmentBoInterface {
	
	@Autowired
	FacultyDaoInterface facultyDaoInterface;
	
	@Autowired
	FacultyDaoJpaRepository facultyDaoJpaRepository;
	
	@Autowired
	DepartmentDaoInterface departmentDaoInterface;
	
	@Autowired
	DepartmentDaoJpaRepository departmentDaoJpaRepository;
	
	
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
	public JsonResponse<DepartmentBean, DepartmentEntity> create(DepartmentBean departmentBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<DepartmentBean, DepartmentEntity> jsonResponse = new JsonResponse<DepartmentBean, DepartmentEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				jsonResponse.setIsValid(true);
				
				Optional<DepartmentEntity> department = departmentDaoInterface.findByName(departmentBean.getName());
				
				if (department.isPresent()) {
					
					jsonResponse.setErrorMessage("El departamento que se quiere registrar ya existe");
				
				} else {
				
				DepartmentEntity departmentEntity = DepartmentConverter.ConvertToEntity1(departmentBean);

				departmentDaoInterface.create(departmentEntity);

				jsonResponse.setSuccessMessage("El departamento ha sido guardado con exito");

			}
				
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
	public JsonResponse<DepartmentBean, DepartmentEntity> update(DepartmentBean departmentBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<DepartmentBean, DepartmentEntity> jsonResponse = new JsonResponse<DepartmentBean, DepartmentEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {
				
				jsonResponse.setIsValid(true);
				
				Optional<DepartmentEntity> department = departmentDaoInterface.findByName(departmentBean.getName());
				
				if (department.isPresent() && department.get().getDepartmentId() != Integer.parseInt(departmentBean.getDepartmentId())) {
					
					jsonResponse.setErrorMessage("El departamento que se quiere modificar ya existe");
				
				} else {
				
					Optional<FacultyEntity> facultyEntity = facultyDaoInterface.findByName(departmentBean.getFaculty());

				departmentBean.setFaculty(Integer.toString(facultyEntity.get().getFacultyId()));
				
				DepartmentEntity departmentEntity = DepartmentConverter.ConvertToEntity2(departmentBean);

				departmentDaoInterface.update(departmentEntity);

				jsonResponse.setSuccessMessage("El departamento ha sido modificado con exito");
				
				}
				
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
	public JsonResponse<DepartmentBean, DepartmentEntity> search() {
		
		try {

			JsonResponse<DepartmentBean, DepartmentEntity> jsonResponse = new JsonResponse<DepartmentBean, DepartmentEntity>();
				
				List<DepartmentEntity> departments = departmentDaoInterface.getAll();
				
				if (departments.size() < 1) {
					
					jsonResponse.setErrorMessage("No se encontraron resultados para la busqueda");
					
				} else {
					
					jsonResponse.setObjectEntityList(departments);;
					
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

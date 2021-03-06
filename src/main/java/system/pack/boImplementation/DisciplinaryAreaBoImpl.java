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
import system.pack.daoInterface.DisciplinaryAreaDaoJpaRepository;
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
	DisciplinaryAreaDaoJpaRepository disciplinaryAreaDaoJpaRepository;

	@Autowired
	private DepartmentDaoInterface departmentDaoInterface;
	
	@Autowired
	private DepartmentDaoJpaRepository departmentDaoJpaRepository;
	
	
	@Transactional
	@Override
	public JsonResponse<DepartmentBean, DepartmentEntity> getAllDepartments() {
		
		JsonResponse<DepartmentBean, DepartmentEntity> jsonResponse = new JsonResponse<DepartmentBean, DepartmentEntity>();
		
		List<DepartmentEntity> departments = departmentDaoInterface.getAll();
		
		jsonResponse.setObjectEntityList(departments);
		
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

				jsonResponse.setIsValid(true);
				
				Optional<DisciplinaryAreaEntity> disciplinaryArea = disciplinaryAreaDaoInterface.findByName(disciplinaryAreaBean.getName());
				
				if (disciplinaryArea.isPresent()) {
					
					jsonResponse.setErrorMessage("El area disciplinaria que se quiere registrar ya existe");
				
				} else {
				
				DisciplinaryAreaEntity disciplinaryAreaEntity = DisciplinaryAreaConverter.ConvertToEntity1(disciplinaryAreaBean);

				disciplinaryAreaDaoInterface.create(disciplinaryAreaEntity);

				jsonResponse.setSuccessMessage("El area disciplinaria ha sido guardada con exito");

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
	public JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity> update(DisciplinaryAreaBean disciplinaryAreaBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity> jsonResponse = new JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {
				
				jsonResponse.setIsValid(true);
				
				Optional<DisciplinaryAreaEntity> disciplinaryArea = disciplinaryAreaDaoInterface.findByName(disciplinaryAreaBean.getName());
				
				if (disciplinaryArea.isPresent() && disciplinaryArea.get().getDisciplinaryAreaId() != Integer.parseInt(disciplinaryAreaBean.getDisciplinaryAreaId())) {
					
					jsonResponse.setErrorMessage("El area disciplinaria que se quiere modificar ya existe");
				
				} else {
				
				Optional<DepartmentEntity> departmentEntity = departmentDaoInterface.findByName(disciplinaryAreaBean.getDepartment());

				disciplinaryAreaBean.setDepartment(Integer.toString(departmentEntity.get().getDepartmentId()));
				
				DisciplinaryAreaEntity disciplinaryAreaEntity = DisciplinaryAreaConverter.ConvertToEntity2(disciplinaryAreaBean);

				disciplinaryAreaDaoInterface.update(disciplinaryAreaEntity);

				jsonResponse.setSuccessMessage("El area disciplinaria ha sido modificada con exito");

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

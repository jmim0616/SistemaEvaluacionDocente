package system.pack.boImplementation;

import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import system.pack.bointerface.TeacherBoInterface;
import system.pack.converter.TeacherConverter;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoJpaRepository;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.TeacherBean;

@Service
public class TeacherBoImpl implements TeacherBoInterface {

	@Autowired
	TeacherDaoInterface teacherDaoInterface;

	@Autowired
	TeacherStatusDaoJpaRepository teacherStatusDaoJpaRepository;

	@Autowired
	TeacherStatusDaoInterface teacherStatusDaoInterface;

	@Transactional
	@Override
	public JsonResponse<TeacherBean, TeacherEntity> create(TeacherBean teacherBean, BindingResult bindingResult) {

		try {

			JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				teacherBean.setTeacherStatus("1");

				TeacherEntity teacherEntity = TeacherConverter.ConvertToEntity(teacherBean);

				teacherDaoInterface.create(teacherEntity);

				jsonResponse.setIsValid(true);

				jsonResponse.setSuccessMessage("El docente ha sido guardado con exito");

			}

			return jsonResponse;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

//			throw new RuntimeException("");

			return null;
			
		}

	}

	public JsonResponse createExcel(TeacherBean teacherBean, BindingResult bindingResult) {

		return null;

	}

	@Transactional
	@Override
	public JsonResponse<TeacherBean, TeacherEntity> update(TeacherBean teacherBean, BindingResult bindingResult) {
	
		try {

			JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				teacherBean.setTeacherStatus("1");
				
				if (teacherBean.getIdentificationType().equalsIgnoreCase("Cedula de Ciudadania")) {
					 teacherBean.setIdentificationType("1");
				} else {
					 teacherBean.setIdentificationType("2");
				}				
				 
				
				TeacherEntity teacherEntity = TeacherConverter.ConvertToEntity(teacherBean);

				teacherDaoInterface.update(teacherEntity);

				jsonResponse.setIsValid(true);

				jsonResponse.setSuccessMessage("El docente ha sido modificado con exito");

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
	public JsonResponse<TeacherBean, TeacherEntity> updateStatus(TeacherBean teacherBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();

					
			 TeacherEntity teacherEntity = teacherDaoInterface.findById(Integer.parseInt(teacherBean.getTeacherId()));
				
				if (teacherBean.getTeacherStatus().equals("Activo")) {
					
					teacherEntity.setTeacherStatus(new TeacherStatusEntity(2));
					
				} else if (teacherBean.getTeacherStatus().equals("Inactivo")) {

					teacherEntity.setTeacherStatus(new TeacherStatusEntity(1));
					
				}

				teacherDaoInterface.update(teacherEntity);

				jsonResponse.setSuccessMessage("El estado del docente se ha sido modificado con exito");


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
	public JsonResponse<TeacherBean, TeacherEntity> search(TeacherBean teacherBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				jsonResponse.setIsValid(true);
				
				TeacherEntity teacherEntity = teacherDaoInterface.findById(Integer.parseInt(teacherBean.getTeacherId()));
				
				if (teacherEntity == null) {
					
					jsonResponse.setErrorMessage("No se encontraron resultados para la busqueda");
					
				} else {
					
					TeacherBean TeacherBean1 = TeacherConverter.ConverToVO(teacherEntity);
					
					jsonResponse.setObjectBean(TeacherBean1);;
					
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

}

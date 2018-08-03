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

import system.pack.bointerface.SubjectBoInterface;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.converter.SubjectConverter;
import system.pack.converter.TeacherConverter;
import system.pack.daoInterface.DisciplinaryAreaDaoInterface;
import system.pack.daoInterface.DisciplinaryAreaDaoJpaRepository;
import system.pack.daoInterface.SubjectByProgramDaoInterface;
import system.pack.daoInterface.SubjectByProgramDaoJpaRepository;
import system.pack.daoInterface.SubjectDaoInterface;
import system.pack.daoInterface.SubjectDaoJpaRepository;
import system.pack.daoInterface.SubjectStatusDaoInterface;
import system.pack.daoInterface.SubjectStatusDaoJpaRepository;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.daoInterface.TeacherDaoJpaRepository;
import system.pack.daoInterface.TeacherStatusDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoJpaRepository;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.SubjectStatusEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.SubjectBean;
import system.pack.vo.TeacherBean;

@Service
public class SubjectBoImpl implements SubjectBoInterface {

	@Autowired
	SubjectStatusDaoInterface subjectStatusDaoInterface;
	
	@Autowired
	SubjectStatusDaoJpaRepository subjectStatusDaoJpaRepository;
	
	@Autowired
	DisciplinaryAreaDaoInterface disciplinaryAreaDaoInterface;
	
	@Autowired
	DisciplinaryAreaDaoJpaRepository DisciplinaryAreaDaoJpaRepository;
	
	@Autowired
	SubjectByProgramDaoInterface subjectByProgramDaoInterface;
	
	@Autowired
	SubjectByProgramDaoJpaRepository subjectByProgramDaoJpaRepository;
	
	@Autowired
	SubjectDaoInterface subjectDaoInterface;
	
	@Autowired
	SubjectDaoJpaRepository subjectDaoJpaRepository;
		

	@Transactional
	@Override
	public JsonResponse<SubjectBean, SubjectEntity> create(SubjectBean subjectBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<SubjectBean, SubjectEntity> jsonResponse = new JsonResponse<SubjectBean, SubjectEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				subjectBean.setSubjectStatus("1");

				SubjectEntity subjectEntity = SubjectConverter.ConvertToEntity1(subjectBean);

				subjectDaoInterface.create(subjectEntity);

				jsonResponse.setIsValid(true);

				jsonResponse.setSuccessMessage("La asignatura ha sido guardada con exito");

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
	public JsonResponse<SubjectBean, SubjectEntity> update(SubjectBean subjectBean, BindingResult bindingResult) {
	
		try {

			JsonResponse<SubjectBean, SubjectEntity> jsonResponse = new JsonResponse<SubjectBean, SubjectEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				subjectBean.setSubjectStatus("1");			
				 			
				SubjectEntity subjectEntity = SubjectConverter.ConvertToEntity2(subjectBean);

				subjectDaoInterface.update(subjectEntity);

				jsonResponse.setIsValid(true);

				jsonResponse.setSuccessMessage("La asignatura ha sido modificada con exito");

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
	public JsonResponse<SubjectBean, SubjectEntity> updateStatus(SubjectBean subjectBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<SubjectBean, SubjectEntity> jsonResponse = new JsonResponse<SubjectBean, SubjectEntity>();

			 SubjectEntity subjectEntity = subjectDaoInterface.findById(Integer.parseInt(subjectBean.getSubjectId()));
			 
				
				if (subjectBean.getSubjectStatus().equals("Activo")) {
					
					subjectEntity.setSubjectStatus(new SubjectStatusEntity(2));
					
				} else if (subjectBean.getSubjectStatus().equals("Inactivo")) {

					subjectEntity.setSubjectStatus(new SubjectStatusEntity(1));
					
				}

				subjectDaoInterface.update(subjectEntity);

				jsonResponse.setSuccessMessage("El estado de la asignatura ha sido modificada con exito");


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
	public JsonResponse<SubjectBean, SubjectEntity> search(SubjectBean subjectBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<SubjectBean, SubjectEntity> jsonResponse = new JsonResponse<SubjectBean, SubjectEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				jsonResponse.setIsValid(true);
				
				SubjectEntity subjectEntity = subjectDaoJpaRepository.findById(Integer.parseInt(subjectBean.getSubjectId()));
				
				if (subjectEntity == null) {
					
					jsonResponse.setErrorMessage("No se encontraron resultados para la busqueda");
					
				} else {
					
					SubjectBean subjectBean1 = SubjectConverter.ConverToVO(subjectEntity);
					
					jsonResponse.setObjectBean(subjectBean1);;
					
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

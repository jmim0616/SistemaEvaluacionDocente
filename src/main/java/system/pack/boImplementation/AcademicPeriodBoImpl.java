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

import system.pack.bointerface.AcademicPeriodBoInterface;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.converter.AcademicPeriodConverter;
import system.pack.converter.TeacherConverter;
import system.pack.daoInterface.AcademicPeriodDaoInterface;
import system.pack.daoInterface.AcademicPeriodDaoJpaRepository;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.daoInterface.TeacherDaoJpaRepository;
import system.pack.daoInterface.TeacherStatusDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoJpaRepository;
import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.AcademicPeriodBean;
import system.pack.vo.TeacherBean;

@Service
public class AcademicPeriodBoImpl implements AcademicPeriodBoInterface {

	@Autowired
	AcademicPeriodDaoInterface academicPeriodDaoInterface;
	
	@Autowired
	AcademicPeriodDaoJpaRepository academicPeriodDaoJpaRepository;

	@Transactional
	@Override
	public JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> create(AcademicPeriodBean academicPeriodBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> jsonResponse = new JsonResponse<AcademicPeriodBean, AcademicPeriodEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				AcademicPeriodEntity academicPeriodEntity = AcademicPeriodConverter.ConvertToEntity1(academicPeriodBean);

				academicPeriodDaoInterface.create(academicPeriodEntity);

				jsonResponse.setIsValid(true);

				jsonResponse.setSuccessMessage("El periodo academico ha sido guardado con exito");

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
	public JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> update(AcademicPeriodBean academicPeriodBean, BindingResult bindingResult) {
	
		try {

			JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> jsonResponse = new JsonResponse<AcademicPeriodBean, AcademicPeriodEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				AcademicPeriodEntity academicPeriodEntity = AcademicPeriodConverter.ConvertToEntity2(academicPeriodBean);

				academicPeriodDaoInterface.update(academicPeriodEntity);

				jsonResponse.setIsValid(true);

				jsonResponse.setSuccessMessage("El periodo academico ha sido modificado con exito");

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
	public JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> search(AcademicPeriodBean academicPeriodBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> jsonResponse = new JsonResponse<AcademicPeriodBean, AcademicPeriodEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				jsonResponse.setIsValid(true);
				
				List<AcademicPeriodEntity> academicPeriods = academicPeriodDaoInterface.findByYear(academicPeriodBean.getName());
				
				if (academicPeriods.size() < 1) {
					
					jsonResponse.setErrorMessage("No se encontraron resultados para la busqueda");
					
				} else {
					
					jsonResponse.setObjectEntityList(academicPeriods);;
					
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

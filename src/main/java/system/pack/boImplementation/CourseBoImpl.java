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

import system.pack.bointerface.CourseBoInterface;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.converter.TeacherConverter;
import system.pack.daoInterface.AcademicPeriodDaoInterface;
import system.pack.daoInterface.AcademicPeriodDaoJpaRepository;
import system.pack.daoInterface.ClassVisitDaoInterface;
import system.pack.daoInterface.ClassVisitDaoJpaRepository;
import system.pack.daoInterface.CoevaluationDaoInterface;
import system.pack.daoInterface.CoevaluationDaoJpaRepository;
import system.pack.daoInterface.CourseDaoInterface;
import system.pack.daoInterface.CourseDaoJpaRepository;
import system.pack.daoInterface.SubjectByTeacherDaoInterface;
import system.pack.daoInterface.SubjectByTeacherDaoJpaRepository;
import system.pack.daoInterface.SubjectDaoInterface;
import system.pack.daoInterface.SubjectDaoJpaRepository;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.daoInterface.TeacherDaoJpaRepository;
import system.pack.daoInterface.TeacherStatusDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoJpaRepository;
import system.pack.entity.CourseEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.ClassVisitBean;
import system.pack.vo.CoevaluationBean;
import system.pack.vo.CourseBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.SubjectByProgramBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;

@Service
public class CourseBoImpl implements CourseBoInterface {

	@Autowired
	CoevaluationDaoInterface coevaluationDaoInterface;
	
	@Autowired
	CoevaluationDaoJpaRepository coevaluationDaoJpaRepository;
	
	@Autowired
	ClassVisitDaoInterface classVisitDaoInterface;
	
	@Autowired
	ClassVisitDaoJpaRepository classVisitDaoJpaRepository;
	
	@Autowired
	AcademicPeriodDaoInterface academicPeriodDaoInterface;
	
	@Autowired
	AcademicPeriodDaoJpaRepository academicPeriodDaoJpaRepository;
	
	@Autowired
	TeacherDaoInterface teacherDaoInterface;
	
	@Autowired
	TeacherDaoJpaRepository teacherDaoJpaRepository;
	
	@Autowired
	SubjectDaoInterface subjectDaoInterface;
	
	@Autowired
	SubjectDaoJpaRepository subjectDaoJpaRepository;
	
	@Autowired
	CourseDaoInterface courseDaoInterface;
	
	@Autowired
	CourseDaoJpaRepository courseDaoJpaRepository;

	@Transactional
	@Override
	public JsonResponse<CourseBean, CourseEntity> create(CourseBean courseBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

//			if (bindingResult.hasErrors()) {
//
//				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
//						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
//
//				jsonResponse.setErrorMessages(errorMessages);
//
//				jsonResponse.setIsValid(false);
//
//			} else {
//
//				teacherBean.setTeacherStatus("1");
//
//				TeacherEntity teacherEntity = TeacherConverter.ConvertToEntity(teacherBean);
//
//				teacherDaoInterface.create(teacherEntity);
//
//				jsonResponse.setIsValid(true);
//
//				jsonResponse.setSuccessMessage("El docente ha sido guardado con exito");
//
//			}
			
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
	public JsonResponse<CourseBean, CourseEntity> update(CourseBean courseBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

//			if (bindingResult.hasErrors()) {
//
//				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
//						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
//
//				jsonResponse.setErrorMessages(errorMessages);
//
//				jsonResponse.setIsValid(false);
//
//			} else {
//
//				teacherBean.setTeacherStatus("1");
//
//				TeacherEntity teacherEntity = TeacherConverter.ConvertToEntity(teacherBean);
//
//				teacherDaoInterface.create(teacherEntity);
//
//				jsonResponse.setIsValid(true);
//
//				jsonResponse.setSuccessMessage("El docente ha sido guardado con exito");
//
//			}
			
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
	public JsonResponse<CourseBean, CourseEntity> delete(CourseBean courseBean, BindingResult bindingResult) {
	
		try {

			JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

//			if (bindingResult.hasErrors()) {
//
//				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
//						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
//
//				jsonResponse.setErrorMessages(errorMessages);
//
//				jsonResponse.setIsValid(false);
//
//			} else {
//
//				teacherBean.setTeacherStatus("1");
//				
//				if (teacherBean.getIdentificationType().equalsIgnoreCase("Cedula de Ciudadania")) {
//					 teacherBean.setIdentificationType("1");
//				} else {
//					 teacherBean.setIdentificationType("2");
//				}				
//				 
//				
//				TeacherEntity teacherEntity = TeacherConverter.ConvertToEntity(teacherBean);
//
//				teacherDaoInterface.update(teacherEntity);
//
//				jsonResponse.setIsValid(true);
//
//				jsonResponse.setSuccessMessage("El docente ha sido modificado con exito");
//
//			}

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
	public JsonResponse<CourseBean, CourseEntity> search(CourseBean courseBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

//			if (bindingResult.hasErrors()) {
//
//				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
//						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
//
//				jsonResponse.setErrorMessages(errorMessages);
//
//				jsonResponse.setIsValid(false);
//
//			} else {
//
//				jsonResponse.setIsValid(true);
//				
//				TeacherEntity teacherEntity = teacherDaoJpaRepository.findById(Integer.parseInt(teacherBean.getTeacherId()));
//				
//				if (teacherEntity == null) {
//					
//					jsonResponse.setErrorMessage("No se encontraron resultados para la busqueda");
//					
//				} else {
//					
//					TeacherBean TeacherBean1 = TeacherConverter.ConverToVO(teacherEntity);
//					
//					jsonResponse.setObjectBean(TeacherBean1);;
//					
//				}
//				
//
//			}

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
	public JsonResponse<CourseBean, CourseEntity> addCoevaluation(CoevaluationBean coevaluationBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
//
//			if (bindingResult.hasErrors()) {
//
//				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
//						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
//
//				jsonResponse.setErrorMessages(errorMessages);
//
//				jsonResponse.setIsValid(false);
//
//			} else {
//
//				teacherBean.setTeacherStatus("1");
//
//				TeacherEntity teacherEntity = TeacherConverter.ConvertToEntity(teacherBean);
//
//				teacherDaoInterface.create(teacherEntity);
//
//				jsonResponse.setIsValid(true);
//
//				jsonResponse.setSuccessMessage("El docente ha sido guardado con exito");
//
//			}
//			
			return jsonResponse;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

//			throw new RuntimeException("");

			return null;
			
		}

	}

	@Override
	public JsonResponse<CourseBean, CourseEntity> addClassVisits(ClassVisitBean classVisitBean, BindingResult bindingResult) {
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		return jsonResponse;
	}
	
	
	@Transactional
	@Override
	public JsonResponse<CourseBean, CourseEntity> searchAcademicPeriodsBySubjectOfTeacher(SubjectBean subjectBean, BindingResult bindingResult) {
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		return jsonResponse;
	}
	
	@Transactional
	@Override
	public JsonResponse<CourseBean, CourseEntity> searchEvaluationsByAcademicPeriodOfTeacher(SubjectBean subjectBean, BindingResult bindingResult) {
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		return jsonResponse;
	}
	
	@Transactional
	@Override
	public JsonResponse<CourseBean, CourseEntity> searchEvaluationsByCourse(CourseBean courseBean, BindingResult bindingResult) {
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		return jsonResponse;
	}
	
	@Transactional
	@Override
	public JsonResponse<CourseBean, CourseEntity> searchCoursesBySubject(SubjectBean subjectBean, BindingResult bindingResult) {
		
		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
		
		return jsonResponse;
	}
	

}

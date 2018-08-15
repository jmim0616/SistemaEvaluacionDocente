package system.pack.boImplementation;

import java.sql.SQLDataException;
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

import system.pack.bointerface.TeacherBoInterface;
import system.pack.converter.TeacherConverter;
import system.pack.daoInterface.SubjectByTeacherDaoInterface;
import system.pack.daoInterface.SubjectByTeacherDaoJpaRepository;
import system.pack.daoInterface.SubjectDaoInterface;
import system.pack.daoInterface.SubjectDaoJpaRepository;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.daoInterface.TeacherDaoJpaRepository;
import system.pack.daoInterface.TeacherStatusDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoJpaRepository;
import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.SubjectByProgramEntity;
import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.AcademicProgramBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.SubjectByProgramBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;

@Service
public class TeacherBoImpl implements TeacherBoInterface {

	@Autowired
	TeacherStatusDaoJpaRepository teacherStatusDaoJpaRepository;

	@Autowired
	TeacherStatusDaoInterface teacherStatusDaoInterface;
	
	@Autowired
	SubjectByTeacherDaoInterface subjectByTeacherDaoInterface;
	
	@Autowired
	SubjectByTeacherDaoJpaRepository subjectByTeacherDaoJpaRepository;
	
	@Autowired
	TeacherDaoInterface teacherDaoInterface;
	
	@Autowired
	TeacherDaoJpaRepository teacherDaoJpaRepository;

	@Autowired
	SubjectDaoInterface subjectDaoInterface;

	@Autowired
	SubjectDaoJpaRepository subjectDaoJpaRepository;
	
	
	@Transactional
	@Override
	public JsonResponse<SubjectBean, SubjectEntity> getAllSubjects() {

		JsonResponse<SubjectBean, SubjectEntity> jsonResponse = new JsonResponse<SubjectBean, SubjectEntity>();

		List<SubjectEntity> subjects = subjectDaoInterface.getAll();

		jsonResponse.setObjectEntityList(subjects);

		return jsonResponse;

	}
	
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

				jsonResponse.setIsValid(true);
				
				Optional<TeacherEntity> teacher = teacherDaoInterface.findByName(teacherBean.getName());
				
				if (teacher.isPresent()) {
					
					jsonResponse.setErrorMessage("El docente que se quiere registrar ya existe");
				
				} else {
				
				teacherBean.setTeacherStatus("1");

				TeacherEntity teacherEntity = TeacherConverter.ConvertToEntity(teacherBean);

				teacherDaoInterface.create(teacherEntity);

				jsonResponse.setSuccessMessage("El docente ha sido guardado con exito");

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

	public JsonResponse<TeacherBean, TeacherEntity> createExcel(TeacherBean teacherBean, BindingResult bindingResult) {

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
				
				jsonResponse.setIsValid(true);
				
				Optional<TeacherEntity> teacher = teacherDaoInterface.findByName(teacherBean.getName());
				
				if (teacher.isPresent() && teacher.get().getTeacherId() != Integer.parseInt(teacherBean.getTeacherId())) {
					
					jsonResponse.setErrorMessage("El docente que se quiere modificar ya existe");
				
				} else {

				teacherBean.setTeacherStatus("1");
				
				if (teacherBean.getIdentificationType().equalsIgnoreCase("Cedula de Ciudadania")) {
					 teacherBean.setIdentificationType("1");
				} else {
					 teacherBean.setIdentificationType("2");
				}				
				 
				
				TeacherEntity teacherEntity = TeacherConverter.ConvertToEntity(teacherBean);

				teacherDaoInterface.update(teacherEntity);

				jsonResponse.setSuccessMessage("El docente ha sido modificado con exito");

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

				jsonResponse.setSuccessMessage("El estado del docente ha sido modificado con exito");


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
	public JsonResponse<SubjectByTeacherBean, SubjectByTeacherEntity> search(TeacherBean teacherBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<SubjectByTeacherBean, SubjectByTeacherEntity> jsonResponse = new JsonResponse<SubjectByTeacherBean, SubjectByTeacherEntity>();

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
					
					List<SubjectByTeacherEntity> subjectsByTeacherEntity = subjectByTeacherDaoInterface
							.findByTeacherId(teacherEntity.getTeacherId());

					SubjectByTeacherEntity subjectByTeacherEntity = new SubjectByTeacherEntity();

					if (subjectsByTeacherEntity.size() < 1) {

						subjectByTeacherEntity.setTeacher(teacherEntity);
						subjectByTeacherEntity.setSubject(new SubjectEntity(null, null, "", 0));

						jsonResponse.setObjectEntity(subjectByTeacherEntity);

					} else if (subjectsByTeacherEntity.size() > 0) {

						String subjectName = "";

						for (SubjectByTeacherEntity item : subjectsByTeacherEntity) {

							subjectName += item.getSubject().getName() + ", ";

						}

						subjectByTeacherEntity.setTeacher(teacherEntity);
						subjectByTeacherEntity.setSubject(new SubjectEntity(null, null, subjectName, 0));
						
						jsonResponse.setObjectEntity(subjectByTeacherEntity);
					
					}
					
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
	public JsonResponse<TeacherBean, TeacherEntity> addSubjects(SubjectByTeacherBean subjectByTeacherBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				TeacherEntity teacher = teacherDaoInterface.findById(Integer.parseInt(subjectByTeacherBean.getTeacher()));
				
				List<String> subjects = null;
				SubjectByTeacherEntity subjectByTeacher = null;
				
				if (subjectByTeacherBean.getSubjectDeleted().size() > 0) {

					subjects = subjectByTeacherBean.getSubjectDeleted();
					
					for (int i = 0; i < subjects.size(); i++) {
					
						Optional<SubjectEntity> subject = subjectDaoInterface.findByName(subjects.get(i));
						
						 subjectByTeacherDaoInterface.deleteByTeacherIdSubjectId(teacher.getTeacherId(), subject.get().getSubjectId());


					}

				}
				
				if (subjectByTeacherBean.getSubjectAdded().size() > 0) {

					subjects = subjectByTeacherBean.getSubjectAdded();
					
					for (int i = 0; i < subjects.size(); i++) {
					
						Optional<SubjectEntity> subject = subjectDaoInterface.findByName(subjects.get(i));
						
						 subjectByTeacherDaoInterface.create(new SubjectByTeacherEntity(subject.get(), teacher));

					}

				}

				jsonResponse.setIsValid(true);

				jsonResponse.setSuccessMessage("Se han agregado las asignaturas al docente correctamente");

			}
			
			return jsonResponse;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

//			throw new RuntimeException("");

			return null;
			
		}

	}

	@Override
	public JsonResponse<TeacherBean, TeacherEntity> searchSubjecstByTeacher(TeacherBean teacherBean, BindingResult bindingResult) {
		JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();
		
		return jsonResponse;
	}
	

}

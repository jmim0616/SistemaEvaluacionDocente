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

import system.pack.bointerface.SubjectBoInterface;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.converter.SubjectConverter;
import system.pack.converter.TeacherConverter;
import system.pack.daoImplementation.SubjectDaoImpl;
import system.pack.daoInterface.AcademicProgramDaoInterface;
import system.pack.daoInterface.AcademicProgramDaoJpaRepository;
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
import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.DisciplinaryAreaEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.SubjectByProgramEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.SubjectStatusEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.AcademicProgramBean;
import system.pack.vo.DisciplinaryAreaBean;
import system.pack.vo.FacultyBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.SubjectByProgramBean;
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
	AcademicProgramDaoInterface academicProgramDaoInterface;

	@Autowired
	AcademicProgramDaoJpaRepository academicProgramJpaRepository;

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
	public JsonResponse<SubjectBean, SubjectEntity> getAllSubjects() {

		JsonResponse<SubjectBean, SubjectEntity> jsonResponse = new JsonResponse<SubjectBean, SubjectEntity>();

		List<SubjectEntity> subjects = subjectDaoInterface.getAll();

		jsonResponse.setObjectEntityList(subjects);

		return jsonResponse;

	}
	
	@Transactional
	@Override
	public JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity> getAllDisciplinaryAreas() {

		JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity> jsonResponse = new JsonResponse<DisciplinaryAreaBean, DisciplinaryAreaEntity>();

		List<DisciplinaryAreaEntity> disciplinaryreas = disciplinaryAreaDaoInterface.getAll();

		jsonResponse.setObjectEntityList(disciplinaryreas);

		return jsonResponse;

	}

	@Transactional
	@Override
	public JsonResponse<AcademicProgramBean, AcademicProgramEntity> getAllAcademicPrograms() {

		JsonResponse<AcademicProgramBean, AcademicProgramEntity> jsonResponse = new JsonResponse<AcademicProgramBean, AcademicProgramEntity>();

		List<AcademicProgramEntity> academicPrograms = academicProgramDaoInterface.getAll();

		jsonResponse.setObjectEntityList(academicPrograms);

		return jsonResponse;

	}

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
								
				jsonResponse.setIsValid(true);
				
				Optional<SubjectEntity> subjectInitial = subjectDaoInterface.findByName(subjectBean.getName());
				
				if (subjectInitial.isPresent()) {
					
					jsonResponse.setErrorMessage("La asignatura que se quiere registrar ya existe");
				
				} else {
				
				subjectBean.setSubjectStatus("1");

				SubjectEntity subjectEntity = SubjectConverter.ConvertToEntity1(subjectBean);

				subjectDaoInterface.create(subjectEntity);

				Optional<SubjectEntity> subject = subjectDaoInterface.findByName(subjectEntity.getName());
				
				if (!subjectBean.getAcademicProgram().equals("")) {

					String[] academicPrograms = subjectBean.getAcademicProgram().split(",");

					for (int i = 0; i < academicPrograms.length; i++) {

						String academicProgramName = academicPrograms[i].replace("\"", "");

						Optional<AcademicProgramEntity> academicProgram = academicProgramDaoInterface.findByName(academicProgramName);

						subjectByProgramDaoInterface.create(new SubjectByProgramEntity(academicProgram.get(), subject.get()));

					}

				}

				jsonResponse.setSuccessMessage("La asignatura ha sido guardada con exito");

			}
			
		}

			return jsonResponse;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

			// throw new RuntimeException("");

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

				jsonResponse.setIsValid(true);
				
				Optional<SubjectEntity> subjectInitial = subjectDaoInterface.findByName(subjectBean.getName());
				
				if (subjectInitial.isPresent() && subjectInitial.get().getSubjectId() != Integer.parseInt(subjectBean.getSubjectId())) {
					
					jsonResponse.setErrorMessage("La asignatura que se quiere modificar ya existe");
				
				} else {
				
				subjectBean.setSubjectStatus("1");

				Optional<DisciplinaryAreaEntity> disciplinaryAreaEntity = disciplinaryAreaDaoInterface.findByName(subjectBean.getDisciplinaryArea());

				subjectBean.setDisciplinaryArea(Integer.toString(disciplinaryAreaEntity.get().getDisciplinaryAreaId()));
				
				SubjectEntity subjectEntity = SubjectConverter.ConvertToEntity2(subjectBean);

				subjectDaoInterface.update(subjectEntity);
				
				Optional<SubjectEntity> subject = subjectDaoInterface.findByName(subjectEntity.getName());
				
				List<String> academicPrograms = null;
				SubjectByProgramEntity subjectByProgram = null;
				
				if (subjectBean.getAcademicProgramDeleted().size() > 0) {

					academicPrograms = subjectBean.getAcademicProgramDeleted();
					
					for (int i = 0; i < academicPrograms.size(); i++) {
					
						Optional<AcademicProgramEntity> academicProgram = academicProgramDaoInterface
								.findByName(academicPrograms.get(i));
						
						 subjectByProgramDaoInterface.deleteByAcademicProgramIdSubjectId(academicProgram.get().getAcademicProgramId(), subject.get().getSubjectId());


					}

				}
				
				if (subjectBean.getAcademicProgramAdded().size() > 0) {

					academicPrograms = subjectBean.getAcademicProgramAdded();
					
					for (int i = 0; i < academicPrograms.size(); i++) {
					
						Optional<AcademicProgramEntity> academicProgram = academicProgramDaoInterface
								.findByName(academicPrograms.get(i));

						subjectByProgramDaoInterface.create(new SubjectByProgramEntity(academicProgram.get(), subject.get()));

					}

				}

				jsonResponse.setSuccessMessage("La asignatura ha sido modificada con exito");

			}
			
		}

			return jsonResponse;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

			// throw new RuntimeException("");

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

			jsonResponse.setObjectBean(new SubjectBean("", "", "", subjectEntity.getName(), "", "", null, null));
			
			return jsonResponse;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

			// throw new RuntimeException("");

			return null;

		}

	}

	@Transactional
	@Override
	public JsonResponse<SubjectByProgramBean, SubjectByProgramEntity> search(SubjectBean subjectBean,
			BindingResult bindingResult) {

		try {

			JsonResponse<SubjectByProgramBean, SubjectByProgramEntity> jsonResponse = new JsonResponse<SubjectByProgramBean, SubjectByProgramEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				jsonResponse.setIsValid(true);
				
				SubjectEntity subjectEntity = null;

				if (subjectBean.getSubjectId() != ""){
					subjectEntity = subjectDaoJpaRepository.findById((Integer.parseInt(subjectBean.getSubjectId())));
				}

				if (subjectEntity == null) {

					jsonResponse.setErrorMessage("No se encontraron resultados para la busqueda");

				} else {

					List<SubjectByProgramEntity> subjectsByProgramEntity = subjectByProgramDaoInterface
							.findBySubjectId(subjectEntity.getSubjectId());

					SubjectByProgramEntity subjectByProgramEntity = new SubjectByProgramEntity();

					if (subjectsByProgramEntity.size() < 1) {

						subjectByProgramEntity.setSubject(subjectEntity);
						subjectByProgramEntity.setAcademicProgram(new AcademicProgramEntity(null, ""));

						jsonResponse.setObjectEntity(subjectByProgramEntity);

					} else if (subjectsByProgramEntity.size() > 0) {

						String academicProgramName = "";

						for (SubjectByProgramEntity item : subjectsByProgramEntity) {

							academicProgramName += item.getAcademicProgram().getName() + ", ";

						}

						subjectByProgramEntity.setSubject(subjectEntity);
						subjectByProgramEntity.setAcademicProgram(new AcademicProgramEntity(null, academicProgramName));

						jsonResponse.setObjectEntity(subjectByProgramEntity);
					
						
						
					}

				}

			}

			return jsonResponse;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

			// throw new RuntimeException("");

			return null;

		}

	}

}

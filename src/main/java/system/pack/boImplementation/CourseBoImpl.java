package system.pack.boImplementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLDataException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.multipart.MultipartFile;

import system.pack.bointerface.CourseBoInterface;

import system.pack.bointerface.TeacherBoInterface;
import system.pack.converter.CourseConverter;
import system.pack.converter.CourseFeedbackConverter;
import system.pack.converter.TeacherConverter;
import system.pack.daoInterface.AcademicPeriodDaoInterface;
import system.pack.daoInterface.AcademicPeriodDaoJpaRepository;
import system.pack.daoInterface.CourseFeedbackDaoInterface;
import system.pack.daoInterface.CourseFeedbackDaoJpaRepository;
import system.pack.daoInterface.FeedbackTypeDaoInterface;
import system.pack.daoInterface.FeedbackTypeDaoJpaRepository;
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
import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.CourseEntity;
import system.pack.entity.CourseFeedbackEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.FeedbackTypeEntity;
import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.entity.UserEntity;
import system.pack.helper.Constants;
import system.pack.helper.ExcelHelper;
import system.pack.helper.JsonResponse;
import system.pack.vo.CourseFeedbackBean;
import system.pack.vo.AcademicPeriodBean;
import system.pack.vo.CourseBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.SubjectByProgramBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;

@Service
public class CourseBoImpl implements CourseBoInterface {

	@Autowired
	FeedbackTypeDaoJpaRepository feedbackTypeDaoJpaRepository;

	@Autowired
	CourseFeedbackDaoInterface courseFeedbackDaoInterface;

	@Autowired
	CourseFeedbackDaoJpaRepository courseFeedbackDaoJpaRepository;

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

	private final String FILE_NAME = "courses"; 
	
	//
	//

	@Transactional
	@Override
	public JsonResponse<CourseBean, CourseEntity> getAllCourses() {

		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

		List<CourseEntity> courses = courseDaoJpaRepository.findAll();

		jsonResponse.setObjectEntityList(courses);

		return jsonResponse;

	}

	@Transactional
	@Override
	public JsonResponse<SubjectBean, SubjectEntity> getAllSubjects() {

		JsonResponse<SubjectBean, SubjectEntity> jsonResponse = new JsonResponse<SubjectBean, SubjectEntity>();

		List<SubjectEntity> subjects = subjectDaoJpaRepository.findAll();

		jsonResponse.setObjectEntityList(subjects);

		return jsonResponse;

	}

	@Transactional
	@Override
	public JsonResponse<TeacherBean, TeacherEntity> getAllTeachers() {

		JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();

		List<TeacherEntity> teachers = teacherDaoJpaRepository.findAll();

		jsonResponse.setObjectEntityList(teachers);

		return jsonResponse;

	}

	@Transactional
	@Override
	public JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> getAllAcademicPeriods() {

		JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> jsonResponse = new JsonResponse<AcademicPeriodBean, AcademicPeriodEntity>();

		List<AcademicPeriodEntity> academicPeriods = academicPeriodDaoJpaRepository.findAll();

		jsonResponse.setObjectEntityList(academicPeriods);

		return jsonResponse;

	}

	public JsonResponse<CourseFeedbackBean, CourseFeedbackEntity> validateCourseFeedbacksAdd(CourseBean courseBean) {

		JsonResponse<CourseFeedbackBean, CourseFeedbackEntity> jsonResponse = new JsonResponse<CourseFeedbackBean, CourseFeedbackEntity>();

		List<CourseFeedbackEntity> courseFeedbacks = courseFeedbackDaoInterface
				.findByCourseId(Integer.parseInt(courseBean.getCourseId()));

		List<FeedbackTypeEntity> feedbackTypes = feedbackTypeDaoJpaRepository.findAll();

		System.out.println("feedbackTypes " + feedbackTypes);
		
		Map<String, String> variables = new HashMap<String, String>();

		if (courseFeedbacks.size() == 0) {

			variables.put("coevaluacion", "false");
			variables.put("resumen de visita", "false");
			variables.put("opinion del coordinador", "false");

		} else {

//			for (int i = 0; i < courseFeedbacks.size(); i++) {
//
//				for (int j = 0; j < feedbackTypes.size(); j++) {
//
//					if (courseFeedbacks.get(i).getFeedBackType().getDescription().equals(feedbackTypes.get(j).getDescription())) {
//
//						variables.put(feedbackTypes.get(j).getDescription(), "true");
//
//					} 
//
//				}
//
//			}

		}

		jsonResponse.setVariables(variables);

		return jsonResponse;

	}

	@Transactional
	@Override
	public JsonResponse<CourseBean, CourseEntity> create(CourseBean courseBean, BindingResult bindingResult) {

		try {

			JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				jsonResponse.setIsValid(true);

				Optional<CourseEntity> course = courseDaoJpaRepository
						.findByGroupId(Integer.parseInt(courseBean.getGroupId()));
				Optional<SubjectEntity> subject = subjectDaoInterface.findByName(courseBean.getSubject());
				Optional<TeacherEntity> teacher = teacherDaoJpaRepository
						.findById(Integer.parseInt(courseBean.getTeacher()));
				Optional<AcademicPeriodEntity> academicPeriod = academicPeriodDaoInterface
						.findByName(courseBean.getAcademicPeriod());

				String errorMessage = "";

				if (!subject.isPresent()) {

					errorMessage = " - El registro de la asignatura no se encuentra en el sistema \n intente con otra asignatura, o cree una nueva.";

					jsonResponse.setErrorMessage(errorMessage);

				}

				if (!teacher.isPresent()) {

					errorMessage += "\n - El registro del profesor no se encuentra en el sistema \n intente con otro profesor, o cree uno nuevo.";

					jsonResponse.setErrorMessage(errorMessage);
				}

				if (!academicPeriod.isPresent()) {

					errorMessage += "\n - El registro del periodo académico no se encuentra en el sistema \n intente con otro periodo académico, o cree uno nuevo.";

					jsonResponse.setErrorMessage(errorMessage);
				}

				if (course.isPresent()) {

					errorMessage += "\n - El curso que se quiere registrar ya existe";

					jsonResponse.setErrorMessage(errorMessage);

				}

				if (jsonResponse.getErrorMessage() == null) {

					courseBean.setSubject(Integer.toString(subject.get().getSubjectId()));
					courseBean.setAcademicPeriod(Integer.toString(academicPeriod.get().getAcademicPeriodId()));

					if (courseBean.getIsVirtual().equals("1")) {

						courseBean.setIsVirtual("S");

					} else {
						courseBean.setIsVirtual("N");
					}

					CourseEntity courseEntity = CourseConverter.ConvertToEntity1(courseBean);

					courseDaoInterface.create(courseEntity);

					jsonResponse.setSuccessMessage("El curso ha sido guardado con exito");

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
	public JsonResponse<CourseBean, CourseEntity> update(CourseBean courseBean, BindingResult bindingResult) {

		try {

			JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				jsonResponse.setIsValid(true);

				Optional<CourseEntity> course = courseDaoJpaRepository
						.findByGroupId(Integer.parseInt(courseBean.getGroupId()));
				Optional<SubjectEntity> subject = subjectDaoInterface.findByName(courseBean.getSubject());
				Optional<TeacherEntity> teacher = teacherDaoJpaRepository
						.findById(Integer.parseInt(courseBean.getTeacher()));
				Optional<AcademicPeriodEntity> academicPeriod = academicPeriodDaoInterface
						.findByName(courseBean.getAcademicPeriod());

				String errorMessage = "";

				if (!subject.isPresent()) {

					errorMessage = " - El registro de la asignatura no se encuentra en el sistema \n intente con otra asignatura, o cree una nueva.";

					jsonResponse.setErrorMessage(errorMessage);

				}

				if (!teacher.isPresent()) {

					errorMessage += "\n - El registro del profesor no se encuentra en el sistema \n intente con otro profesor, o cree uno nuevo.";

					jsonResponse.setErrorMessage(errorMessage);
				}

				if (!academicPeriod.isPresent()) {

					errorMessage += "\n - El registro del periodo académico no se encuentra en el sistema \n intente con otro periodo académico, o cree uno nuevo.";

					jsonResponse.setErrorMessage(errorMessage);
				}

				if (course.isPresent() && course.get().getCourseId() != Integer.parseInt(courseBean.getCourseId())) {

					errorMessage += "\n - El curso que se quiere modificar ya existe";

					jsonResponse.setErrorMessage(errorMessage);

				}

				if (jsonResponse.getErrorMessage() == null) {

					courseBean.setSubject(Integer.toString(subject.get().getSubjectId()));
					courseBean.setAcademicPeriod(Integer.toString(academicPeriod.get().getAcademicPeriodId()));

					if (courseBean.getIsVirtual().equals("Si")) {

						courseBean.setIsVirtual("S");

					} else {
						courseBean.setIsVirtual("N");
					}

					CourseEntity courseEntity = CourseConverter.ConvertToEntity2(courseBean);

					courseDaoInterface.update(courseEntity);

					jsonResponse.setSuccessMessage("El curso ha sido guardado con exito");

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
	public JsonResponse<CourseBean, CourseEntity> delete(CourseBean courseBean, BindingResult bindingResult) {

		try {

			JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

			// if (bindingResult.hasErrors()) {
			//
			// Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
			// .collect(Collectors.toMap(FieldError::getField,
			// FieldError::getDefaultMessage));
			//
			// jsonResponse.setErrorMessages(errorMessages);
			//
			// jsonResponse.setIsValid(false);
			//
			// } else {
			//
			// teacherBean.setTeacherStatus("1");
			//
			// if (teacherBean.getIdentificationType().equalsIgnoreCase("Cedula de
			// Ciudadania")) {
			// teacherBean.setIdentificationType("1");
			// } else {
			// teacherBean.setIdentificationType("2");
			// }
			//
			//
			// TeacherEntity teacherEntity = TeacherConverter.ConvertToEntity(teacherBean);
			//
			// teacherDaoInterface.update(teacherEntity);
			//
			// jsonResponse.setIsValid(true);
			//
			// jsonResponse.setSuccessMessage("El docente ha sido modificado con exito");
			//
			// }

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
	public JsonResponse<CourseBean, CourseEntity> search(CourseBean courseBean, BindingResult bindingResult) {

		try {

			JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				jsonResponse.setIsValid(true);

				CourseEntity courseEntity = courseDaoInterface.findByGroupId(Integer.parseInt(courseBean.getGroupId()));

				if (courseEntity == null) {

					jsonResponse.setErrorMessage("No se encontraron resultados para la busqueda");

				} else {

					List<CourseEntity> listCourses = new ArrayList<CourseEntity>();

					listCourses.add(courseEntity);

					jsonResponse.setObjectEntityList(listCourses);

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
	public JsonResponse<CourseFeedbackBean, CourseFeedbackEntity> addCourseFeedback(
			CourseFeedbackBean courseFeedbackBean, BindingResult bindingResult, HttpSession session) {

		try {

			JsonResponse<CourseFeedbackBean, CourseFeedbackEntity> jsonResponse = new JsonResponse<CourseFeedbackBean, CourseFeedbackEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				jsonResponse.setIsValid(true);

				FeedbackTypeEntity feedbackTypeEntity = feedbackTypeDaoJpaRepository
						.findByDescription(courseFeedbackBean.getFeedBackType());

				System.out.println("feedbackTypeEntity " + feedbackTypeEntity);

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String creationDate = sdf.format(new Date());
				String lastModifiedDate = sdf.format(new Date());

				courseFeedbackBean.setFeedBackType(Integer.toString(feedbackTypeEntity.getFeedBackTypeId()));
				courseFeedbackBean.setUser(session.getAttribute("UserId").toString());
				courseFeedbackBean.setCreationDate(creationDate);
				courseFeedbackBean.setLastModifiedDate(lastModifiedDate);

				CourseFeedbackEntity courseFeedbackEntity = CourseFeedbackConverter
						.ConvertToEntity1(courseFeedbackBean);

				courseFeedbackDaoJpaRepository.save(courseFeedbackEntity);

				jsonResponse.setSuccessMessage("La retroalimentacion del curso ha sido guardada con exito");

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
	public JsonResponse<CourseBean, CourseEntity> searchAcademicPeriodsBySubjectOfTeacher(SubjectBean subjectBean,
			BindingResult bindingResult) {

		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

		return jsonResponse;
	}

	@Transactional
	@Override
	public JsonResponse<CourseBean, CourseEntity> searchEvaluationsByAcademicPeriodOfTeacher(SubjectBean subjectBean,
			BindingResult bindingResult) {

		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

		return jsonResponse;
	}

	@Transactional
	@Override
	public JsonResponse<CourseBean, CourseEntity> searchEvaluationsByCourse(CourseBean courseBean,
			BindingResult bindingResult) {

		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

		return jsonResponse;
	}

	@Transactional
	@Override
	public JsonResponse<CourseBean, CourseEntity> searchCoursesBySubject(SubjectBean subjectBean,
			BindingResult bindingResult) {

		JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

		return jsonResponse;
	}

	@Override
	public String createExcel(MultipartFile file) {
		ExcelHelper excelHelper = new ExcelHelper();
		String result = "";

		try {
			excelHelper.createFile(file, FILE_NAME);
			result = createCourseFromExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	private String createCourseFromExcel() throws IOException {
		File excel = new File(new Constants().FILE_SAVING_ROUTE + FILE_NAME + ".xlsx");
		FileInputStream fileInputStream = null;
		String[] format = { "Periodo académico", "Profesor", "Asignatura", "Grupos", "Virtual" };

		try {
			fileInputStream = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String errorMessage = "";

		int position = 0;

		int rows = 0;

		CourseEntity courseEntity = new CourseEntity();

		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);

		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

		Iterator<Row> rowIt = xssfSheet.iterator();

		Row row = rowIt.next();

		while (rowIt.hasNext()) {

			rows += 1;
			position = 0;
			courseEntity = new CourseEntity();
			boolean isValidRow = true;
			Iterator<Cell> cellIterator = row.cellIterator();

			inner_loop: while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				// Periodo académico
				if (position == 0) {
					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ " El periodo académico no puede estar vacio.";
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						System.out.println("PA");
						int academicPeriodId = academicPeriodDaoInterface
								.getAcademicPeriodByName(cell.getStringCellValue());
						System.out.println("academicPeriodId " + academicPeriodId);
						courseEntity.setAcademicPeriod(new AcademicPeriodEntity(academicPeriodId));

					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						isValidRow = false;
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El periodo académico no es válido.";
					} else if (cell.getCellType() == cell.CELL_TYPE_FORMULA) {
						System.out.println("It's numeric");
					} else {
						System.out.println("Finally");
					}
				}
				// Identificador del docente
				else if (position == 1) {
					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El número de identificación del docente no puede estar vacio";
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El número de identificación del docente no es válido";
						isValidRow = false;
						break inner_loop;
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						courseEntity.setTeacher(new TeacherEntity((int) cell.getNumericCellValue()));
					}
				}
				// Asignatura
				else if (position == 2) {
					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El número de identificación de la asignatura no puede estar vacio";
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El número de identificación de la asignatura no es válido";
						isValidRow = false;
						break inner_loop;
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						courseEntity.setSubject(new SubjectEntity((int) cell.getNumericCellValue()));
					}
				}
				// Grupo
				else if (position == 3) {

					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El número del grupo no puede estar vacio";
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El número del grupo no es válido";
						isValidRow = false;
						break inner_loop;
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						courseEntity.setGroupId(((int) cell.getNumericCellValue()));
					}
				}
				// Indicador si es virtual
				else if (position == 4) {

					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "Debe indicarse si la asignatura es virtual o no.";
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						courseEntity.setIsVirtual(cell.getStringCellValue());

					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						isValidRow = false;
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El valor ingresado para indicar si la asignatura es virtual o no es inválido.";
					}
				}
				position++;
			}

			if (isValidRow) {

				System.out.println(courseEntity.toString());

				// Insert
				courseDaoInterface.create(courseEntity);
			}

			row = rowIt.next();
		}

		xssfWorkbook.close();
		fileInputStream.close();

		Path filePath = Paths.get(new Constants().FILE_SAVING_ROUTE + FILE_NAME + ".xlsx");
		Files.delete(filePath);

		System.out.println(errorMessage);

		return errorMessage;
	}

}

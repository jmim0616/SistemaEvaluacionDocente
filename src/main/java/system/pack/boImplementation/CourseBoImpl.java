package system.pack.boImplementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.swing.text.Position;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.dialect.PostgreSQL94Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.multipart.MultipartFile;

import system.pack.bointerface.CourseBoInterface;

import system.pack.bointerface.TeacherBoInterface;
import system.pack.converter.TeacherConverter;
import system.pack.daoInterface.AcademicPeriodDaoInterface;
import system.pack.daoInterface.AcademicPeriodDaoJpaRepository;
import system.pack.daoInterface.CourseFeedbackDaoInterface;
import system.pack.daoInterface.CourseFeedbackDaoJpaRepository;
import system.pack.daoInterface.DepartmentDaoInterface;
import system.pack.daoInterface.QuestionByPeriodDaoInterface;
import system.pack.daoInterface.QuestionDaoInterface;
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
import system.pack.entity.QuestionByPeriodEntity;
import system.pack.entity.QuestionEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.fullview.Data;
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


	@Autowired
	QuestionByPeriodDaoInterface questionByPeriodDaoInterface;

	@Autowired
	QuestionDaoInterface questionDaoInterface;

	@Autowired
	DepartmentDaoInterface departmentDaoInterface;

	private final String FILE_NAME = "courses";
	private final String FILE_FEEDBACK_NAME = "feedback";
	
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

	public JsonResponse<CourseFeedbackBean, CourseFeedbackEntity> validateCourseFeedbacksAdd() {

		JsonResponse<CourseFeedbackBean, CourseFeedbackEntity> jsonResponse = new JsonResponse<CourseFeedbackBean, CourseFeedbackEntity>();

		List<CourseFeedbackEntity> courseFeedbacks = courseFeedbackDaoJpaRepository.findAll();

		Map<CourseFeedbackEntity, String> variableEntityStates = new HashMap<CourseFeedbackEntity, String>();

		for (CourseFeedbackEntity item : courseFeedbacks) {
			// coevaluacion
			if ((item.getFeedBackType().getFeedBackTypeId() == 1)) {
				variableEntityStates.put(new CourseFeedbackEntity(item.getCourseFeedBackId(), null,
						item.getFeedBackType(), null, null, null, null), "false");
			}
			// opnion del coordinador
			if ((item.getFeedBackType().getFeedBackTypeId() == 3)) {
				variableEntityStates.put(new CourseFeedbackEntity(item.getCourseFeedBackId(), null,
						item.getFeedBackType(), null, null, null, null), "false");
			}

		}

		//jsonResponse.setVariableEntityStates(variableEntityStates);

		return jsonResponse;

	}

	@Transactional
	@Override
	public JsonResponse<CourseBean, CourseEntity> create(CourseBean courseBean, BindingResult bindingResult) {

		try {

			JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

			// if (bindingResult.hasErrors()) {
			//
			// Map<String, String> errorMessages =
			// bindingResult.getFieldErrors().stream()
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
			// TeacherEntity teacherEntity =
			// TeacherConverter.ConvertToEntity(teacherBean);
			//
			// teacherDaoInterface.create(teacherEntity);
			//
			// jsonResponse.setIsValid(true);
			//
			// jsonResponse.setSuccessMessage("El docente ha sido guardado con
			// exito");
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
	public JsonResponse<CourseBean, CourseEntity> update(CourseBean courseBean, BindingResult bindingResult) {

		try {

			JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

			// if (bindingResult.hasErrors()) {
			//
			// Map<String, String> errorMessages =
			// bindingResult.getFieldErrors().stream()
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
			// TeacherEntity teacherEntity =
			// TeacherConverter.ConvertToEntity(teacherBean);
			//
			// teacherDaoInterface.create(teacherEntity);
			//
			// jsonResponse.setIsValid(true);
			//
			// jsonResponse.setSuccessMessage("El docente ha sido guardado con
			// exito");
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
	public JsonResponse<CourseBean, CourseEntity> delete(CourseBean courseBean, BindingResult bindingResult) {

		try {

			JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

			// if (bindingResult.hasErrors()) {
			//
			// Map<String, String> errorMessages =
			// bindingResult.getFieldErrors().stream()
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
			// if (teacherBean.getIdentificationType().equalsIgnoreCase("Cedula
			// de Ciudadania")) {
			// teacherBean.setIdentificationType("1");
			// } else {
			// teacherBean.setIdentificationType("2");
			// }
			//
			//
			// TeacherEntity teacherEntity =
			// TeacherConverter.ConvertToEntity(teacherBean);
			//
			// teacherDaoInterface.update(teacherEntity);
			//
			// jsonResponse.setIsValid(true);
			//
			// jsonResponse.setSuccessMessage("El docente ha sido modificado con
			// exito");
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

			// if (bindingResult.hasErrors()) {
			//
			// Map<String, String> errorMessages =
			// bindingResult.getFieldErrors().stream()
			// .collect(Collectors.toMap(FieldError::getField,
			// FieldError::getDefaultMessage));
			//
			// jsonResponse.setErrorMessages(errorMessages);
			//
			// jsonResponse.setIsValid(false);
			//
			// } else {
			//
			// jsonResponse.setIsValid(true);
			//
			// TeacherEntity teacherEntity =
			// teacherDaoJpaRepository.findById(Integer.parseInt(teacherBean.getTeacherId()));
			//
			// if (teacherEntity == null) {
			//
			// jsonResponse.setErrorMessage("No se encontraron resultados para
			// la busqueda");
			//
			// } else {
			//
			// TeacherBean TeacherBean1 =
			// TeacherConverter.ConverToVO(teacherEntity);
			//
			// jsonResponse.setObjectBean(TeacherBean1);;
			//
			// }
			//
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
	public JsonResponse<CourseBean, CourseEntity> addCourseFeedback(CourseFeedbackBean courseFeedbackBean,
			BindingResult bindingResult) {

		try {

			JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();
			//
			// if (bindingResult.hasErrors()) {
			//
			// Map<String, String> errorMessages =
			// bindingResult.getFieldErrors().stream()
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
			// TeacherEntity teacherEntity =
			// TeacherConverter.ConvertToEntity(teacherBean);
			//
			// teacherDaoInterface.create(teacherEntity);
			//
			// jsonResponse.setIsValid(true);
			//
			// jsonResponse.setSuccessMessage("El docente ha sido guardado con
			// exito");
			//
			// }
			//
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
			excelHelper.createFile(file, FILE_FEEDBACK_NAME);
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
		String[] format = { "Periodo acad�mico", "Profesor", "Asignatura", "Grupos", "Virtual" };

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

		Iterator<Row> rowIt = xssfSheet.rowIterator();

		Row row;

		while (rowIt.hasNext()) {

			row = rowIt.next();

			rows += 1;
			position = 0;
			courseEntity = new CourseEntity();
			boolean isValidRow = true;
			Iterator<Cell> cellIterator = row.cellIterator();

			inner_loop: while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				// Periodo acad�mico
				if (position == 0) {
					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ " El periodo acad�mico no puede estar vacio.";
						isValidRow = false;
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						System.out.println("PA");
						int academicPeriodId = academicPeriodDaoInterface
								.getAcademicPeriodByName(cell.getStringCellValue());
						System.out.println("academicPeriodId " + academicPeriodId);
						if (academicPeriodId == 0) {
							isValidRow = false;
							errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
									+ " El periodo acad�mico no existe.";
						}
						courseEntity.setAcademicPeriod(new AcademicPeriodEntity(academicPeriodId));

					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						isValidRow = false;
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El periodo acad�mico no es v�lido.";
					}
				}
				// Identificador del docente
				else if (position == 1) {
					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El n�mero de identificaci�n del docente no puede estar vacio";
						isValidRow = false;
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El n�mero de identificaci�n del docente no es v�lido";
						isValidRow = false;
						break inner_loop;
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						if (teacherDaoInterface.isValidTeacherId((int) cell.getNumericCellValue())) {
							courseEntity.setTeacher(new TeacherEntity((int) cell.getNumericCellValue()));
						} else {
							errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
									+ "El n�mero de identificaci�n del docente no existe.";
							isValidRow = false;
							break inner_loop;
						}

					}
				}
				// Asignatura
				else if (position == 2) {
					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El n�mero de identificaci�n de la asignatura no puede estar vacio";
						isValidRow = false;
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El n�mero de identificaci�n de la asignatura no es v�lido";
						isValidRow = false;
						break inner_loop;
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						if (subjectDaoInterface.isValidSubjectId((int) cell.getNumericCellValue())) {
							courseEntity.setSubject(new SubjectEntity((int) cell.getNumericCellValue()));
						} else {
							errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
									+ "El n�mero de identificaci�n de la asignatura no existe.";
							isValidRow = false;
							break inner_loop;
						}
					}
				}
				// Grupo
				else if (position == 3) {

					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El n�mero del grupo no puede estar vacio";
						isValidRow = false;
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El n�mero del grupo no es v�lido";
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
						isValidRow = false;
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						courseEntity.setIsVirtual(cell.getStringCellValue());

					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						isValidRow = false;
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El valor ingresado para indicar si la asignatura es virtual o no es inv�lido.";
					}
				}

				position++;
			}

			if (isValidRow) {
				// Insert
				courseDaoInterface.create(courseEntity);

			}
		}

		xssfWorkbook.close();
		fileInputStream.close();

		Path filePath = Paths.get(new Constants().FILE_SAVING_ROUTE + FILE_NAME + ".xlsx");
		Files.delete(filePath);

		System.out.println(errorMessage);

		return errorMessage;
	}

	@Override
	public String createOnlineFeedBack(MultipartFile file, int academicPeriod) {
		ExcelHelper excelHelper = new ExcelHelper();
		String result = "";

		try {
			excelHelper.createFile(file, FILE_FEEDBACK_NAME);
			result = createOnlineFeedbackExcel(academicPeriod);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	private String createOnlineFeedbackExcel(int academicPeriod) throws IOException {
		File excel = new File(new Constants().FILE_SAVING_ROUTE + FILE_FEEDBACK_NAME + ".xlsx");
		FileInputStream fileInputStream = null;
		String[] format = { "Periodo acad�mico", "Profesor", "Asignatura", "Grupos", "Virtual" };

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

		Iterator<Row> rowIt = xssfSheet.rowIterator();

		boolean isFirstRow = true;

		Map<Integer, QuestionEntity> map = new HashMap<>();

		Row row;

		while (rowIt.hasNext()) {

			row = rowIt.next();

			rows += 1;
			if (rows > 1 && isFirstRow)
				isFirstRow = false;

			position = 0;
			QuestionByPeriodEntity questionByPeriodEntity = new QuestionByPeriodEntity();
			boolean isValidRow = true;
			Iterator<Cell> cellIterator = row.cellIterator();
			TeacherEntity teacher = new TeacherEntity();
			SubjectEntity subject = new SubjectEntity();
			Map<Integer, Double> questionValues = new HashMap<>();
			int groupId = 0;

			inner_loop: while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();

				if (isFirstRow) {
					if (position > 3) {
						QuestionEntity questionEntity = new QuestionEntity();
						questionEntity.setQuestion(cell.getStringCellValue());
						questionDaoInterface.create(questionEntity);
						map.put(position, questionEntity);
						System.out.println("Question Id" + questionEntity.getQuestionId());
					}

				} else {
					// Departamento
					if (position == 0) {
						if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
							errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
									+ "El n�mero de departamento no puede estar vacio";
							isValidRow = false;
							break inner_loop;
						}
						if (cell.getCellType() == cell.CELL_TYPE_STRING) {
							errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
									+ "El n�mero de departamento no es v�lido";
							isValidRow = false;
							break inner_loop;
						} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
							if (departmentDaoInterface.isValidDepartmentId((int) cell.getNumericCellValue())) {
								questionByPeriodEntity
										.setDepartment((new DepartmentEntity((int) cell.getNumericCellValue())));
							} else {
								errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
										+ "El n�mero de departamento no existe.";
								isValidRow = false;
								break inner_loop;
							}
						}
					}

					// Asignatura
					else if (position == 1) {
						if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
							errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
									+ "El n�mero de identificaci�n de la asignatura no puede estar vacio";
							isValidRow = false;
							break inner_loop;
						}
						if (cell.getCellType() == cell.CELL_TYPE_STRING) {
							errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
									+ "El n�mero de identificaci�n de la asignatura no es v�lido";
							isValidRow = false;
							break inner_loop;
						} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
							if (subjectDaoInterface.isValidSubjectId((int) cell.getNumericCellValue())) {
								subject = new SubjectEntity((int) cell.getNumericCellValue());
							} else {
								errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
										+ "El n�mero de identificaci�n de la asignatura no existe.";
								isValidRow = false;
								break inner_loop;
							}
						}
					}
					// Grupo
					else if (position == 2) {

						if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
							errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
									+ "El n�mero del grupo no puede estar vacio";
							isValidRow = false;
							break inner_loop;
						}
						if (cell.getCellType() == cell.CELL_TYPE_STRING) {
							errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
									+ "El n�mero del grupo no es v�lido";
							isValidRow = false;
							break inner_loop;
						} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
							groupId = (int) cell.getNumericCellValue();
						}
					}
					// Identificador del docente
					else if (position == 3) {
						if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
							errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
									+ "El n�mero de identificaci�n del docente no puede estar vacio";
							isValidRow = false;
							break inner_loop;
						}
						if (cell.getCellType() == cell.CELL_TYPE_STRING) {
							errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
									+ "El n�mero de identificaci�n del docente no es v�lido";
							isValidRow = false;
							break inner_loop;
						} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
							if (teacherDaoInterface.isValidTeacherId((int) cell.getNumericCellValue())) {
								teacher = new TeacherEntity((int) cell.getNumericCellValue());
							} else {
								errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
										+ "El n�mero de identificaci�n del docente no existe.";
								isValidRow = false;
								break inner_loop;
							}

						}
					}

					if (position == 4) {
						int courseId = questionByPeriodDaoInterface.getCourseId(subject.getSubjectId(), groupId,
								teacher.getTeacherId(), academicPeriod);

						if (courseId == 0) {
							errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
									+ "El curso no existe.";
							isValidRow = false;
							break inner_loop;
						} else {
							questionByPeriodEntity.setCourse(new CourseEntity(courseId));
							questionByPeriodEntity.setAcademicPeriod(new AcademicPeriodEntity(academicPeriod));
						}
					}

					if (map.containsKey(position)) {
						if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
							errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
									+ "El valor de la pregunta en la columna " + position + " no puede estar vacio.";
							isValidRow = false;
							break inner_loop;
						}
						if (cell.getCellType() == cell.CELL_TYPE_STRING) {
							errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
									+ "El valor de la pregunta en la columna " + position + " no es v�lido.";
							isValidRow = false;
							break inner_loop;
						} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
							questionValues.put(map.get(position).getQuestionId(), cell.getNumericCellValue());
						}
					}
				}

				position++;
			}

			if (isValidRow && !isFirstRow) {
				// Insert
				Iterator questions = questionValues.keySet().iterator();
				while (questions.hasNext()){
					Integer questionId = (Integer) questions.next();
					questionByPeriodEntity.setQuestion(new QuestionEntity(questionId));
					questionByPeriodEntity.setPercentage(questionValues.get(questionId).intValue());
					questionByPeriodDaoInterface.create(questionByPeriodEntity);
				}
			}
		}

		xssfWorkbook.close();
		fileInputStream.close();

		Path filePath = Paths.get(new Constants().FILE_SAVING_ROUTE + FILE_FEEDBACK_NAME + ".xlsx");
		Files.delete(filePath);

		System.out.println(errorMessage);

		return errorMessage;
	}

	@Override
	public JsonResponse addCourseFeedback(CourseFeedbackBean courseFeedbackBean, BindingResult bindingResult,
			HttpSession session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JsonResponse validateCourseFeedbacksAdd(CourseBean courseBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Data getCompareView(CourseBean courseBean) {	
		return courseDaoInterface.getCompareView(courseBean);
	}
	
	

}

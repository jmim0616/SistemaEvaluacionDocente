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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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

import system.pack.bointerface.TeacherBoInterface;
import system.pack.converter.TeacherConverter;
import system.pack.daoInterface.CourseDaoInterface;
import system.pack.daoInterface.SubjectByTeacherDaoInterface;
import system.pack.daoInterface.SubjectByTeacherDaoJpaRepository;
import system.pack.daoInterface.SubjectDaoInterface;
import system.pack.daoInterface.SubjectDaoJpaRepository;
import system.pack.daoInterface.TeacherDaoInterface;
import system.pack.daoInterface.TeacherDaoJpaRepository;
import system.pack.daoInterface.TeacherStatusDaoInterface;
import system.pack.daoInterface.TeacherStatusDaoJpaRepository;
import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.CourseEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.SubjectByProgramEntity;
import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.helper.Constants;
import system.pack.helper.ExcelHelper;
import system.pack.helper.JsonResponse;
import system.pack.vo.AcademicProgramBean;
import system.pack.vo.CourseBean;
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

	@Autowired
	CourseDaoInterface courseDaoInterface;

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
	public JsonResponse<SubjectBean, SubjectEntity> getAllSubjects() {

		JsonResponse<SubjectBean, SubjectEntity> jsonResponse = new JsonResponse<SubjectBean, SubjectEntity>();

		List<SubjectEntity> subjects = subjectDaoInterface.getAll();

		jsonResponse.setObjectEntityList(subjects);

		return jsonResponse;

	}

	private final String FILE_NAME = "teachers";

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

			// throw new RuntimeException("");

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

				Map<String, ArrayList<String>> errorMessages1;

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				jsonResponse.setIsValid(true);

				Optional<TeacherEntity> teacher = teacherDaoInterface.findByName(teacherBean.getName());

				if (teacher.isPresent()
						&& teacher.get().getTeacherId() != Integer.parseInt(teacherBean.getTeacherId())) {

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

			// throw new RuntimeException("");

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
				jsonResponse.setSuccessMessage("El estado del docente ha sido modificado con exito");

			}

			teacherDaoInterface.update(teacherEntity);

			jsonResponse.setSuccessMessage("El estado del docente se ha sido modificado con exito");

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
	public JsonResponse<SubjectByTeacherBean, SubjectByTeacherEntity> search(TeacherBean teacherBean,
			BindingResult bindingResult) {

		try {

			JsonResponse<SubjectByTeacherBean, SubjectByTeacherEntity> jsonResponse = new JsonResponse<SubjectByTeacherBean, SubjectByTeacherEntity>();

			jsonResponse.setIsValid(true);

			List<TeacherEntity> teacherEntityList = teacherDaoInterface.getTeachers(teacherBean);

			if (teacherEntityList.size() == 0) {

				jsonResponse.setErrorMessage("No se encontraron resultados para la busqueda");

			} else {

				List<SubjectByTeacherEntity> subjectsByTeacherEntityPrueba = new ArrayList<SubjectByTeacherEntity>();

				for (TeacherEntity teacher : teacherEntityList) {

					System.out.println("Current teacher: " + teacher);

					List<SubjectByTeacherEntity> subjectsByTeacherEntity = subjectByTeacherDaoInterface
							.findByTeacherId(teacher.getTeacherId());

					SubjectByTeacherEntity subjectByTeacherEntity = new SubjectByTeacherEntity();

					// Esto no va en el codigo, solo para pruebas sobre las
					// vista fecha: octubre 2 2018
					// List<SubjectByTeacherEntity>
					// subjectsByTeacherEntityPrueba = new
					// ArrayList<SubjectByTeacherEntity>();
					//

					if (subjectsByTeacherEntity.size() < 1) {

						subjectByTeacherEntity.setTeacher(teacher);
						subjectByTeacherEntity.setSubject(new SubjectEntity(null, null, "", 0));

						jsonResponse.setObjectEntity(subjectByTeacherEntity);

						// Esto no va en el codigo, solo para pruebas sobre las
						// vista fecha: octubre 2 2018
						subjectsByTeacherEntityPrueba.add(subjectByTeacherEntity);
						jsonResponse.setObjectEntityList(subjectsByTeacherEntityPrueba);
						//

					} else if (subjectsByTeacherEntity.size() > 0) {

						String subjectName = "";

						for (SubjectByTeacherEntity item : subjectsByTeacherEntity) {

							subjectName += item.getSubject().getName() + ", ";

						}

						subjectByTeacherEntity.setTeacher(teacher);
						subjectByTeacherEntity.setSubject(new SubjectEntity(null, null, subjectName, 0));

						jsonResponse.setObjectEntity(subjectByTeacherEntity);

						// Esto no va en el codigo, solo para pruebas sobre las
						// vista fecha: octubre 2 2018
						subjectsByTeacherEntityPrueba.add(subjectByTeacherEntity);

						//

					}

				}
				jsonResponse.setObjectEntityList(subjectsByTeacherEntityPrueba);
			}

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
	public JsonResponse<CourseBean, CourseEntity> getCoursesByTeacher(TeacherBean teacherBean,
			BindingResult bindingResult) {

		try {

			JsonResponse<CourseBean, CourseEntity> jsonResponse = new JsonResponse<CourseBean, CourseEntity>();

			jsonResponse.setIsValid(true);

			List<CourseEntity> courseEntityList = courseDaoInterface.getCoursesByTeacher(teacherBean.getTeacherId());

			System.out.println("courseEntityList " + courseEntityList);
			if (courseEntityList.size() == 0) {

				jsonResponse.setErrorMessage("No se encontraron resultados para la busqueda");

			} else {

				//
				jsonResponse.setObjectEntityList(courseEntityList);

			}

			// }

			return jsonResponse;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

			// throw new RuntimeException("");

			return null;

		}

	}

	public String createExcel(MultipartFile file) {

		ExcelHelper excelHelper = new ExcelHelper();
		String result = "";

		try {
			excelHelper.createFile(file, FILE_NAME);
			result = createTeacherFromExcel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	private String createTeacherFromExcel() throws IOException {

		File excel = new File(new Constants().FILE_SAVING_ROUTE + FILE_NAME + ".xlsx");
		FileInputStream fileInputStream = null;
		String[] format = { "Tipo de identificacion", "Identificacion", "Nombre", "Apellido", "Titulo(s) de pregrado",
				"Titulo(s) de postgrado", "Titulo(s) de doctorado", "Correo institucional", "Correo personal",
				"Telefono celular", "Telefono fijo", "Resumen de experiencia" };

		try {
			fileInputStream = new FileInputStream(excel);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String errorMessage = "";

		int position = 0;

		int rows = 0;

		TeacherEntity teacherEntity = new TeacherEntity();

		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);

		XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(0);

		Iterator<Row> rowIt = xssfSheet.iterator();

		Row row = rowIt.next();

		while (rowIt.hasNext()) {

			rows += 1;
			position = 0;
			teacherEntity = new TeacherEntity();
			boolean isValidRow = true;
			Iterator<Cell> cellIterator = row.cellIterator();

			inner_loop: while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				// Tipo de ID
				if (position == 0) {
					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ " El tipo de identificación no puede estar vacio";
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El tipo de identificación no es válido";
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						teacherEntity.setIdentificationType((int) cell.getNumericCellValue());
					}
				}
				// Número ID
				else if (position == 1) {

					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El número de identificación no puede estar vacio";
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El número de identificación no es válido";
						isValidRow = false;
						break inner_loop;
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						teacherEntity.setTeacherId((int) cell.getNumericCellValue());
					}
				}
				// Nombre
				else if (position == 2) {

					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: " + "La fila " + rows
								+ " tiene el siguiente error: " + "El nombre no puede estar vacio";
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						teacherEntity.setName(cell.getStringCellValue());
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						isValidRow = false;
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El nombre debe contener letras";
						break inner_loop;
					}
				}
				// Apellido
				else if (position == 3) {

					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El apellido no puede estar vacio";
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						teacherEntity.setLastName((cell.getStringCellValue()));
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El apellido debe contener letras";
						isValidRow = false;
						break inner_loop;
					}
				}
				// pregrado
				else if (position == 4) {

					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						teacherEntity.setUnderDegree((cell.getStringCellValue()));
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El título de pregado no puede ser un valor númerico";
						isValidRow = false;
						break inner_loop;
					}
				}
				// posgrado
				else if (position == 5) {

					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						teacherEntity.setMasterDegree((cell.getStringCellValue()));
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El título de maestria no puede ser un valor númerico";
						isValidRow = false;
						break inner_loop;
					}
				}
				// doctorado
				else if (position == 6) {

					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						teacherEntity.setDoctorDegree((cell.getStringCellValue()));
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El título de doctorado no puede ser un valor númerico";
						isValidRow = false;
						break inner_loop;
					}
				}
				// correo institucional
				else if (position == 7) {

					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						teacherEntity.setInstitutionalMail((cell.getStringCellValue()));
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El correo no puede ser un valor númerico";
						isValidRow = false;
						break inner_loop;
					}
				}
				// correo personal
				else if (position == 8) {

					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						teacherEntity.setPersonalMail((cell.getStringCellValue()));
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El correo no puede ser un valor númerico";
						isValidRow = false;
						break inner_loop;
					}
				}
				// celular
				else if (position == 9) {

					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El número del celular no puede tener letras";
						isValidRow = false;
						break inner_loop;
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						System.out.println(cell.getNumericCellValue());
						teacherEntity.setCellNumber(String.valueOf((long) cell.getNumericCellValue()));
					}
				}
				// fijo
				else if (position == 10) {

					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El número de teléfono fijo no puede tener letras";
						isValidRow = false;
						break inner_loop;
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						teacherEntity.setHomeNumber(String.valueOf((long) cell.getNumericCellValue()));
					}
				}
				// fijo
				else if (position == 11) {

					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						teacherEntity.setExperience(cell.getStringCellValue());
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "La experiencia no puede ser un valor númerico";
						isValidRow = false;
						break inner_loop;
					}
				}
				position++;
			}

			if (isValidRow) {

				// Insert
				TeacherStatusEntity teacherStatusEntity = new TeacherStatusEntity();
				teacherStatusEntity.setTeacherStatusId(1);
				teacherEntity.setTeacherStatus(teacherStatusEntity);
				teacherDaoInterface.create(teacherEntity);
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

	@Transactional
	@Override
	public JsonResponse<TeacherBean, TeacherEntity> addSubjects(SubjectByTeacherBean subjectByTeacherBean,
			BindingResult bindingResult) {

		try {

			JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				TeacherEntity teacher = teacherDaoInterface
						.findById(Integer.parseInt(subjectByTeacherBean.getTeacher()));

				List<String> subjects = null;
				SubjectByTeacherEntity subjectByTeacher = null;

				if (subjectByTeacherBean.getSubjectDeleted().size() > 0) {

					subjects = subjectByTeacherBean.getSubjectDeleted();

					for (int i = 0; i < subjects.size(); i++) {

						Optional<SubjectEntity> subject = subjectDaoInterface.findByName(subjects.get(i));

						subjectByTeacherDaoInterface.deleteByTeacherIdSubjectId(teacher.getTeacherId(),
								subject.get().getSubjectId());

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

			// throw new RuntimeException("");

			return null;

		}

	}

	@Override
	public JsonResponse<TeacherBean, TeacherEntity> searchSubjecstByTeacher(TeacherBean teacherBean,
			BindingResult bindingResult) {
		JsonResponse<TeacherBean, TeacherEntity> jsonResponse = new JsonResponse<TeacherBean, TeacherEntity>();

		return jsonResponse;
	}

}

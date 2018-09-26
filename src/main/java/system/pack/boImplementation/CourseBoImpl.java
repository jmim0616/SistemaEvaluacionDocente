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

import system.pack.bointerface.CourseBoInterface;

import system.pack.bointerface.TeacherBoInterface;
import system.pack.converter.TeacherConverter;
import system.pack.daoInterface.AcademicPeriodDaoInterface;
import system.pack.daoInterface.AcademicPeriodDaoJpaRepository;
import system.pack.daoInterface.CourseFeedbackDaoInterface;
import system.pack.daoInterface.CourseFeedbackDaoJpaRepository;
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
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.helper.Constants;
import system.pack.helper.ExcelHelper;
import system.pack.helper.JsonResponse;
import system.pack.vo.CourseFeedbackBean;
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
	
	private final String FILE_NAME = "courses";

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
	public JsonResponse<CourseBean, CourseEntity> addCourseFeedbacks(CourseFeedbackBean courseFeedbackBean, BindingResult bindingResult) {
		
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
		String[] format = { "Periodo académico", "Profesor", "Asignatura", "Grupos", "Virtual"};

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
				// Periodo académico
				if (position == 0) {
					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ " El periodo académico no puede estar vacio.";
						isValidRow = false;
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
							System.out.println("PA");
							int academicPeriodId= academicPeriodDaoInterface.getAcademicPeriodByName(cell.getStringCellValue());
							System.out.println("academicPeriodId " + academicPeriodId);
							if (academicPeriodId == 0){
								isValidRow = false;
								errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
										+ " El periodo académico no existe.";
							}
							courseEntity.setAcademicPeriod(new AcademicPeriodEntity(academicPeriodId));
						
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						isValidRow = false;
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+ "El periodo académico no es válido.";
					}
				}
				// Identificador del docente
				else if (position == 1) {
					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" +  "La fila " + rows + " tiene el siguiente error: "
								+ "El número de identificación del docente no puede estar vacio";
						isValidRow = false;
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+"El número de identificación del docente no es válido";
						isValidRow = false;
						break inner_loop;
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						courseEntity.setTeacher(new TeacherEntity((int)cell.getNumericCellValue()));
					}
				}
				// Asignatura
				else if (position == 2) {
					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" +  "La fila " + rows + " tiene el siguiente error: "
								+ "El número de identificación de la asignatura no puede estar vacio";
						isValidRow = false;
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+"El número de identificación de la asignatura no es válido";
						isValidRow = false;
						break inner_loop;
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						courseEntity.setSubject(new SubjectEntity((int)cell.getNumericCellValue()));
					}
				}
				// Grupo
				else if (position == 3) {

					if (cell.getCellType() == cell.CELL_TYPE_BLANK) {
						errorMessage += "\n" +  "La fila " + rows + " tiene el siguiente error: "
								+ "El número del grupo no puede estar vacio";
						isValidRow = false;
						break inner_loop;
					}
					if (cell.getCellType() == cell.CELL_TYPE_STRING) {
						errorMessage += "\n" + "La fila " + rows + " tiene el siguiente error: "
								+"El número del grupo no es válido";
						isValidRow = false;
						break inner_loop;
					} else if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
						courseEntity.setGroupId(((int)cell.getNumericCellValue()));
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
								+ "El valor ingresado para indicar si la asignatura es virtual o no es inválido.";
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

}

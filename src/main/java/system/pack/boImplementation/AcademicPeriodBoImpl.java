package system.pack.boImplementation;

import java.sql.SQLDataException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.NoResultException;

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
	public JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> create(AcademicPeriodBean academicPeriodBean,
			BindingResult bindingResult) {

		try {

			JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> jsonResponse = new JsonResponse<AcademicPeriodBean, AcademicPeriodEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				jsonResponse.setIsValid(true);

				Optional<AcademicPeriodEntity> academicPeriod = academicPeriodDaoInterface
						.findByName(academicPeriodBean.getName());

				if (academicPeriod.isPresent()) {

					jsonResponse.setErrorMessage("El periodo academico que se quiere registrar ya existe");

				} else {

					AcademicPeriodEntity lastAcademicPeriod = academicPeriodDaoInterface.getlastRecord();

					AcademicPeriodEntity academicPeriodEntity = AcademicPeriodConverter
							.ConvertToEntity1(academicPeriodBean);

					if (lastAcademicPeriod != null) {

						String errorMessage = "";

						if (academicPeriodEntity.getInitialDate().before(lastAcademicPeriod.getEndDate())) {

							errorMessage += "La fecha de inicio del periodo academico que quiere registrar \n"
									+ " es menor a la fecha de fin del ultimo periodo academico registrado ("
									+ lastAcademicPeriod.getName() + ") \n";

							jsonResponse.setErrorMessage(errorMessage);
						}

						if (academicPeriodEntity.getEndDate().before(academicPeriodEntity.getInitialDate())) {

							errorMessage += "La fecha de fin del periodo academico que quiere registrar \n"
									+ " es menor a la fecha de inicio del periodo academico que quiere registrar";

							jsonResponse.setErrorMessage(errorMessage);

						}

						if (jsonResponse.getErrorMessage() == null) {

							academicPeriodDaoInterface.create(academicPeriodEntity);

							jsonResponse.setSuccessMessage("El periodo academico ha sido guardado con exito");

						}

					} else {

						if (academicPeriodEntity.getEndDate().before(academicPeriodEntity.getInitialDate())) {

							jsonResponse.setErrorMessage("La fecha de fin del periodo academico que quiere registrar \n"
									+ " es menor a la fecha de inicio del periodo academico que quiere registrar");

						} else {

							academicPeriodDaoInterface.create(academicPeriodEntity);

							jsonResponse.setSuccessMessage("El periodo academico ha sido guardado con exito");

						}

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

	@Transactional
	@Override
	public JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> update(AcademicPeriodBean academicPeriodBean,
			BindingResult bindingResult) {

		try {

			JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> jsonResponse = new JsonResponse<AcademicPeriodBean, AcademicPeriodEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				jsonResponse.setIsValid(true);

				Optional<AcademicPeriodEntity> academicPeriod = academicPeriodDaoInterface
						.findByName(academicPeriodBean.getName());
				
				if (academicPeriod.isPresent() && academicPeriod.get().getAcademicPeriodId() != Integer.parseInt(academicPeriodBean.getAcademicPeriodId())) {

						jsonResponse.setErrorMessage("El periodo academico que se quiere modificar ya existe");

				} else {

					String academicPeriodYear = academicPeriodBean.getName().split("-")[0];

					List<AcademicPeriodEntity> academicPeriods = academicPeriodDaoInterface
							.findByYear(academicPeriodYear);

					AcademicPeriodEntity academicPeriodEntity = AcademicPeriodConverter
							.ConvertToEntity2(academicPeriodBean);

					
					if (academicPeriods.size() > 0) {

						String errorMessage = "";

						for (int i = 0; i < academicPeriods.size(); i++) {
						
							if (academicPeriodEntity.getAcademicPeriodId() == academicPeriods.get(i).getAcademicPeriodId()) {

								if (i + 1 < academicPeriods.size()) {

									if (academicPeriods.get(i + 1) != null) {
										
										if (academicPeriodEntity.getEndDate()
												.after(academicPeriods.get(i + 1).getInitialDate())) {

											errorMessage += "La fecha de fin del periodo academico que quiere modificar"
													+ " es mayor a la fecha de inicio del periodo academico \n despues registrado ("
													+ academicPeriods.get(i + 1).getName() + ") \n";

											jsonResponse.setErrorMessage(errorMessage);

										}

									}

								}

								if (i - 1 >= 0) {

									if (academicPeriods.get(i - 1) != null) {
										
										if (academicPeriodEntity.getInitialDate()
												.before(academicPeriods.get(i - 1).getEndDate())) {

											errorMessage += "La fecha de inicio del periodo academico que quiere modificar"
													+ " es menor a la fecha de fin del periodo academico \n antes registrado ("
													+ academicPeriods.get(i - 1).getName() + ") \n";

											jsonResponse.setErrorMessage(errorMessage);

										}

									}

								}

								break;

							}

						}

						if (academicPeriodEntity.getEndDate().before(academicPeriodEntity.getInitialDate())) {
							
							errorMessage += "La fecha de fin del periodo academico que quiere modificar \n"
									+ " es menor a la fecha de inicio del periodo academico que quiere modificar";

							jsonResponse.setErrorMessage(errorMessage);

						}
						
						if (jsonResponse.getErrorMessage() == null) {

							academicPeriodDaoInterface.update(academicPeriodEntity);

							jsonResponse.setSuccessMessage("El periodo academico ha sido modificado con exito");

						}

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

	@Transactional
	@Override
	public JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> search(AcademicPeriodBean academicPeriodBean,
			BindingResult bindingResult) {

		try {

			JsonResponse<AcademicPeriodBean, AcademicPeriodEntity> jsonResponse = new JsonResponse<AcademicPeriodBean, AcademicPeriodEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				jsonResponse.setIsValid(true);

				AcademicPeriodEntity academicPeriod = academicPeriodDaoJpaRepository
						.findByName(academicPeriodBean.getName());

				if (academicPeriod == null) {

					jsonResponse.setErrorMessage("No se encontraron resultados para la busqueda");

				} else {

					jsonResponse.setObjectEntity(academicPeriod);

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

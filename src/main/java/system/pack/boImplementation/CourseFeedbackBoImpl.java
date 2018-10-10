package system.pack.boImplementation;




import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import system.pack.bointerface.CourseFeedbackBoInterface;
import system.pack.converter.CourseFeedbackConverter;
import system.pack.daoInterface.CourseFeedbackDaoInterface;
import system.pack.daoInterface.CourseFeedbackDaoJpaRepository;
import system.pack.daoInterface.FeedbackTypeDaoJpaRepository;
import system.pack.daoInterface.CourseDaoInterface;
import system.pack.daoInterface.CourseDaoJpaRepository;

import system.pack.entity.CourseFeedbackEntity;
import system.pack.entity.FeedbackTypeEntity;
import system.pack.entity.UserEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.CourseFeedbackBean;


@Service
public class CourseFeedbackBoImpl implements CourseFeedbackBoInterface {

	@Autowired
	CourseFeedbackDaoInterface courseFeedbackDaoInterface;
	
	@Autowired
	CourseFeedbackDaoJpaRepository courseFeedbackDaoJpaRepository;	

	@Autowired
	CourseDaoInterface courseDaoInterface;
	
	@Autowired
	CourseDaoJpaRepository courseDaoJpaRepository;
	
	@Autowired
	FeedbackTypeDaoJpaRepository feedbackTypeDaoJpaRepository;
	
	
	@Transactional
	@Override
	public JsonResponse<CourseFeedbackBean, CourseFeedbackEntity> update(CourseFeedbackBean courseFeedbackBean, BindingResult bindingResult, HttpSession session) {

		try {

			JsonResponse<CourseFeedbackBean, CourseFeedbackEntity> jsonResponse = new JsonResponse<CourseFeedbackBean, CourseFeedbackEntity>();

			if (bindingResult.hasErrors()) {

				Map<String, String> errorMessages = bindingResult.getFieldErrors().stream()
						.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));

				jsonResponse.setErrorMessages(errorMessages);

				jsonResponse.setIsValid(false);

			} else {

				jsonResponse.setIsValid(true);

				CourseFeedbackEntity courseFeedbackEntity = courseFeedbackDaoJpaRepository.findById(Integer.parseInt(courseFeedbackBean.getCourseFeedBackId()));

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String lastModifiedDatetoString = sdf.format(new Date());
				Date lastModifiedDate = sdf.parse(lastModifiedDatetoString);

				courseFeedbackEntity.setUser(new UserEntity(Integer.parseInt(session.getAttribute("UserId").toString())));
				courseFeedbackEntity.setLastModifiedDate(lastModifiedDate);
				courseFeedbackEntity.setComment(courseFeedbackBean.getComment());
				
				courseFeedbackDaoJpaRepository.save(courseFeedbackEntity);

				jsonResponse.setSuccessMessage("La retroalimentacion del curso ha sido modificada con exito");

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

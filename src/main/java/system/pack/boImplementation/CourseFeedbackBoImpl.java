package system.pack.boImplementation;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;



import system.pack.bointerface.CourseFeedbackBoInterface;
import system.pack.daoInterface.CourseFeedbackDaoInterface;
import system.pack.daoInterface.CourseFeedbackDaoJpaRepository;
import system.pack.daoInterface.CourseDaoInterface;
import system.pack.daoInterface.CourseDaoJpaRepository;

import system.pack.entity.CourseFeedbackEntity;

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
	
	
	
	@Transactional
	@Override
	public JsonResponse<CourseFeedbackBean, CourseFeedbackEntity> update(CourseFeedbackBean courseFeedbackBean, BindingResult bindingResult) {

		JsonResponse<CourseFeedbackBean, CourseFeedbackEntity> jsonResponse = new JsonResponse<CourseFeedbackBean, CourseFeedbackEntity>();

		return jsonResponse;

	}
	
	
	
	}

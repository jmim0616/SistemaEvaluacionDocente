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
import system.pack.bointerface.QuestionByPeriodBoInterface;
import system.pack.bointerface.TeacherBoInterface;
import system.pack.converter.TeacherConverter;
import system.pack.daoInterface.AcademicPeriodDaoInterface;
import system.pack.daoInterface.AcademicPeriodDaoJpaRepository;
import system.pack.daoInterface.CourseFeedbackDaoInterface;
import system.pack.daoInterface.CourseFeedbackDaoJpaRepository;
import system.pack.daoInterface.CourseDaoInterface;
import system.pack.daoInterface.CourseDaoJpaRepository;
import system.pack.daoInterface.DepartmentDaoInterface;
import system.pack.daoInterface.DepartmentDaoJpaRepository;
import system.pack.daoInterface.QuestionDaoInterface;
import system.pack.daoInterface.QuestionDaoJpaRepository;
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
import system.pack.entity.QuestionByPeriodEntity;
import system.pack.entity.QuestionEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.helper.JsonResponse;
import system.pack.vo.CourseFeedbackBean;
import system.pack.vo.CourseBean;
import system.pack.vo.QuestionByPeriodBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.SubjectByProgramBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;

@Service
public class QuestionByPeriodBoImpl implements QuestionByPeriodBoInterface {
	
	@Autowired
	CourseDaoInterface courseDaoInterface;
	
	@Autowired
	CourseDaoJpaRepository courseDaoJpaRepository;
	
	@Autowired
	QuestionDaoInterface questionDaoInterface;
	
	@Autowired
	QuestionDaoJpaRepository questionDaoJpaRepository;
	
	@Autowired
	DepartmentDaoInterface departmentDaoInterface;
	
	@Autowired
	DepartmentDaoJpaRepository departmentDaoJpaRepository;
	
	@Autowired
	AcademicPeriodDaoInterface academicPeriodDaoInterface;
	
	@Autowired
	AcademicPeriodDaoJpaRepository academicPeriodDaoJpaRepository;


	@Transactional
	@Override
	public JsonResponse<QuestionByPeriodBean, QuestionByPeriodEntity> create(QuestionByPeriodBean questionByPeriodBean, BindingResult bindingResult) {
		
		try {

			JsonResponse<QuestionByPeriodBean, QuestionByPeriodEntity> jsonResponse = new JsonResponse<QuestionByPeriodBean, QuestionByPeriodEntity>();

			
			return jsonResponse;

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

//			throw new RuntimeException("");

			return null;
			
		}

	}

}

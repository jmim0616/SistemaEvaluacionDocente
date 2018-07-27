package system.pack.converter;

import java.sql.Date;

import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.CoevaluationEntity;
import system.pack.entity.CourseEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.vo.CoevaluationBean;
import system.pack.vo.CourseBean;

public class CoevaluationConverter {

	public CoevaluationConverter() {

	}

	public static CoevaluationBean ConverToVO(CoevaluationEntity coevaluationEntity) {
		
		CoevaluationBean coevaluationBean = new CoevaluationBean();
		
		coevaluationBean.setCoevaluationId(Integer.toString(coevaluationEntity.getCoevaluationId()));
		coevaluationBean.setCourse(Integer.toString(coevaluationEntity.getCourse().getCourseId()));
		coevaluationBean.setDate(coevaluationEntity.getDate().toString());
		coevaluationBean.setComment(coevaluationEntity.getComment());
		
		return coevaluationBean;
	}

	public static CoevaluationEntity ConvertToEntity1(CoevaluationBean coevaluationBean) {
		
		CoevaluationEntity coevaluationEntity = new CoevaluationEntity();

		coevaluationEntity.setCourse(new CourseEntity(Integer.parseInt(coevaluationBean.getCourse())));
		coevaluationEntity.setDate(Date.valueOf(coevaluationBean.getDate().toString()));
		coevaluationEntity.setComment(coevaluationBean.getComment());
		
		return coevaluationEntity;

	}
	
	
	public static CoevaluationEntity ConvertToEntity2(CoevaluationBean coevaluationBean) {
		
		CoevaluationEntity coevaluationEntity = new CoevaluationEntity();
		
		coevaluationEntity.setCoevaluationId(Integer.parseInt(coevaluationBean.getCoevaluationId()));
		coevaluationEntity.setCourse(new CourseEntity(Integer.parseInt(coevaluationBean.getCourse())));
		coevaluationEntity.setDate(Date.valueOf(coevaluationBean.getDate().toString()));
		coevaluationEntity.setComment(coevaluationBean.getComment());
		
		return coevaluationEntity;

	}
	
}

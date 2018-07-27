package system.pack.converter;

import java.sql.Date;

import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.ClassVisitEntity;
import system.pack.entity.CoevaluationEntity;
import system.pack.entity.CourseEntity;

import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.vo.ClassVisitBean;
import system.pack.vo.CoevaluationBean;
import system.pack.vo.CourseBean;



public class ClassVisitConverter {
	
	public ClassVisitConverter() {

	}

public static ClassVisitBean ConverToVO(ClassVisitEntity classVisitEntity) {
		
	ClassVisitBean classVisitBean = new ClassVisitBean();
		
	classVisitBean.setClassVisitId(Integer.toString(classVisitEntity.getClassVisitId()));
	classVisitBean.setCourse(Integer.toString(classVisitEntity.getCourse().getCourseId()));
	classVisitBean.setDate(classVisitEntity.getDate().toString());
	classVisitBean.setComment(classVisitEntity.getComment());
		
		return classVisitBean;
	}

	public static ClassVisitEntity ConvertToEntity1(ClassVisitBean classVisitBean) {
		
		ClassVisitEntity classVisitEntity = new ClassVisitEntity();

		classVisitEntity.setCourse(new CourseEntity(Integer.parseInt(classVisitBean.getCourse())));
		classVisitEntity.setDate(Date.valueOf(classVisitBean.getDate().toString()));
		classVisitEntity.setComment(classVisitBean.getComment());
		
		return classVisitEntity;

	}
	
	
	public static ClassVisitEntity ConvertToEntity2(ClassVisitBean classVisitBean) {
		
		ClassVisitEntity classVisitEntity = new ClassVisitEntity();

		classVisitEntity.setClassVisitId(Integer.parseInt(classVisitBean.getClassVisitId()));
		classVisitEntity.setCourse(new CourseEntity(Integer.parseInt(classVisitBean.getCourse())));
		classVisitEntity.setDate(Date.valueOf(classVisitBean.getDate().toString()));
		classVisitEntity.setComment(classVisitBean.getComment());
		
		return classVisitEntity;

	}
	
	
}

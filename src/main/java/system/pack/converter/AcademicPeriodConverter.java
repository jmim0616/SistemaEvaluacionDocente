package system.pack.converter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.vo.AcademicPeriodBean;
import system.pack.vo.DepartmentBean;
import system.pack.vo.TeacherBean;


public class AcademicPeriodConverter {
	
	public AcademicPeriodConverter() {

	}

	public static AcademicPeriodBean ConverToVO(AcademicPeriodEntity academicPeriodEntity) {
		
		AcademicPeriodBean academicPeriodBean = new AcademicPeriodBean();
		
		academicPeriodBean.setAcademicPeriodId(Integer.toString(academicPeriodEntity.getAcademicPeriodId()));
		academicPeriodBean.setName(academicPeriodEntity.getName());
		academicPeriodBean.setInitialDate((academicPeriodEntity.getInitialDate().toString()));
		academicPeriodBean.setEndDate((academicPeriodEntity.getEndDate().toString()));
		
		return academicPeriodBean;
	}

	public static AcademicPeriodEntity ConvertToEntity1(AcademicPeriodBean academicPeriodBean) {
		
		AcademicPeriodEntity academicPeriodEntity = new AcademicPeriodEntity();
		
		academicPeriodEntity.setName(academicPeriodBean.getName());
		academicPeriodEntity.setInitialDate(Date.valueOf(academicPeriodBean.getInitialDate()));
		academicPeriodEntity.setEndDate(Date.valueOf(academicPeriodBean.getEndDate()));
		
		return academicPeriodEntity;

	}
	
	public static AcademicPeriodEntity ConvertToEntity2(AcademicPeriodBean academicPeriodBean) {
		
		AcademicPeriodEntity academicPeriodEntity = new AcademicPeriodEntity();
		
		academicPeriodEntity.setAcademicPeriodId(Integer.parseInt(academicPeriodBean.getAcademicPeriodId()));
		academicPeriodEntity.setName(academicPeriodBean.getName());
		academicPeriodEntity.setInitialDate(Date.valueOf(academicPeriodBean.getInitialDate()));
		academicPeriodEntity.setEndDate(Date.valueOf(academicPeriodBean.getEndDate()));
		
		return academicPeriodEntity;

	}
	
}

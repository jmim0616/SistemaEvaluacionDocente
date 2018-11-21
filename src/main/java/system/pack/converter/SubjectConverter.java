package system.pack.converter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.DisciplinaryAreaEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.SubjectStatusEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.vo.AcademicPeriodBean;
import system.pack.vo.DepartmentBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.TeacherBean;


public class SubjectConverter {
	
	public SubjectConverter() {

	}

	public static SubjectBean ConverToVO(SubjectEntity subjectEntity) {
		
		SubjectBean subjectBean = new SubjectBean();
		
		subjectBean.setSubjectId(Integer.toString(subjectEntity.getSubjectId()));
		subjectBean.setSubjectStatus((subjectEntity.getSubjectStatus().getStatus()));
		subjectBean.setDisciplinaryArea((subjectEntity.getDisciplinaryArea().getName()));
		subjectBean.setName(subjectEntity.getName());
		subjectBean.setNumberOfCredits(Integer.toString(subjectEntity.getNumberOfCredits()));
		
		return subjectBean;
	}

	public static SubjectEntity ConvertToEntity1(SubjectBean subjectBean) {
		
		SubjectEntity subjectEntity = new SubjectEntity();
		
		subjectEntity.setSubjectId(Integer.parseInt(subjectBean.getSubjectId()));
		subjectEntity.setSubjectStatus(new SubjectStatusEntity(Integer.parseInt(subjectBean.getSubjectStatus())));
		subjectEntity.setDisciplinaryArea(new DisciplinaryAreaEntity(Integer.parseInt(subjectBean.getDisciplinaryArea())));
		subjectEntity.setName(subjectBean.getName());
		subjectEntity.setNumberOfCredits(Integer.parseInt(subjectBean.getNumberOfCredits()));
		
		return subjectEntity;

	}
	
	public static SubjectEntity ConvertToEntity2(SubjectBean subjectBean) {
		
		SubjectEntity subjectEntity = new SubjectEntity();
		
		subjectEntity.setSubjectId(Integer.parseInt(subjectBean.getSubjectId()));
		subjectEntity.setSubjectStatus(new SubjectStatusEntity(Integer.parseInt(subjectBean.getSubjectStatus())));
		subjectEntity.setDisciplinaryArea(new DisciplinaryAreaEntity(Integer.parseInt(subjectBean.getDisciplinaryArea())));
		subjectEntity.setName(subjectBean.getName());
		subjectEntity.setNumberOfCredits(Integer.parseInt(subjectBean.getNumberOfCredits()));
		
		return subjectEntity;

	}
	
}

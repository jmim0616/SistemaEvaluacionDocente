package system.pack.converter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.DisciplinaryAreaEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.SubjectStatusEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.vo.AcademicPeriodBean;
import system.pack.vo.DepartmentBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;


public class SubjectByTeacherConverter {
	
	public SubjectByTeacherConverter() {

	}

	public static SubjectByTeacherBean ConverToVO(SubjectByTeacherEntity subjectByTeacherEntity) {
		
		SubjectByTeacherBean subjectByTeacherBean = new SubjectByTeacherBean();
		
		subjectByTeacherBean.setSubjectByTeacherId(Integer.toString(subjectByTeacherEntity.getSubjectByTeacherId()));
		subjectByTeacherBean.setSubject(subjectByTeacherEntity.getSubject().getName());
		subjectByTeacherBean.setTeacher(subjectByTeacherEntity.getTeacher().getName());
		
		return subjectByTeacherBean;
	}

	public static SubjectByTeacherEntity ConvertToEntity1(SubjectByTeacherBean subjectByTeacherBean) {
		
		SubjectByTeacherEntity subjectByTeacherEntity = new SubjectByTeacherEntity();
		
		subjectByTeacherEntity.setSubject(new SubjectEntity(Integer.parseInt(subjectByTeacherBean.getSubject())));
		subjectByTeacherEntity.setTeacher(new TeacherEntity(Integer.parseInt(subjectByTeacherBean.getTeacher())));
		
		return subjectByTeacherEntity;

	}
	
	public static SubjectByTeacherEntity ConvertToEntity2(SubjectByTeacherBean subjectByTeacherBean) {
		
		SubjectByTeacherEntity subjectByTeacherEntity = new SubjectByTeacherEntity();
		
		subjectByTeacherEntity.setSubjectByTeacherId(Integer.parseInt(subjectByTeacherBean.getSubjectByTeacherId()));
		subjectByTeacherEntity.setSubject(new SubjectEntity(Integer.parseInt(subjectByTeacherBean.getSubject())));
		subjectByTeacherEntity.setTeacher(new TeacherEntity(Integer.parseInt(subjectByTeacherBean.getTeacher())));
		
		return subjectByTeacherEntity;

	}
	
}

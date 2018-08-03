package system.pack.converter;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.DisciplinaryAreaEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.SubjectByProgramEntity;
import system.pack.entity.SubjectByTeacherEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.SubjectStatusEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.vo.AcademicPeriodBean;
import system.pack.vo.DepartmentBean;
import system.pack.vo.SubjectBean;
import system.pack.vo.SubjectByProgramBean;
import system.pack.vo.SubjectByTeacherBean;
import system.pack.vo.TeacherBean;


public class SubjectByProgramConverter {
	
	public SubjectByProgramConverter() {

	}

	public static SubjectByProgramBean ConverToVO(SubjectByProgramEntity subjectByProgramEntity) {
		
		SubjectByProgramBean subjectByProgramBean = new SubjectByProgramBean();
		
		subjectByProgramBean.setSubjectByProgramId(Integer.toString(subjectByProgramEntity.getSubjectByProgramId()));
		subjectByProgramBean.setAcademicProgram(subjectByProgramEntity.getAcademicProgram().getName());
		subjectByProgramBean.setSubject(subjectByProgramEntity.getSubject().getName());
		
		
		return subjectByProgramBean;
	}

	public static SubjectByProgramEntity ConvertToEntity1(SubjectByProgramBean subjectByProgramBean) {
		
		SubjectByProgramEntity subjectByProgramEntity = new SubjectByProgramEntity();
		
		subjectByProgramEntity.setSubject(new SubjectEntity(Integer.parseInt(subjectByProgramBean.getSubject())));
		subjectByProgramEntity.setAcademicProgram(new AcademicProgramEntity(Integer.parseInt(subjectByProgramBean.getAcademicProgram())));
		
		return subjectByProgramEntity;

	}
	
	public static SubjectByProgramEntity ConvertToEntity2(SubjectByProgramBean subjectByProgramBean) {
		
		SubjectByProgramEntity subjectByProgramEntity = new SubjectByProgramEntity();
		
		subjectByProgramEntity.setSubjectByProgramId(Integer.parseInt(subjectByProgramBean.getSubjectByProgramId()));
		subjectByProgramEntity.setSubject(new SubjectEntity(Integer.parseInt(subjectByProgramBean.getSubject())));
		subjectByProgramEntity.setAcademicProgram(new AcademicProgramEntity(Integer.parseInt(subjectByProgramBean.getAcademicProgram())));
		
		return subjectByProgramEntity;

	}
	
}

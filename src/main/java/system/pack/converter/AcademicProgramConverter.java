package system.pack.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.vo.AcademicProgramBean;
import system.pack.vo.FacultyBean;
import system.pack.vo.TeacherBean;


public class AcademicProgramConverter {
	
	private AcademicProgramConverter() {

	}

	public static AcademicProgramBean ConverToVO(AcademicProgramEntity academicProgramEntity) {
		
		AcademicProgramBean academicProgramBean = new AcademicProgramBean();
		
		academicProgramBean.setAcademicProgramId(Integer.toString(academicProgramEntity.getAcademicProgramId()));
		academicProgramBean.setFaculty(Integer.toString(academicProgramEntity.getFaculty().getFacultyId()));
		academicProgramBean.setName(academicProgramEntity.getName());
		
		return academicProgramBean;
	}

	
	public static AcademicProgramEntity ConvertToEntity1(AcademicProgramBean academicProgramBean) {
		
		AcademicProgramEntity academicProgramEntity = new AcademicProgramEntity(
				new FacultyEntity(Integer.parseInt(academicProgramBean.getFaculty())), 
				academicProgramBean.getName());
		
		return academicProgramEntity;

	}
	
	public static AcademicProgramEntity ConvertToEntity2(AcademicProgramBean academicProgramBean) {
		
		AcademicProgramEntity academicProgramEntity = new AcademicProgramEntity(
				Integer.parseInt(academicProgramBean.getAcademicProgramId()),
				new FacultyEntity(Integer.parseInt(academicProgramBean.getFaculty())), 
				academicProgramBean.getName());
		
		return academicProgramEntity;

	}
	

}

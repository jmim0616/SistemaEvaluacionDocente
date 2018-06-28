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

	public static AcademicProgramEntity ConvertToEntity(AcademicProgramBean academicProgramBean) {
		
		AcademicProgramEntity academicProgramEntity = new AcademicProgramEntity();

		academicProgramEntity.setAcademicProgramId(Integer.parseInt(academicProgramBean.getAcademicProgramId()));
		academicProgramEntity.setFaculty(new FacultyEntity(Integer.parseInt(academicProgramBean.getFaculty())));
		academicProgramEntity.setName(academicProgramBean.getName());
		
		return academicProgramEntity;

	}

}

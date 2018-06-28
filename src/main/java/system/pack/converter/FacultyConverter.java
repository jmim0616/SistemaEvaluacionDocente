package system.pack.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.vo.FacultyBean;
import system.pack.vo.TeacherBean;


public class FacultyConverter {
	
	private FacultyConverter() {

	}

	public static FacultyBean ConverToVO(FacultyEntity facultyEntity) {
		
		FacultyBean facultyBean = new FacultyBean();
		
		facultyBean.setFacultyId(Integer.toString(facultyEntity.getFacultyId()));
		facultyBean.setDepartment(Integer.toString(facultyEntity.getDepartment().getDepartmentId()));
		facultyBean.setName(facultyEntity.getName());
		
		return facultyBean;
	}

	public static FacultyEntity ConvertToEntity(FacultyBean facultyBean) {
		
		FacultyEntity facultyEntity = new FacultyEntity();

		facultyEntity.setFacultyId(Integer.parseInt(facultyBean.getFacultyId()));
		facultyEntity.setDepartment(new DepartmentEntity(Integer.parseInt(facultyBean.getDepartment())));
		facultyEntity.setName(facultyBean.getName());
		
		return facultyEntity;

	}

}

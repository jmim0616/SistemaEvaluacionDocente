package system.pack.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import system.pack.entity.DepartmentEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.vo.DepartmentBean;
import system.pack.vo.TeacherBean;


public class DepartmentConverter {
	
	private DepartmentConverter() {

	}

	public static DepartmentBean ConverToVO(DepartmentEntity departmentEntity) {
		
		DepartmentBean departmentBean = new DepartmentBean();
		
		departmentBean.setDepartmentId(Integer.toString(departmentEntity.getDepartmentId()));
		departmentBean.setFaculty(Integer.toString(departmentEntity.getFaculty().getFacultyId()));
		departmentBean.setName(departmentEntity.getName());

		return departmentBean;
	}

	public static DepartmentEntity ConvertToEntity1(DepartmentBean departmentBean) {
		
		DepartmentEntity departmentEntity = new DepartmentEntity(
				new FacultyEntity(Integer.parseInt(departmentBean.getFaculty())),
				departmentBean.getName());
		
		return departmentEntity;

	}
	
	public static DepartmentEntity ConvertToEntity2(DepartmentBean departmentBean) {
		
		DepartmentEntity departmentEntity = new DepartmentEntity(
				Integer.parseInt(departmentBean.getDepartmentId()),
				new FacultyEntity(Integer.parseInt(departmentBean.getFaculty())),
				departmentBean.getName());
		
		return departmentEntity;

	}

}

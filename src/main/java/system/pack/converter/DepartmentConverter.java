package system.pack.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import system.pack.entity.DepartmentEntity;
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
		departmentBean.setName(departmentEntity.getName());

		return departmentBean;
	}

	public static DepartmentEntity ConvertToEntity1(DepartmentBean departmentBean) {
		
		DepartmentEntity departmentEntity = new DepartmentEntity(departmentBean.getName());
		
		return departmentEntity;

	}
	
	public static DepartmentEntity ConvertToEntity2(DepartmentBean departmentBean) {
		
		DepartmentEntity departmentEntity = new DepartmentEntity(
				Integer.parseInt(departmentBean.getDepartmentId()), 
				departmentBean.getName());
		
		return departmentEntity;

	}

}

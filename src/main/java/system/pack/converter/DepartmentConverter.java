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

	public static DepartmentEntity ConvertToEntity(DepartmentBean departmentBean) {
		
		DepartmentEntity departmentEntity = new DepartmentEntity();

		departmentEntity.setDepartmentId(Integer.parseInt(departmentBean.getDepartmentId()));
		departmentEntity.setName(departmentBean.getName());
		
		return departmentEntity;

	}

}

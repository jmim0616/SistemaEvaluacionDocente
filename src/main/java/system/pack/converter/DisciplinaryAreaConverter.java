package system.pack.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.DepartmentEntity;
import system.pack.entity.DisciplinaryAreaEntity;
import system.pack.entity.FacultyEntity;
import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.vo.AcademicProgramBean;
import system.pack.vo.DisciplinaryAreaBean;
import system.pack.vo.FacultyBean;
import system.pack.vo.TeacherBean;


public class DisciplinaryAreaConverter {
	
	private DisciplinaryAreaConverter() {

	}

	public static DisciplinaryAreaBean ConverToVO(DisciplinaryAreaEntity disciplinaryAreaEntity) {
		
		DisciplinaryAreaBean disciplinaryAreaBean = new DisciplinaryAreaBean();
		
		disciplinaryAreaBean.setDisciplinaryAreaId(Integer.toString(disciplinaryAreaEntity.getDisciplinaryAreaId()));
		disciplinaryAreaBean.setDepartment(Integer.toString(disciplinaryAreaEntity.getDepartment().getDepartmentId()));
		disciplinaryAreaBean.setName(disciplinaryAreaEntity.getName());
		
		return disciplinaryAreaBean;
	}

	public static DisciplinaryAreaEntity ConvertToEntity1(DisciplinaryAreaBean disciplinaryAreaBean) {
		
		DisciplinaryAreaEntity disciplinaryAreaEntity = new DisciplinaryAreaEntity();

		disciplinaryAreaEntity.setDepartment(new DepartmentEntity(Integer.parseInt(disciplinaryAreaBean.getDepartment())));
		disciplinaryAreaEntity.setName(disciplinaryAreaBean.getName());
		
		return disciplinaryAreaEntity;

	}
	
	public static DisciplinaryAreaEntity ConvertToEntity2(DisciplinaryAreaBean disciplinaryAreaBean) {
		
		DisciplinaryAreaEntity disciplinaryAreaEntity = new DisciplinaryAreaEntity();

		disciplinaryAreaEntity.setDisciplinaryAreaId(Integer.parseInt(disciplinaryAreaBean.getDisciplinaryAreaId()));
		disciplinaryAreaEntity.setDepartment(new DepartmentEntity(Integer.parseInt(disciplinaryAreaBean.getDepartment())));
		disciplinaryAreaEntity.setName(disciplinaryAreaBean.getName());
		
		return disciplinaryAreaEntity;

	}

}

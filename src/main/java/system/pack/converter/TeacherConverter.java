package system.pack.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import system.pack.entity.TeacherEntity;
import system.pack.entity.TeacherStatusEntity;
import system.pack.vo.TeacherBean;


public class TeacherConverter {
	
	private TeacherConverter() {

	}

	public static TeacherBean ConverToVO(TeacherEntity teacherEntity) {
		
		TeacherBean teacherBean = new TeacherBean();
		
		teacherBean.setTeacherId(Integer.toString(teacherEntity.getTeacherId()));
		teacherBean.setTeacherStatus(teacherEntity.getTeacherStatus().getStatus());
		teacherBean.setName(teacherEntity.getName());
		teacherBean.setLastName(teacherEntity.getLastName());
		teacherBean.setIdentificationType(Integer.toString(teacherEntity.getIdentificationType()));
		teacherBean.setUnderDegree(teacherEntity.getUnderDegree());
		teacherBean.setMasterDegree(teacherEntity.getMasterDegree());
		teacherBean.setDoctorDegree(teacherEntity.getDoctorDegree());
		teacherBean.setInstitutionalMail(teacherEntity.getInstitutionalMail());
		teacherBean.setPersonalMail(teacherEntity.getPersonalMail());
		teacherBean.setCellNumber(Integer.toString(teacherEntity.getCellNumber()));
		teacherBean.setHomeNumber(Integer.toString(teacherEntity.getHomeNumber()));
		teacherBean.setExperience(teacherEntity.getExperience());

		
		return teacherBean;
	}

	public static TeacherEntity ConvertToEntity(TeacherBean teacherBean) {
		
		TeacherEntity teacherEntity = new TeacherEntity();

		teacherEntity.setTeacherId(Integer.parseInt(teacherBean.getTeacherId()));
		teacherEntity.setTeacherStatus(new TeacherStatusEntity(Integer.parseInt(teacherBean.getTeacherStatus())));
		teacherEntity.setName(teacherBean.getName());
		teacherEntity.setLastName(teacherBean.getLastName());
		teacherEntity.setIdentificationType(Integer.parseInt(teacherBean.getIdentificationType()));
		teacherEntity.setUnderDegree(teacherBean.getUnderDegree());
		teacherEntity.setMasterDegree(teacherBean.getMasterDegree());
		teacherEntity.setDoctorDegree(teacherBean.getDoctorDegree());
		teacherEntity.setInstitutionalMail(teacherBean.getInstitutionalMail());
		teacherEntity.setPersonalMail(teacherBean.getPersonalMail());
		teacherEntity.setCellNumber(teacherBean.getCellNumber().equals("") ?  0 : Integer.parseInt(teacherBean.getCellNumber()));
		teacherEntity.setHomeNumber(teacherBean.getCellNumber().equals("") ?  0 : Integer.parseInt(teacherBean.getHomeNumber()));
		teacherEntity.setExperience(teacherBean.getExperience());
		
		return teacherEntity;

	}

}

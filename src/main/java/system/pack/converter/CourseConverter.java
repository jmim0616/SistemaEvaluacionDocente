package system.pack.converter;

import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.CourseEntity;

import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;
import system.pack.vo.CourseBean;



public class CourseConverter {
	
	public CourseConverter() {

	}

	public static CourseBean ConverToVO(CourseEntity courseEntity) {
		
		CourseBean courseBean = new CourseBean();
		
		courseBean.setCourseId(Integer.toString(courseEntity.getCourseId()));
		courseBean.setAcademicPeriod(Integer.toString(courseEntity.getAcademicPeriod().getAcademicPeriodId()));
		courseBean.setTeacher(Integer.toString(courseEntity.getTeacher().getTeacherId()));
		courseBean.setSubject(Integer.toString(courseEntity.getSubject().getSubjectId()));
		courseBean.setGroupId(Integer.toString(courseEntity.getGroupId()));
		courseBean.setIsVirtual(courseEntity.getIsVirtual());
		
		return courseBean;
	}

	public static CourseEntity ConvertToEntity1(CourseBean courseBean) {
		
		CourseEntity courseEntity = new CourseEntity();
		
		courseEntity.setAcademicPeriod(new AcademicPeriodEntity(Integer.parseInt(courseBean.getAcademicPeriod())));
		courseEntity.setTeacher(new TeacherEntity(Integer.parseInt(courseBean.getTeacher())));
		courseEntity.setSubject(new SubjectEntity(Integer.parseInt(courseBean.getSubject())));
		courseEntity.setGroupId(Integer.parseInt(courseBean.getGroupId()));
		courseEntity.setIsVirtual(courseEntity.getIsVirtual());
		
		return courseEntity;

	}
	
	
	public static CourseEntity ConvertToEntity2(CourseBean courseBean) {
		
		CourseEntity courseEntity = new CourseEntity();
		
		courseEntity.setCourseId(Integer.parseInt(courseBean.getCourseId()));
		courseEntity.setAcademicPeriod(new AcademicPeriodEntity(Integer.parseInt(courseBean.getAcademicPeriod())));
		courseEntity.setTeacher(new TeacherEntity(Integer.parseInt(courseBean.getTeacher())));
		courseEntity.setSubject(new SubjectEntity(Integer.parseInt(courseBean.getSubject())));
		courseEntity.setGroupId(Integer.parseInt(courseBean.getGroupId()));
		courseEntity.setIsVirtual(courseEntity.getIsVirtual());
		
		return courseEntity;

	}
	
}

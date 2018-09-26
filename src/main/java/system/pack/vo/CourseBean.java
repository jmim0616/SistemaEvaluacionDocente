package system.pack.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import system.pack.entity.AcademicPeriodEntity;
import system.pack.entity.SubjectEntity;
import system.pack.entity.TeacherEntity;

public class CourseBean {

	
	private String courseId;
	
	@Pattern(regexp = "^[0-9]{4}\\-[0-9]{1}", message = "El campo \"Periodo Academico\" no cumple el formato adecuado. Ej: 2018-1")
	private String academicPeriod;
	
	@Pattern(regexp = "^[a-zA-Z-][a-zA-Z -]*$", message = "El campo \"Profesor\" debe ser diligenciado solo con letras")
	private String teacher;
	
	@Pattern(regexp = "^[a-zA-Z-][a-zA-Z -]*$", message = "El campo \"Asignatura\" debe ser diligenciado solo con letras")
	private String subject;

	@NotEmpty(message = "El campo \"Identificador de Grupo\" es requerido")
	@Pattern(regexp = "^[0-9]*$", message = "En el campo \"Identificador de Grupo\" solo se permiten numeros")
	private String groupId;
	
	private String isVirtual;
	
	
	public CourseBean() {

	}
	
	public CourseBean(String groupId) {
		
		this.groupId = groupId;

	}

	public CourseBean(String courseId, String academicPeriod, String teacher, String subject, String groupId,
			String isVirtual) {
		this.courseId = courseId;
		this.academicPeriod = academicPeriod;
		this.teacher = teacher;
		this.subject = subject;
		this.groupId = groupId;
		this.isVirtual = isVirtual;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getAcademicPeriod() {
		return academicPeriod;
	}

	public void setAcademicPeriod(String academicPeriod) {
		this.academicPeriod = academicPeriod;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getIsVirtual() {
		return isVirtual;
	}

	public void setIsVirtual(String isVirtual) {
		this.isVirtual = isVirtual;
	}

	@Override
	public String toString() {
		return "CourseBean [courseId=" + courseId + ", academicPeriod=" + academicPeriod + ", teacher=" + teacher
				+ ", subject=" + subject + ", groupId=" + groupId + ", isVirtual=" + isVirtual + "]";
	}
	
	
	
	
}

package system.pack.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import system.pack.entity.CourseEntity;

public class ClassVisitBean {


	private String classVisitId;
	
	private String course;
	
	@Pattern(regexp="\\d{4}\\-\\d{2}\\-\\d{2}", message="El campo \"Fecha\" no cumple el formato adecuado. Ejm: dd/mm/yyyy")
	private String date;

	@NotEmpty(message="El campo \"comentario\" es requerido")
	private String comment;
	
	
	public ClassVisitBean() {

	}

	public ClassVisitBean(String classVisitId, String course, String date, String comment) {
		this.classVisitId = classVisitId;
		this.course = course;
		this.date = date;
		this.comment = comment;
	}

	public String getClassVisitId() {
		return classVisitId;
	}

	public void setClassVisitId(String classVisitId) {
		this.classVisitId = classVisitId;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "ClassVisitBean [classVisitId=" + classVisitId + ", course=" + course + ", date=" + date + ", comment="
				+ comment + "]";
	}
	
	
	
}

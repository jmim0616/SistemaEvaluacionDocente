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
import system.pack.entity.FeedbackTypeEntity;
import system.pack.entity.UserEntity;

public class CourseFeedbackBean {

	private String courseFeedBackId;

	private String user;
	
	private String feedBackType;
	
	private String course;
	
	@Pattern(regexp="\\d{4}\\-\\d{2}\\-\\d{2}", message="El campo \"Fecha de Creacion\" no cumple el formato adecuado. Ejm: dd/mm/yyyy")
	private String creationDate;
	
	@NotEmpty(message="El campo \"comentario\" es requerido")
	private String comment;
	
	private String lastModifiedDate;

	
	public CourseFeedbackBean() {

	}
	
	public CourseFeedbackBean(String course) {

		this.course = course;

	}
	
	public CourseFeedbackBean(String courseFeedBackId, String user, String feedBackType, String course,
			String creationDate, String comment, String lastModifiedDate) {

		this.courseFeedBackId = courseFeedBackId;
		this.user = user;
		this.feedBackType = feedBackType;
		this.course = course;
		this.creationDate = creationDate;
		this.comment = comment;
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getCourseFeedBackId() {
		return courseFeedBackId;
	}

	public void setCourseFeedBackId(String courseFeedBackId) {
		this.courseFeedBackId = courseFeedBackId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getFeedBackType() {
		return feedBackType;
	}

	public void setFeedBackType(String feedBackType) {
		this.feedBackType = feedBackType;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	
	@Override
	public String toString() {
		return "CoevaluationBean [courseFeedBackId=" + courseFeedBackId + ", user=" + user + ", feedBackType="
				+ feedBackType + ", course=" + course + ", creationDate=" + creationDate + ", comment=" + comment
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}
	
	
}
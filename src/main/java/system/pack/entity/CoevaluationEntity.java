package system.pack.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="coevaluations")
public class CoevaluationEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int coevaluationId;
	
	@ManyToOne
	@JoinColumn(name="courseId")
	private CourseEntity course;
	
	@Column
	private Date date;
	
	@Column
	private String comment;
	
	public CoevaluationEntity() {
		
	}
	
	public CoevaluationEntity(int coevaluationId) {
		this.coevaluationId = coevaluationId;
	}
	
	public CoevaluationEntity(CourseEntity course, Date date, String comment) {
		this.course = course;
		this.date = date;
		this.comment = comment;
	}
	

	public CoevaluationEntity(int coevaluationId, CourseEntity course, Date date, String comment) {
		this.coevaluationId = coevaluationId;
		this.course = course;
		this.date = date;
		this.comment = comment;
	}

	public int getCoevaluationId() {
		return coevaluationId;
	}

	public void setCoevaluationId(int coevaluationId) {
		this.coevaluationId = coevaluationId;
	}

	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
		return "CoevaluationEntity [coevaluationId=" + coevaluationId + ", course=" + course + ", date=" + date
				+ ", comment=" + comment + "]";
	}
	
	
	
	
	
	
}

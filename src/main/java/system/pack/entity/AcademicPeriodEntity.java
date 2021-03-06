package system.pack.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="academic_periods")
public class AcademicPeriodEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int academicPeriodId;
	
	@Column
	private String name;
	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date initialDate;
	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date endDate; 
	
	@OneToMany(mappedBy="academicPeriod")
	@JsonIgnore
	private List<QuestionByPeriodEntity> questions;
	
	@OneToMany(mappedBy="academicPeriod")
	@JsonIgnore
	private List<CourseEntity> courses;
	
	
	public AcademicPeriodEntity() {
		
	}

	public AcademicPeriodEntity(int academicPeriodId) {
		this.academicPeriodId = academicPeriodId;
	}

	public AcademicPeriodEntity(String name, Date initialDate, Date endDate) {
		this.name = name;
		this.initialDate = initialDate;
		this.endDate = endDate;
	}
	
	public AcademicPeriodEntity(int academicPeriodId, String name, Date initialDate, Date endDate) {
		this.academicPeriodId = academicPeriodId;
		this.name = name;
		this.initialDate = initialDate;
		this.endDate = endDate;
	}

	public int getAcademicPeriodId() {
		return academicPeriodId;
	}

	public void setAcademicPeriodId(int academicPeriodId) {
		this.academicPeriodId = academicPeriodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public List<QuestionByPeriodEntity> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionByPeriodEntity> questions) {
		this.questions = questions;
	}

	public List<CourseEntity> getCourses() {
		return courses;
	}

	public void setCourses(List<CourseEntity> courses) {
		this.courses = courses;
	}

	
	@Override
	public String toString() {
		return "AcademicPeriodEntity [academicPeriodId=" + academicPeriodId + ", name=" + name + ", initialDate="
				+ initialDate + ", endDate=" + endDate + "]";
	}
	
	
}

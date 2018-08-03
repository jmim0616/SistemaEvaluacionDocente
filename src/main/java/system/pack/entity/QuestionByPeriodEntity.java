package system.pack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="questions_by_period")
public class QuestionByPeriodEntity {
	
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionsByPeriodId;
	
	@ManyToOne
	@JoinColumn(name="departmentId")
	private DepartmentEntity department;
	
	@ManyToOne
	@JoinColumn(name="courseId")
	private CourseEntity course;
	
	@ManyToOne
	@JoinColumn(name="questionId")
	private QuestionEntity question;
	
	@ManyToOne
	@JoinColumn(name="academicPeriodId")
	private AcademicPeriodEntity academicPeriod;
	
	@Column
	private int percentage;

	public QuestionByPeriodEntity() {

	}
	
	public QuestionByPeriodEntity(int questionsByPeriodId) {
		this.questionsByPeriodId = questionsByPeriodId;

	}

	public QuestionByPeriodEntity(DepartmentEntity department, CourseEntity course,
			QuestionEntity question, AcademicPeriodEntity academicPeriod, int percentage) {
		this.department = department;
		this.course = course;
		this.question = question;
		this.academicPeriod = academicPeriod;
		this.percentage = percentage;
	}
	
	public QuestionByPeriodEntity(int questionsByPeriodId, DepartmentEntity department, CourseEntity course,
			QuestionEntity question, AcademicPeriodEntity academicPeriod, int percentage) {
		this.questionsByPeriodId = questionsByPeriodId;
		this.department = department;
		this.course = course;
		this.question = question;
		this.academicPeriod = academicPeriod;
		this.percentage = percentage;
	}

	public int getQuestionsByPeriodId() {
		return questionsByPeriodId;
	}

	public void setQuestionsByPeriodId(int questionsByPeriodId) {
		this.questionsByPeriodId = questionsByPeriodId;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	public QuestionEntity getQuestion() {
		return question;
	}

	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}

	public AcademicPeriodEntity getAcademicPeriod() {
		return academicPeriod;
	}

	public void setAcademicPeriod(AcademicPeriodEntity academicPeriod) {
		this.academicPeriod = academicPeriod;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	
	@Override
	public String toString() {
		return "QuestionByPeriodEntity [questionsByPeriodId=" + questionsByPeriodId + ", department=" + department
				+ ", course=" + course + ", question=" + question + ", academicPeriod=" + academicPeriod
				+ ", percentage=" + percentage + "]";
	}
	

	
}
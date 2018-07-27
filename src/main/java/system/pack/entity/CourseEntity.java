package system.pack.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="courses")
public class CourseEntity {

	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	
	@ManyToOne
	@JoinColumn(name="academicPeriodId")
	private AcademicPeriodEntity academicPeriod;
	
	@ManyToOne
	@JoinColumn(name=" teacherId")
	private TeacherEntity teacher;
	
	@ManyToOne
	@JoinColumn(name="subjectId")
	private SubjectEntity subject;
	
	@Column
	private int groupId;
	
	@Column
	private String isVirtual;
	
	@OneToMany(mappedBy="course")
	@JsonIgnore
	private List<ClassVisitEntity> classVisits;
	
	@OneToMany(mappedBy="course")
	@JsonIgnore
	private List<CoevaluationEntity> coevaluations;
	
	@OneToMany(mappedBy="course")
	@JsonIgnore
	private List<QuestionByPeriodEntity> questionsByPeriod;

	
	public CourseEntity() {

	}
	
	public CourseEntity(int courseId) {
		this.courseId = courseId;

	}
	
	public CourseEntity(AcademicPeriodEntity academicPeriod, TeacherEntity teacher, SubjectEntity subject,
			int groupId, String isVirtual) {
		this.academicPeriod = academicPeriod;
		this.teacher = teacher;
		this.subject = subject;
		this.groupId = groupId;
		this.isVirtual = isVirtual;
	}
	
	
	public CourseEntity(int courseId, AcademicPeriodEntity academicPeriod, TeacherEntity teacher, SubjectEntity subject,
			int groupId, String isVirtual) {
		this.courseId = courseId;
		this.academicPeriod = academicPeriod;
		this.teacher = teacher;
		this.subject = subject;
		this.groupId = groupId;
		this.isVirtual = isVirtual;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public AcademicPeriodEntity getAcademicPeriod() {
		return academicPeriod;
	}

	public void setAcademicPeriod(AcademicPeriodEntity academicPeriod) {
		this.academicPeriod = academicPeriod;
	}

	public TeacherEntity getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherEntity teacher) {
		this.teacher = teacher;
	}

	public SubjectEntity getSubject() {
		return subject;
	}

	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getIsVirtual() {
		return isVirtual;
	}

	public void setIsVirtual(String isVirtual) {
		this.isVirtual = isVirtual;
	}

	public List<ClassVisitEntity> getClassVisits() {
		return classVisits;
	}

	public void setClassVisits(List<ClassVisitEntity> classVisits) {
		this.classVisits = classVisits;
	}

	public List<CoevaluationEntity> getCoevaluations() {
		return coevaluations;
	}

	public void setCoevaluations(List<CoevaluationEntity> coevaluations) {
		this.coevaluations = coevaluations;
	}

	public List<QuestionByPeriodEntity> getQuestionsByPeriod() {
		return questionsByPeriod;
	}

	public void setQuestionsByPeriod(List<QuestionByPeriodEntity> questionsByPeriod) {
		this.questionsByPeriod = questionsByPeriod;
	}

	
	@Override
	public String toString() {
		return "CourseEntity [courseId=" + courseId + ", academicPeriod=" + academicPeriod + ", teacher=" + teacher
				+ ", subject=" + subject + ", groupId=" + groupId + ", isVirtual=" + isVirtual + "]";
	}
	

}

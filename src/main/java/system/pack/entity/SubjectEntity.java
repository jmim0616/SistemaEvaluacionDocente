package system.pack.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="subjects")
public class SubjectEntity {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subjectId;
	
	@ManyToOne
	@JoinColumn(name="subjectStatusId")
	private SubjectStatusEntity subjectStatus;
	
	@ManyToOne
	@JoinColumn(name="disciplinaryAreaId")
	private DisciplinaryAreaEntity disciplinaryArea;
	
	@Column
	private String name;
	
	@Column
	private int numberOfCredits;

	@OneToMany(mappedBy="subject")
	@JsonIgnore
	private List<SubjectByTeacherEntity> teachers;
	
	@OneToMany(mappedBy="subject")
	@JsonIgnore
	private List<SubjectByProgramEntity> academicPrograms;

	
	public SubjectEntity() {

	}
	
	public SubjectEntity(int subjectId) {
		this.subjectId = subjectId;
	}
	
	public SubjectEntity(SubjectStatusEntity subjectStatus, DisciplinaryAreaEntity disciplinaryArea,
			String name, int numberOfCredits) {
		this.subjectStatus = subjectStatus;
		this.disciplinaryArea = disciplinaryArea;
		this.name = name;
		this.numberOfCredits = numberOfCredits;
	}
	
	public SubjectEntity(int subjectId, SubjectStatusEntity subjectStatus, DisciplinaryAreaEntity disciplinaryArea,
			String name, int numberOfCredits) {
		this.subjectId = subjectId;
		this.subjectStatus = subjectStatus;
		this.disciplinaryArea = disciplinaryArea;
		this.name = name;
		this.numberOfCredits = numberOfCredits;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public SubjectStatusEntity getSubjectStatus() {
		return subjectStatus;
	}

	public void setSubjectStatus(SubjectStatusEntity subjectStatus) {
		this.subjectStatus = subjectStatus;
	}

	public DisciplinaryAreaEntity getDisciplinaryArea() {
		return disciplinaryArea;
	}

	public void setDisciplinaryArea(DisciplinaryAreaEntity disciplinaryArea) {
		this.disciplinaryArea = disciplinaryArea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfCredits() {
		return numberOfCredits;
	}

	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	public List<SubjectByTeacherEntity> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<SubjectByTeacherEntity> teachers) {
		this.teachers = teachers;
	}
	
	public List<SubjectByProgramEntity> getAcademicPrograms() {
		return academicPrograms;
	}

	public void setAcademicPrograms(List<SubjectByProgramEntity> academicPrograms) {
		this.academicPrograms = academicPrograms;
	}

	@Override
	public String toString() {
		return "SubjectEntity [subjectId=" + subjectId + ", subjectStatus=" + subjectStatus + ", disciplinaryArea="
				+ disciplinaryArea + ", name=" + name + ", numberOfCredits=" + numberOfCredits + "]";
	}
	
	
	
	
	
	
	
}

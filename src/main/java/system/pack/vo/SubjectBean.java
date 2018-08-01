package system.pack.vo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

import system.pack.entity.DisciplinaryAreaEntity;
import system.pack.entity.SubjectStatusEntity;

public class SubjectBean {

	private String subjectId;
	
	private String subjectStatus;
	
	private String disciplinaryArea;
	
	@NotEmpty(message="El campo \"nombre\" es requerido")
	private String name;
	
	private String numberOfCredits;
	
	private String academicProgram;
	
	public SubjectBean() {

	}

	public SubjectBean(String subjectId) {
		this.subjectId = subjectId;

	}
	
	public SubjectBean(String subjectId, String subjectStatus, String disciplinaryArea, String name,
			String numberOfCredits) {
		this.subjectId = subjectId;
		this.subjectStatus = subjectStatus;
		this.disciplinaryArea = disciplinaryArea;
		this.name = name;
		this.numberOfCredits = numberOfCredits;
	}


	public String getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}


	public String getSubjectStatus() {
		return subjectStatus;
	}


	public void setSubjectStatus(String subjectStatus) {
		this.subjectStatus = subjectStatus;
	}


	public String getDisciplinaryArea() {
		return disciplinaryArea;
	}


	public void setDisciplinaryArea(String disciplinaryArea) {
		this.disciplinaryArea = disciplinaryArea;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNumberOfCredits() {
		return numberOfCredits;
	}


	public void setNumberOfCredits(String numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	public String getAcademicProgram() {
		return academicProgram;
	}

	public void setAcademicProgram(String academicProgram) {
		this.academicProgram = academicProgram;
	}

	
	@Override
	public String toString() {
		return "SubjectBean [subjectId=" + subjectId + ", subjectStatus=" + subjectStatus + ", disciplinaryArea="
				+ disciplinaryArea + ", name=" + name + ", numberOfCredits=" + numberOfCredits + "]";
	}

	
	
}

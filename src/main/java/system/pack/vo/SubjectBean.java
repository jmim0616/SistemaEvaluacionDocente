package system.pack.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	private List<String> academicProgramAdded;
	
	private List<String> academicProgramDeleted;
	
	public SubjectBean() {

	}

	public SubjectBean(String subjectId) {
		this.subjectId = subjectId;

	}

	public SubjectBean(String subjectId, String subjectStatus, String disciplinaryArea, String name,
			String numberOfCredits, String academicProgram, List<String> academicProgramAdded,
			List<String> academicProgramDeleted) {
	
		this.subjectId = subjectId;
		this.subjectStatus = subjectStatus;
		this.disciplinaryArea = disciplinaryArea;
		this.name = name;
		this.numberOfCredits = numberOfCredits;
		this.academicProgram = academicProgram;
		this.academicProgramAdded = academicProgramAdded;
		this.academicProgramDeleted = academicProgramDeleted;
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

	public List<String> getAcademicProgramAdded() {
		return academicProgramAdded;
	}

	public void setAcademicProgramAdded(List<String> academicProgramAdded) {
		this.academicProgramAdded = academicProgramAdded;
	}

	public List<String> getAcademicProgramDeleted() {
		return academicProgramDeleted;
	}

	public void setAcademicProgramDeleted(List<String> academicProgramDeleted) {
		this.academicProgramDeleted = academicProgramDeleted;
	}

	@Override
	public String toString() {
		return "SubjectBean [subjectId=" + subjectId + ", subjectStatus=" + subjectStatus + ", disciplinaryArea="
				+ disciplinaryArea + ", name=" + name + ", numberOfCredits=" + numberOfCredits + ", academicProgram="
				+ academicProgram + ", academicProgramAdded=" + academicProgramAdded + ", academicProgramDeleted="
				+ academicProgramDeleted + "]";
	}

	
	

	

	


	
	
}

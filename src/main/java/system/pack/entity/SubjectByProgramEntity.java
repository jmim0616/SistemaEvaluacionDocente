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
@Table(name="subjects_by_program")
public class SubjectByProgramEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subjectByProgramId;
	
	
	@ManyToOne
	@JoinColumn(name="academicProgramId")
	private AcademicProgramEntity academicProgram;
	
	@ManyToOne
	@JoinColumn(name="subjectId")
	private SubjectEntity subject;
	
	
	public SubjectByProgramEntity() {
		
	}

	public SubjectByProgramEntity(int subjectByProgramId) {
		this.subjectByProgramId = subjectByProgramId;
	}
	
	public SubjectByProgramEntity(AcademicProgramEntity academicProgram,SubjectEntity subject) {
		this.academicProgram = academicProgram;
		this.subject = subject;
	}
	
	public SubjectByProgramEntity(int subjectByProgramId, AcademicProgramEntity academicProgram,
			SubjectEntity subject) {
		this.subjectByProgramId = subjectByProgramId;
		this.academicProgram = academicProgram;
		this.subject = subject;
	}

	public int getSubjectByProgramId() {
		return subjectByProgramId;
	}

	public void setSubjectByProgramId(int subjectByProgramId) {
		this.subjectByProgramId = subjectByProgramId;
	}

	public AcademicProgramEntity getAcademicProgram() {
		return academicProgram;
	}

	public void setAcademicProgram(AcademicProgramEntity academicProgram) {
		this.academicProgram = academicProgram;
	}

	public SubjectEntity getSubject() {
		return subject;
	}

	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}

	
	@Override
	public String toString() {
		return "SubjectByProgramEntity [subjectByProgramId=" + subjectByProgramId + ", academicProgram="
				+ academicProgram + ", subject=" + subject + "]";
	}
	

}

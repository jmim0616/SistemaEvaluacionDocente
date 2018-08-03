package system.pack.vo;



import system.pack.entity.AcademicProgramEntity;
import system.pack.entity.SubjectEntity;

public class SubjectByProgramBean {

	
	private String subjectByProgramId;
	
	private String academicProgram;
	
	private String subject;

	
	public SubjectByProgramBean() {

	}

	public SubjectByProgramBean(String subjectByProgramId, String academicProgram, String subject) {
		this.subjectByProgramId = subjectByProgramId;
		this.academicProgram = academicProgram;
		this.subject = subject;
	}

	public String getSubjectByProgramId() {
		return subjectByProgramId;
	}

	public void setSubjectByProgramId(String subjectByProgramId) {
		this.subjectByProgramId = subjectByProgramId;
	}

	public String getAcademicProgram() {
		return academicProgram;
	}

	public void setAcademicProgram(String academicProgram) {
		this.academicProgram = academicProgram;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "SubjectByProgramBean [subjectByProgramId=" + subjectByProgramId + ", academicProgram=" + academicProgram
				+ ", subject=" + subject + "]";
	}

	
	
	
	
}

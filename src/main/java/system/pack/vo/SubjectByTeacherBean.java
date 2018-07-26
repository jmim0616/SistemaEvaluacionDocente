package system.pack.vo;

public class SubjectByTeacherBean {
	
	private String subjectByTeacherId;
	
	private String subject;

	private String teacher;

	
	public SubjectByTeacherBean() {

	}
	
	
	public SubjectByTeacherBean(String subjectByTeacherId, String subject, String teacher) {
		this.subjectByTeacherId = subjectByTeacherId;
		this.subject = subject;
		this.teacher = teacher;
	}


	public String getSubjectByTeacherId() {
		return subjectByTeacherId;
	}


	public void setSubjectByTeacherId(String subjectByTeacherId) {
		this.subjectByTeacherId = subjectByTeacherId;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getTeacher() {
		return teacher;
	}


	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}


	@Override
	public String toString() {
		return "SubjectByTeacherBean [subjectByTeacherId=" + subjectByTeacherId + ", subject=" + subject + ", teacher="
				+ teacher + "]";
	}
	
	
}

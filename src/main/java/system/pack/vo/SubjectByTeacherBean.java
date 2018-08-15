package system.pack.vo;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class SubjectByTeacherBean {
	
	private String subjectByTeacherId;
	
	private String subject;

	private String teacher;

	private List<String> subjectAdded;

	private List<String> subjectDeleted;

	
	public SubjectByTeacherBean() {

	}
	
	

	public SubjectByTeacherBean(String subjectByTeacherId, String subject, String teacher, List<String> subjectAdded,
			List<String> subjectDeleted) {
		this.subjectByTeacherId = subjectByTeacherId;
		this.subject = subject;
		this.teacher = teacher;
		this.subjectAdded = subjectAdded;
		this.subjectDeleted = subjectDeleted;
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



	public List<String> getSubjectAdded() {
		return subjectAdded;
	}



	public void setSubjectAdded(List<String> subjectAdded) {
		this.subjectAdded = subjectAdded;
	}



	public List<String> getSubjectDeleted() {
		return subjectDeleted;
	}



	public void setSubjectDeleted(List<String> subjectDeleted) {
		this.subjectDeleted = subjectDeleted;
	}



	@Override
	public String toString() {
		return "SubjectByTeacherBean [subjectByTeacherId=" + subjectByTeacherId + ", subject=" + subject + ", teacher="
				+ teacher + ", subjectAdded=" + subjectAdded + ", subjectDeleted=" + subjectDeleted + "]";
	}
	
	
}

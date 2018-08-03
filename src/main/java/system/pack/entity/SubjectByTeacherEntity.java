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
@Table(name="subjects_by_teacher")
public class SubjectByTeacherEntity {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int subjectByTeacherId;
	
	@ManyToOne
	@JoinColumn(name="subjectId")
	private SubjectEntity subject;
	
	@ManyToOne
	@JoinColumn(name="teacherId")
	private TeacherEntity teacher;
	
	
	public SubjectByTeacherEntity () {
		
	}
	
	public SubjectByTeacherEntity(int subjectByTeacherId) {
		this.subjectByTeacherId = subjectByTeacherId;

	}

	public SubjectByTeacherEntity(SubjectEntity subject, TeacherEntity teacher) {
		this.subject = subject;
		this.teacher = teacher;
	}
	
	public SubjectByTeacherEntity(int subjectByTeacherId, SubjectEntity subject, TeacherEntity teacher) {
		this.subjectByTeacherId = subjectByTeacherId;
		this.subject = subject;
		this.teacher = teacher;
	}

	public int getSubjectByTeacherId() {
		return subjectByTeacherId;
	}

	public void setSubjectByTeacherId(int subjectByTeacherId) {
		this.subjectByTeacherId = subjectByTeacherId;
	}

	public SubjectEntity getSubject() {
		return subject;
	}

	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}

	public TeacherEntity getTeacher() {
		return teacher;
	}

	public void setTeacher(TeacherEntity teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "SubjectByTeacherEntity [subjectByTeacherId=" + subjectByTeacherId + ", subject=" + subject
				+ ", teacher=" + teacher + "]";
	}
	
	
	
	
	
}

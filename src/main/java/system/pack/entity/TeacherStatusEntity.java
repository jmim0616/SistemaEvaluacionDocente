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

@Entity
@Table(name="teacher_status")
public class TeacherStatusEntity {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int teacherStatusId;
	
	@Column
	private String status;
	
	@OneToMany(mappedBy="teacherStatus")
	private List<TeacherEntity> teachers;

	public TeacherStatusEntity() {
		
	}
	
	public TeacherStatusEntity(int teacherStatusId) {
		this.teacherStatusId = teacherStatusId;
	}
	
	public TeacherStatusEntity(String status, List<TeacherEntity> teachers) {
		this.status = status;
		this.teachers = teachers;
	}
	
	public TeacherStatusEntity(int teacherStatusId, String status, List<TeacherEntity> teachers) {
		this.teacherStatusId = teacherStatusId;
		this.status = status;
		this.teachers = teachers;
	}

	public int getTeacherStatusId() {
		return teacherStatusId;
	}

	public void setTeacherStatusId(int teacherStatusId) {
		this.teacherStatusId = teacherStatusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<TeacherEntity> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<TeacherEntity> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "TeacherStatusEntity [teacherStatusId=" + teacherStatusId + ", status=" + status + ", teachers="
				+ teachers + "]";
	}

	

	
	
	
	
}

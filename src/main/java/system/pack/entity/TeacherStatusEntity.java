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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private List<TeacherEntity> teachers;

	public TeacherStatusEntity() {
		
	}
	
	public TeacherStatusEntity(int teacherStatusId) {
		this.teacherStatusId = teacherStatusId;
	}
	
	public TeacherStatusEntity(String status) {
		this.status = status;
	}
	
	public TeacherStatusEntity(int teacherStatusId, String status) {
		this.teacherStatusId = teacherStatusId;
		this.status = status;
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

	@Override
	public String toString() {
		return "TeacherStatusEntity [teacherStatusId=" + teacherStatusId + ", status=" + status + "]";
	}



	

	
	
	
	
}

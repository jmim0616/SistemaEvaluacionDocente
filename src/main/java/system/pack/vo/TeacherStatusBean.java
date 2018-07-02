package system.pack.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class TeacherStatusBean {
	

	private String teacherStatusId;

	private String status;
		
	public TeacherStatusBean () {
		
		
	}

	public TeacherStatusBean(String teacherStatusId, String status) {
		this.teacherStatusId = teacherStatusId;
		this.status = status;
	}

	public String getTeacherStatusId() {
		return teacherStatusId;
	}

	public void setTeacherStatusId(String teacherStatusId) {
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
		return "TeacherStatusBean [teacherStatusId=" + teacherStatusId + ", status=" + status + "]";
	}
	
	
}
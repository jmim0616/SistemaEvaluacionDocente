//package system.pack.entity;
//
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//@Entity
//@Table(name="subject_status")
//public class SubjectStatusEntity {
//
//	@Column
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int subjectStatusId;
//	
//	@Column
//	private String status;
//	
//	@OneToMany(mappedBy="subjectStatus")
//	@JsonIgnore
//	List<SubjectEntity> subjects;
//	
//	
//	public SubjectStatusEntity() {
//		
//	}
//	
//	public SubjectStatusEntity(int subjectStatusId) {
//		this.subjectStatusId = subjectStatusId;
//	}
//	
//	public SubjectStatusEntity(String status) {
//		this.status = status;
//	}
//
//	public SubjectStatusEntity(int subjectStatusId, String status) {
//		this.subjectStatusId = subjectStatusId;
//		this.status = status;
//	}
//
//	public int getSubjectStatusId() {
//		return subjectStatusId;
//	}
//
//	public void setSubjectStatusId(int subjectStatusId) {
//		this.subjectStatusId = subjectStatusId;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	public List<SubjectEntity> getSubjects() {
//		return subjects;
//	}
//
//	public void setSubjects(List<SubjectEntity> subjects) {
//		this.subjects = subjects;
//	}
//
//	@Override
//	public String toString() {
//		return "SubjectStatusEntity [subjectStatusId=" + subjectStatusId + ", status=" + status + "]";
//	}
//	
//	
//	
//	
//	
//	
//	
//	
//}

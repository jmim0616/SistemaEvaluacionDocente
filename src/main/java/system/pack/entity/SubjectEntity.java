//package system.pack.entity;
//
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="subjects")
//public class SubjectEntity {
//
//	@Column
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int subjectId;
//	
//	@ManyToOne
//	@JoinColumn(name="subjectStatusId")
//	private SubjectStatusEntity subjectStatus;
//	
//	@ManyToOne
//	@JoinColumn(name="disciplinaryAreaId")
//	private DisciplinaryAreaEntity disciplinaryArea;
//	
//	@Column
//	private String name;
//	
//	@Column
//	private int numberOfCredits;
//
//	@ManyToMany
//	@JoinTable(name="subjects_by_teacher",
//	joinColumns=@JoinColumn(name="subjectId"),
//	inverseJoinColumns=@JoinColumn(name="teacherId")
//	)
//	private List<TeacherEntity> teachers;
//	
//	public SubjectEntity() {
//
//	}
//	
//	public SubjectEntity(int subjectId) {
//		this.subjectId = subjectId;
//	}
//	
//	public SubjectEntity(SubjectStatusEntity subjectStatus, DisciplinaryAreaEntity disciplinaryArea,
//			String name, int numberOfCredits) {
//		this.subjectStatus = subjectStatus;
//		this.disciplinaryArea = disciplinaryArea;
//		this.name = name;
//		this.numberOfCredits = numberOfCredits;
//	}
//	
//	public SubjectEntity(int subjectId, SubjectStatusEntity subjectStatus, DisciplinaryAreaEntity disciplinaryArea,
//			String name, int numberOfCredits) {
//		this.subjectId = subjectId;
//		this.subjectStatus = subjectStatus;
//		this.disciplinaryArea = disciplinaryArea;
//		this.name = name;
//		this.numberOfCredits = numberOfCredits;
//	}
//
//	public int getSubjectId() {
//		return subjectId;
//	}
//
//	public void setSubjectId(int subjectId) {
//		this.subjectId = subjectId;
//	}
//
//	public SubjectStatusEntity getSubjectStatus() {
//		return subjectStatus;
//	}
//
//	public void setSubjectStatus(SubjectStatusEntity subjectStatus) {
//		this.subjectStatus = subjectStatus;
//	}
//
//	public DisciplinaryAreaEntity getDisciplinaryArea() {
//		return disciplinaryArea;
//	}
//
//	public void setDisciplinaryArea(DisciplinaryAreaEntity disciplinaryArea) {
//		this.disciplinaryArea = disciplinaryArea;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getNumberOfCredits() {
//		return numberOfCredits;
//	}
//
//	public void setNumberOfCredits(int numberOfCredits) {
//		this.numberOfCredits = numberOfCredits;
//	}
//	
//	
//	
//	
//}

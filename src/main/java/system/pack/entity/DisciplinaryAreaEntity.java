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
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="disciplinary_areas")
public class DisciplinaryAreaEntity {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int disciplinaryAreaId;

	@ManyToOne
	@JoinColumn(name="departmentId")
	private DepartmentEntity department;
	
	@Column
	private String name;
	
//	@OneToMany(mappedBy="disciplinaryArea")
//	@JsonIgnore
//	List<SubjectEntity> subjects;
	
	public DisciplinaryAreaEntity() {

	}

	
	public DisciplinaryAreaEntity(int disciplinaryAreaId) {
		this.disciplinaryAreaId = disciplinaryAreaId;
	}
	
	public DisciplinaryAreaEntity(DepartmentEntity department, String name) {
		this.department = department;
		this.name = name;
	}

	public DisciplinaryAreaEntity(int disciplinaryAreaId, DepartmentEntity department, String name) {
		this.disciplinaryAreaId = disciplinaryAreaId;
		this.department = department;
		this.name = name;
	}

	public int getDisciplinaryAreaId() {
		return disciplinaryAreaId;
	}

	public void setDisciplinaryAreaId(int disciplinaryAreaId) {
		this.disciplinaryAreaId = disciplinaryAreaId;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}


	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<SubjectEntity> getSubjects() {
//		return subjects;
//	}
//
//
//	public void setSubjects(List<SubjectEntity> subjects) {
//		this.subjects = subjects;
//	}


	@Override
	public String toString() {
		return "DisciplinaryAreaEntity [disciplinaryAreaId=" + disciplinaryAreaId + ", department=" + department
				+ ", name=" + name + "]";
	}





	
	
	
}

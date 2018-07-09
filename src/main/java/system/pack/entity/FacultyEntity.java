package system.pack.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="faculties")
public class FacultyEntity {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int facultyId;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="departmentId")
	private DepartmentEntity department;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy="faculty")
	@JsonIgnore
	List<AcademicProgramEntity> academicPrograms;
	
	
	
	@OneToMany(mappedBy="faculty")
	@JsonIgnore
	List<DisciplinaryAreaEntity> disciplinaryAreas;
	
	public FacultyEntity() {
	
	}
	
	public FacultyEntity(int facultyId) {
		this.facultyId = facultyId;

	}
	
	public FacultyEntity(DepartmentEntity department, String name) {
		this.department = department;
		this.name = name;
	}

	public FacultyEntity(int facultyId, DepartmentEntity department, String name) {
		this.facultyId = facultyId;
		this.department = department;
		this.name = name;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
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

	@Override
	public String toString() {
		return "FacultyEntity [facultyId=" + facultyId + ", department=" + department + ", name=" + name + "]";
	}
	
	
	



	
	
}
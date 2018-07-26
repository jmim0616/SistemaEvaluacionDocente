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

	@Column
	private String name;
	
	@OneToMany(mappedBy="faculty")
	@JsonIgnore
	private List<DepartmentEntity> departments;
	
	@OneToMany(mappedBy="faculty")
	@JsonIgnore
	private List<AcademicProgramEntity> academicPrograms;
	
	public FacultyEntity() {
	
	}
	
	public FacultyEntity(int facultyId) {
		this.facultyId = facultyId;

	}
	
	public FacultyEntity(String name) {
		this.name = name;
	}

	public FacultyEntity(int facultyId, String name) {
		this.facultyId = facultyId;
		this.name = name;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "FacultyEntity [facultyId=" + facultyId + ", name=" + name + "]";
	}


	
	
}
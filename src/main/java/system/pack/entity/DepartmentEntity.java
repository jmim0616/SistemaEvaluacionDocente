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
@Table(name="departments")
public class DepartmentEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentId;
	
	@ManyToOne
	@JoinColumn(name="facultyId")
	private FacultyEntity faculty;

	@Column
	private String name;
	
	@OneToMany(mappedBy="department")
	@JsonIgnore
	List<DisciplinaryAreaEntity> disciplinaryAreas;
	
	public DepartmentEntity() {
		
	}
	
	public DepartmentEntity(int departmentId) {
		this.departmentId = departmentId;

	}

	public DepartmentEntity(FacultyEntity faculty, String name) {
		this.faculty = faculty;
		this.name = name;
	}

	public DepartmentEntity(int departmentId, FacultyEntity faculty, String name) {
		this.faculty = faculty;
		this.departmentId = departmentId;
		this.name = name;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	

	public FacultyEntity getFaculty() {
		return faculty;
	}

	public void setFaculty(FacultyEntity faculty) {
		this.faculty = faculty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [departmentId=" + departmentId + ", faculty=" + faculty + ", name=" + name + "]";
	}


	
	


	


	

	
	
	

}

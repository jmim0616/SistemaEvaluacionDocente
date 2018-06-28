package system.pack.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="departments")
public class DepartmentEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentId;

	@Column
	private String name;
	
	@OneToMany(mappedBy="department")
	List<FacultyEntity> faculties;
	
	public DepartmentEntity() {
		
	}
	
	public DepartmentEntity(int departmentId) {
		this.departmentId = departmentId;

	}
	
	public DepartmentEntity(String name, List<FacultyEntity> faculties) {
		this.name = name;
		this.faculties = faculties;
	}


	public DepartmentEntity(int departmentId, String name, List<FacultyEntity> faculties) {
		this.departmentId = departmentId;
		this.name = name;
		this.faculties = faculties;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FacultyEntity> getFaculties() {
		return faculties;
	}

	public void setFaculties(List<FacultyEntity> faculties) {
		this.faculties = faculties;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [departmentId=" + departmentId + ", name=" + name + ", faculties=" + faculties + "]";
	}

	
	
	

}

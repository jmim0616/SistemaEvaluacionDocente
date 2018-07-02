package system.pack.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class FacultyBean {
	
	private String facultyId;

	private String department;
	
	@Pattern(regexp="^[a-zA-Z]*$", message="En este campo solo se permiten letras")
	private String name;
	
	
	public FacultyBean() {
		
	}

	public FacultyBean(String facultyId, String department, String name) {
		super();
		this.facultyId = facultyId;
		this.department = department;
		this.name = name;
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
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
		return "FacultyBean [facultyId=" + facultyId + ", department=" + department + ", name=" + name + "]";
	}
	
	
	

	
	
}
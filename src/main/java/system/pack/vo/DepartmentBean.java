package system.pack.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class DepartmentBean {
	
	private String departmentId;
	
	private String faculty;
	
	@Pattern(regexp="^[a-zA-Z-][a-zA-Z -][a-zA-ZñÑáéíóúÁÉÍÓÚ][a-zA-ZñÑáéíóúÁÉÍÓÚ -]*$", message="El campo \"Nombre\" debe ser diligenciado solo con letras")
	private String name;

	public DepartmentBean () {
	
	}

	public DepartmentBean(String departmentId, String faculty, String name) {

		this.departmentId = departmentId;
		this.faculty = faculty;
		this.name = name;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
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
		return "DepartmentBean [departmentId=" + departmentId + ", faculty=" + faculty + ", name=" + name + "]";
	}


	



	
	
	
	
}
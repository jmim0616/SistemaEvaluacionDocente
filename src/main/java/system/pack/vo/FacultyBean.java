package system.pack.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class FacultyBean {
	
	private String facultyId;
	
	@Pattern(regexp="^[a-zA-Z-][a-zA-Z -]*$", message="El campo \"Nombre\" debe ser diligenciado solo con letras")
	private String name;
	
	public FacultyBean() {
		
	}

	public FacultyBean(String facultyId, String name) {
		this.facultyId = facultyId;
		this.name = name;
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
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
		return "FacultyBean [facultyId=" + facultyId + ", name=" + name + "]";
	}


	
	
	

	
	
}
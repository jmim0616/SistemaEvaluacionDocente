package system.pack.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class AcademicProgramBean {
	

	private String academicProgramId;

	private String faculty;
	
	@Pattern(regexp="^[a-zA-Z-][a-zA-Z -]*$", message="El campo \"Nombre\" debe ser diligenciado solo con letras")
	private String name;
	
	
	public AcademicProgramBean() {
		
	}


	public AcademicProgramBean(String academicProgramId, String faculty, String name) {
		this.academicProgramId = academicProgramId;
		this.faculty = faculty;
		this.name = name;
	}


	public String getAcademicProgramId() {
		return academicProgramId;
	}


	public void setAcademicProgramId(String academicProgramId) {
		this.academicProgramId = academicProgramId;
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
		return "AcademicProgramBean [academicProgramId=" + academicProgramId + ", faculty=" + faculty + ", name=" + name
				+ "]";
	}

	
	
	
}
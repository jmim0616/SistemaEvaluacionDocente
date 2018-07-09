package system.pack.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class DisciplinaryAreaBean {
	
	private String disciplinaryAreaId;

	private String faculty;
	
	@Pattern(regexp="^[a-zA-Z-][a-zA-Z -]*$", message="El campo \"Nombre\" debe ser diligenciado solo con letras")
	private String name;
	
	
	public DisciplinaryAreaBean() {
		
	}


	public DisciplinaryAreaBean(String disciplinaryAreaId, String faculty, String name) {
		this.disciplinaryAreaId = disciplinaryAreaId;
		this.faculty = faculty;
		this.name = name;
	}


	public String getDisciplinaryAreaId() {
		return disciplinaryAreaId;
	}


	public void setDisciplinaryAreaId(String disciplinaryAreaId) {
		this.disciplinaryAreaId = disciplinaryAreaId;
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
		return "DisciplinaryAreaBean [disciplinaryAreaId=" + disciplinaryAreaId + ", faculty=" + faculty + ", name="
				+ name + "]";
	}

	
	
	
}
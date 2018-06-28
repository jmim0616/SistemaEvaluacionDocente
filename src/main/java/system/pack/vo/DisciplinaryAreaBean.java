package system.pack.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class DisciplinaryAreaBean {
	
	@Pattern(regexp="^[0-9]{10}$", message="En este campo solo se permiten numeros de 10 caracteres")
	private String disciplinaryAreaId;

	private String faculty;
	
	@NotEmpty(message="Este campo es requerido")
	@Pattern(regexp="^[a-zA-Z]*$", message="En este campo solo se permiten letras")
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
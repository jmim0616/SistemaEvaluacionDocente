package system.pack.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class DisciplinaryAreaBean {
	
	private String disciplinaryAreaId;

	private String department;
	
	@Pattern(regexp="^[a-zA-Z-][a-zA-Z -][a-zA-ZñÑáéíóúÁÉÍÓÚ][a-zA-ZñÑáéíóúÁÉÍÓÚ -]*$", message="El campo \"Nombre\" debe ser diligenciado solo con letras")
	private String name;
	
	
	public DisciplinaryAreaBean() {
		
	}


	public DisciplinaryAreaBean(String disciplinaryAreaId, String department, String name) {
		this.disciplinaryAreaId = disciplinaryAreaId;
		this.department = department;
		this.name = name;
	}


	public String getDisciplinaryAreaId() {
		return disciplinaryAreaId;
	}


	public void setDisciplinaryAreaId(String disciplinaryAreaId) {
		this.disciplinaryAreaId = disciplinaryAreaId;
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
		return "DisciplinaryAreaBean [disciplinaryAreaId=" + disciplinaryAreaId + ", department=" + department + ", name="
				+ name + "]";
	}

	
	
	
}
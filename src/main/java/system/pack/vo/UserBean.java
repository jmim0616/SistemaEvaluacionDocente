package system.pack.vo;


import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class UserBean {
	
	private int userId;
	
	@NotEmpty(message="El campo \"nombre de usuario\" es requerido.")
	@Pattern(regexp="^[a-zA-Z]*$", message="En el campo \"nombre de usuario\" solo se pueden ingresar letras, "
			+ "sin incluir espacios.")
	private String mask;

	@NotEmpty(message="El campo \"contraseÒa\" es requerido.")
	private String password;
	
	@Pattern(regexp = "([a-zA-Z0-9\\.\\-\\_]+\\@[a-zA-Z0-9\\-\\_]+(\\.[a-zA-Z]{2,4}){1,2}){0,1}", message="El campo \"Correo ElectrÛnico Institucional\" no cumple el formato adecuado. Ej: ejemplo@gmail.com")
	private String institutionalMail;
	
	@Pattern(regexp = "([a-zA-Z0-9\\.\\-\\_]+\\@[a-zA-Z0-9\\-\\_]+(\\.[a-zA-Z]{2,4}){1,2}){0,1}", message="El campo \"Correo ElectrÛnico Personal\" no cumple el formato adecuado. Ej: ejemplo@gmail.com")
	private String personalMail;

	@NotEmpty(message="El campo \"nombre\" es requerido.")
	@Pattern(regexp="^[a-zA-Z-][a-zA-Z -][a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄][a-zA-ZÒ—·ÈÌÛ˙¡…Õ”⁄ -]*$", message="En el campo \"Nombre\" solo se pueden ingresar letras.")
	private String name;
	
	@NotEmpty(message="El campo \"cargo laboral\" es requerido.")
	private String jobPosition;   
	
	private int status;
	
	private int userType;
	

	public UserBean() {
	
	}

	public UserBean(int userId, String mask, String password, String institutionalMail, String personalMail,
			String name, String jobPosition, int status, int userType) {
		this.userId = userId;
		this.mask = mask;
		this.password = password;
		this.institutionalMail = institutionalMail;
		this.personalMail = personalMail;
		this.name = name;
		this.jobPosition = jobPosition;
		this.status = status;
		this.userType = userType;
	}

	public UserBean(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getMask() {
		return mask;
	}


	public void setMask(String mask) {
		this.mask = mask;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getInstitutionalMail() {
		return institutionalMail;
	}


	public void setInstitutionalMail(String institutionalMail) {
		this.institutionalMail = institutionalMail;
	}


	public String getPersonalMail() {
		return personalMail;
	}


	public void setPersonalMail(String personalMail) {
		this.personalMail = personalMail;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}	
	
	
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", mask=" + mask + ", password=" + password + ", institutionalMail="
				+ institutionalMail + ", personalMail=" + personalMail + ", name=" + name + ", jobPosition="
				+ jobPosition + ", status=" + status + ", userType=" + userType + "]";
	}
	
}


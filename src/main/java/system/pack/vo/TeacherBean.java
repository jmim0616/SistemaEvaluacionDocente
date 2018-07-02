package system.pack.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class TeacherBean {
	
	@NotEmpty(message="Este campo es requerido")
	@Pattern(regexp="^[0-9]*$", message="En este campo solo se permiten numeros")
	private String teacherId;

	private String teacherStatus;
	
	@NotEmpty(message="Este campo es requerido")
	@Pattern(regexp="^[a-zA-Z]*$", message="En este campo solo se permiten letras")
	private String name;
	
	@Pattern(regexp="^[a-zA-Z]*$", message="En este campo solo se permiten letras")
	private String lastName;
	
	private String identificationType;
	
	@Pattern(regexp="^[a-zA-Z]*$", message="En este campo solo se permiten letras")
	private String underDegree;

	@Pattern(regexp="^[a-zA-Z]*$", message="En este campo solo se permiten letras")
	private String masterDegree;
	
	@Pattern(regexp="^[a-zA-Z]*$", message="En este campo solo se permiten letras")
	private String doctorDegree;
	
	@Pattern(regexp="([a-zA-Z0-9\\.\\-\\_]+\\@[a-zA-Z0-9\\-\\_]+\\.[a-zA-Z]{2,4}){0,1}", message="El campo \"Email\" no cumple el formato adecuado. Ej: ejemplo@gmail.com")
	private String institutionalMail;
	
	@Pattern(regexp="([a-zA-Z0-9\\.\\-\\_]+\\@[a-zA-Z0-9\\-\\_]+\\.[a-zA-Z]{2,4}){0,1}", message="El campo \"Email\" no cumple el formato adecuado. Ej: ejemplo@gmail.com")
	private String personalMail;
	
	@Pattern(regexp="^[0-9]*$", message="En este campo solo se permiten numeros")
	private String cellNumber;
	
	@Pattern(regexp="^[0-9]*$", message="En este campo solo se permiten numeros")
	private String homeNumber;
	
	private String experience;
	
	
	public TeacherBean() {
		
	}
	
	public TeacherBean(String teacherId) {
		this.teacherId = teacherId;

	}


	public TeacherBean(String teacherId, String teacherStatus, String name, String lastName, String identificationType,
			String underDegree, String masterDegree, String doctorDegree, String institutionalMail, String personalMail,
			String cellNumber, String homeNumber, String experience) {
		this.teacherId = teacherId;
		this.teacherStatus = teacherStatus;
		this.name = name;
		this.lastName = lastName;
		this.identificationType = identificationType;
		this.underDegree = underDegree;
		this.masterDegree = masterDegree;
		this.doctorDegree = doctorDegree;
		this.institutionalMail = institutionalMail;
		this.personalMail = personalMail;
		this.cellNumber = cellNumber;
		this.homeNumber = homeNumber;
		this.experience = experience;
	}


	public String getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}


	public String getTeacherStatus() {
		return teacherStatus;
	}


	public void setTeacherStatus(String teacherStatus) {
		this.teacherStatus = teacherStatus;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getIdentificationType() {
		return identificationType;
	}


	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}


	public String getUnderDegree() {
		return underDegree;
	}


	public void setUnderDegree(String underDegree) {
		this.underDegree = underDegree;
	}


	public String getMasterDegree() {
		return masterDegree;
	}


	public void setMasterDegree(String masterDegree) {
		this.masterDegree = masterDegree;
	}


	public String getDoctorDegree() {
		return doctorDegree;
	}


	public void setDoctorDegree(String doctorDegree) {
		this.doctorDegree = doctorDegree;
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

	public String getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}

	public String getHomeNumber() {
		return homeNumber;
	}


	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}


	@Override
	public String toString() {
		return "TeacherBean [teacherId=" + teacherId + ", teacherStatus=" + teacherStatus + ", name=" + name
				+ ", lastName=" + lastName + ", identificationType=" + identificationType + ", underDegree="
				+ underDegree + ", masterDegree=" + masterDegree + ", doctorDegree=" + doctorDegree
				+ ", institutionalMail=" + institutionalMail + ", personalMail=" + personalMail + ", cellNumber="
				+ cellNumber + ", homeNumber=" + homeNumber + ", experience=" + experience + "]";
	}

	
	
	
}
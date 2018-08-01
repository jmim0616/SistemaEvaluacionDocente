package system.pack.vo;


public class UserBean {

	
	private String userId;
	
	private String mask;
	
	private String password;
	
	private String institutionalMail;
	
	private String personalMail;

	private String jobPosition;
	
	private String name;
	
	private String status;
	
	private String userType;
	
	
	public UserBean() {
		
	}

	public UserBean(String userId) {
		this.userId = userId;
	}

	public UserBean(String userId, String mask, String password, String institutionalMail, String personalMail,
			String jobPosition, String name, String status, String userType) {
		this.userId = userId;
		this.mask = mask;
		this.password = password;
		this.institutionalMail = institutionalMail;
		this.personalMail = personalMail;
		this.jobPosition = jobPosition;
		this.name = name;
		this.status = status;
		this.userType = userType;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
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


	public String getJobPosition() {
		return jobPosition;
	}


	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", mask=" + mask + ", password=" + password + ", institutionalMail="
				+ institutionalMail + ", personalMail=" + personalMail + ", jobPosition=" + jobPosition + ", name="
				+ name + ", status=" + status + ", userType=" + userType + "]";
	}
	
	

}

package system.pack.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class UserEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@Column
	private String mask;
	
	@Column
	private String password;
	
	@Column
	private String institutionalMail;
	
	@Column
	private String personalMail;

	@Column
	private String jobPosition;
	
	@Column
	private String name;
	
	@Column
	private int status;
	
	@Column
	private int userType;

	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<CourseFeedbackEntity> courseFeedbacks;
	
	public UserEntity() {
		
	}

	public UserEntity(int userId) {
		this.userId = userId;
	}

	public UserEntity(String mask, String password, String institutionalMail, String personalMail,
			String jobPosition, String name, int status, int userType) {
		this.mask = mask;
		this.password = password;
		this.institutionalMail = institutionalMail;
		this.personalMail = personalMail;
		this.jobPosition = jobPosition;
		this.name = name;
		this.status = status;
		this.userType = userType;
	}
	
	
	public UserEntity(int userId, String mask, String password, String institutionalMail, String personalMail,
			String jobPosition, String name, int status, int userType) {
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

	public List<CourseFeedbackEntity> getCourseFeedbacks() {
		return courseFeedbacks;
	}

	public void setCourseFeedbacks(List<CourseFeedbackEntity> courseFeedbacks) {
		this.courseFeedbacks = courseFeedbacks;
	}

	@Override
	public String toString() {
		return "UserEntity [userId=" + userId + ", mask=" + mask + ", password=" + password + ", institutionalMail="
				+ institutionalMail + ", personalMail=" + personalMail + ", jobPosition=" + jobPosition + ", name="
				+ name + ", status=" + status + ", userType=" + userType + "]";
	}
	
	
	
}
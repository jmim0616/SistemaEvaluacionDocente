package system.pack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class UserEntity {
		
		@Id
		@Column
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
		private int userType;
		
		@Column
		private int status;
		
		@Column
		private String name;  
		
		@Column
		private String jobPosition;   
		
		public UserEntity() {
			
		}
		
		

		public UserEntity(int userId, String mask,  String name, String jobPosition, String institutionalMail, String personalMail
				) {
			this.userId = userId;
			this.mask = mask;
			this.institutionalMail = institutionalMail;
			this.personalMail = personalMail;
			this.name = name;
			this.jobPosition = jobPosition;
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



		public int getUserType() {
			return userType;
		}



		public void setUserType(int userType) {
			this.userType = userType;
		}



		public int getStatus() {
			return status;
		}



		public void setStatus(int status) {
			this.status = status;
		}
	
		
		
}

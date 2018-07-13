package system.pack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="teachers")
public class TeacherEntity {
	
	@Id
	@Column
	private int teacherId;

	@ManyToOne
	@JoinColumn(name="teacherStatusId")
	private TeacherStatusEntity teacherStatus;
	
	@Column
	private String name;
	
	@Column
	private String lastName;
	
	@Column
	private int identificationType;
	
	@Column
	private String underDegree;

	@Column
	private String masterDegree;
	
	@Column
	private String doctorDegree;
	
	@Column
	private String institutionalMail;
	
	@Column
	private String personalMail;
	
	@Column
	private long cellNumber;
	
	@Column
	private long homeNumber;
	
	@Column
	private String experience;

	
	public TeacherEntity() {
		
	}
	
	public TeacherEntity(int teacherId) {
		this.teacherId = teacherId;
	}

	public TeacherEntity(int teacherId, TeacherStatusEntity teacherStatus, String name, String lastName,
			int identificationType, String underDegree, String masterDegree, String doctorDegree,
			String institutionalMail, String personalMail, long cellNumber, long homeNumber, String experience) {
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

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public TeacherStatusEntity getTeacherStatus() {
		return teacherStatus;
	}

	public void setTeacherStatus(TeacherStatusEntity teacherStatus) {
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

	public int getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(int identificationType) {
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

	public long getCellNumber() {
		return cellNumber;
	}

	public void setCellNumber(long cellNumber) {
		this.cellNumber = cellNumber;
	}

	public long getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(long homeNumber) {
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
		return "TeacherEntity [teacherId=" + teacherId + ", teacherStatus=" + teacherStatus + ", name=" + name
				+ ", lastName=" + lastName + ", identificationType=" + identificationType + ", underDegree="
				+ underDegree + ", masterDegree=" + masterDegree + ", doctorDegree=" + doctorDegree
				+ ", institutionalMail=" + institutionalMail + ", personalMail=" + personalMail + ", cellNumber="
				+ cellNumber + ", homeNumber=" + homeNumber + ", experience=" + experience + "]";
	}


	
	
	
}
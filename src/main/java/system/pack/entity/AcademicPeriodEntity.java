package system.pack.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="academic_periods")
public class AcademicPeriodEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int academicPeriodId;
	
	@Column
	private String name;
	
	@Column
	private Date initialDate;
	
	@Column
	private Date endDate; 
	
	public AcademicPeriodEntity() {
		
	}

	public AcademicPeriodEntity(int academicPeriodId) {
		this.academicPeriodId = academicPeriodId;
	}

	public AcademicPeriodEntity(String name, Date initialDate, Date endDate) {
		this.name = name;
		this.initialDate = initialDate;
		this.endDate = endDate;
	}
	
	public AcademicPeriodEntity(int academicPeriodId, String name, Date initialDate, Date endDate) {
		this.academicPeriodId = academicPeriodId;
		this.name = name;
		this.initialDate = initialDate;
		this.endDate = endDate;
	}

	public int getAcademicPeriodId() {
		return academicPeriodId;
	}

	public void setAcademicPeriodId(int academicPeriodId) {
		this.academicPeriodId = academicPeriodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	
	@Override
	public String toString() {
		return "AcademicPeriodEntity [academicPeriodId=" + academicPeriodId + ", name=" + name + ", initialDate="
				+ initialDate + ", endDate=" + endDate + "]";
	}
	
	
}

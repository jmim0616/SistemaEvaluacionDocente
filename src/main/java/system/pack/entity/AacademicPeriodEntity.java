//package system.pack.entity;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="academic_periods")
//public class AacademicPeriodEntity {
//
//	@Column
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int academicPeriodId;
//	
//	@Column
//	private String name;
//	
//	@Column
//	private Date initialDate;
//	
//	@Column
//	private Date endDate; 
//	
//	public AacademicPeriodEntity() {
//		
//	}
//
//	public AacademicPeriodEntity(int academicPeriodId) {
//		this.academicPeriodId = academicPeriodId;
//	}
//
//	public AacademicPeriodEntity(String name, Date initialDate, Date endDate) {
//		this.name = name;
//		this.initialDate = initialDate;
//		this.endDate = endDate;
//	}
//	
//	public AacademicPeriodEntity(int academicPeriodId, String name, Date initialDate, Date endDate) {
//		this.academicPeriodId = academicPeriodId;
//		this.name = name;
//		this.initialDate = initialDate;
//		this.endDate = endDate;
//	}
//
//	public int getAcademicPeriodId() {
//		return academicPeriodId;
//	}
//
//	public void setAcademicPeriodId(int academicPeriodId) {
//		this.academicPeriodId = academicPeriodId;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Date getInitialDate() {
//		return initialDate;
//	}
//
//	public void setInitialDate(Date initialDate) {
//		this.initialDate = initialDate;
//	}
//
//	public Date getEndDate() {
//		return endDate;
//	}
//
//	public void setEndDate(Date endDate) {
//		this.endDate = endDate;
//	}
//
//	
//	@Override
//	public String toString() {
//		return "AacademicPeriodEntity [academicPeriodId=" + academicPeriodId + ", name=" + name + ", initialDate="
//				+ initialDate + ", endDate=" + endDate + "]";
//	}
//	
//	
//}

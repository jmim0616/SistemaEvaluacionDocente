package system.pack.fullview;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class RowHeader implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private long courseId;
	@Column
	private String periodName;
	@Column
	private String departmentName;
	@Column
	private String signatureName;
	@Column
	private long teacherId;
	@Column
	private long groupId;
	@Column
	private String isVirtual;
	
	public RowHeader(long courseId, String periodName, String departmentName, String signatureName, long teacherId,
			long groupId, String isVirtual) {
		super();
		this.courseId = courseId;
		this.periodName = periodName;
		this.departmentName = departmentName;
		this.signatureName = signatureName;
		this.teacherId = teacherId;
		this.groupId = groupId;
		this.isVirtual = isVirtual;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getPeriodName() {
		return periodName;
	}
	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getSignatureName() {
		return signatureName;
	}
	public void setSignatureName(String signatureName) {
		this.signatureName = signatureName;
	}
	public long getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public String getIsVirtual() {
		return isVirtual;
	}
	public void setIsVirtual(String isVirtual) {
		this.isVirtual = isVirtual;
	}
	@Override
	public String toString() {
		return "RowHeader [courseId=" + courseId + ", periodName=" + periodName + ", departmentName=" + departmentName
				+ ", signatureName=" + signatureName + ", teacherId=" + teacherId + ", groupId=" + groupId
				+ ", isVirtual=" + isVirtual + "]";
	}

}

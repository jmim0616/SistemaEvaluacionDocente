package system.pack.fullview;

import java.io.Serializable;
import java.util.List;

public class Row implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String periodName;
	private String departmentName;
	private String signatureName;
	private long teacherId;
	private long groupId;
	private List<Questions> questions;
	
	public Row(String periodName, String departmentName, String signatureName, long teacherId, long groupId, List<Questions> questions) {
		super();
		this.periodName = periodName;
		this.departmentName = departmentName;
		this.signatureName = signatureName;
		this.teacherId = teacherId;
		this.groupId = groupId;
		this.questions = questions;
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

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	public String getPeriodName() {
		return periodName;
	}

	public void setPeriodName(String periodName) {
		this.periodName = periodName;
	}
	
}

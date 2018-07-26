package system.pack.vo;


public class SubjectStatusBean {

	
	private String subjectStatusId;

	private String status;

	
	public SubjectStatusBean() {

	}

	public SubjectStatusBean(String subjectStatusId, String status) {
	
		this.subjectStatusId = subjectStatusId;
		this.status = status;
	}

	public String getSubjectStatusId() {
		return subjectStatusId;
	}

	public void setSubjectStatusId(String subjectStatusId) {
		this.subjectStatusId = subjectStatusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	@Override
	public String toString() {
		return "SubjectStatusBean [subjectStatusId=" + subjectStatusId + ", status=" + status + "]";
	}
	
	
}

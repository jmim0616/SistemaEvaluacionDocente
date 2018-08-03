package system.pack.vo;



public class QuestionByPeriodBean {

	private String questionsByPeriodId;
	
	private String department;
	
	private String course;
	
	private String question;
	
	private String academicPeriod;
	
	private String percentage;

	public QuestionByPeriodBean() {

	}

	public QuestionByPeriodBean(String questionsByPeriodId, String department, String course, String question,
			String academicPeriod, String percentage) {
		
		this.questionsByPeriodId = questionsByPeriodId;
		this.department = department;
		this.course = course;
		this.question = question;
		this.academicPeriod = academicPeriod;
		this.percentage = percentage;
	}

	public String getQuestionsByPeriodId() {
		return questionsByPeriodId;
	}

	public void setQuestionsByPeriodId(String questionsByPeriodId) {
		this.questionsByPeriodId = questionsByPeriodId;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAcademicPeriod() {
		return academicPeriod;
	}

	public void setAcademicPeriod(String academicPeriod) {
		this.academicPeriod = academicPeriod;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return "QuestionByPeriodBean [questionsByPeriodId=" + questionsByPeriodId + ", department=" + department
				+ ", course=" + course + ", question=" + question + ", academicPeriod=" + academicPeriod
				+ ", percentage=" + percentage + "]";
	}
	
	
}

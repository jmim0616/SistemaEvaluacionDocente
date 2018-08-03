package system.pack.vo;

import javax.persistence.Column;

import org.hibernate.validator.constraints.NotEmpty;

public class QuestionBean {

	private String questionId;
	
	private String question;

	
	public QuestionBean() {

	}

	public QuestionBean(String questionId, String question) {
		super();
		this.questionId = questionId;
		this.question = question;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	
	@Override
	public String toString() {
		return "QuestionBean [questionId=" + questionId + ", question=" + question + "]";
	}
	
	
}

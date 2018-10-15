package system.pack.fullview;

import java.io.Serializable;

public class Questions implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String question;
	private long response;
	
	public Questions(String question, long response) {
		super();
		this.question = question;
		this.response = response;
	}

	public Questions() {
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public long getResponse() {
		return response;
	}

	public void setResponse(long response) {
		this.response = response;
	}
	
}

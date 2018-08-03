package system.pack.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="questions")
public class QuestionEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int questionId;
	
	@Column
	private String question;
	
	@OneToMany(mappedBy="question")
	@JsonIgnore
	private List<QuestionByPeriodEntity> academicPeriods;

	public QuestionEntity() {

	}
	
	public QuestionEntity(int questionId) {
		this.questionId = questionId;
	}
	
	public QuestionEntity(String question) {
		this.question = question;
	}
	
	
	public QuestionEntity(int questionId, String question) {
		this.questionId = questionId;
		this.question = question;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<QuestionByPeriodEntity> getAcademicPeriods() {
		return academicPeriods;
	}

	public void setAcademicPeriods(List<QuestionByPeriodEntity> academicPeriods) {
		this.academicPeriods = academicPeriods;
	}

	
	@Override
	public String toString() {
		return "QuestionEntity [questionId=" + questionId + ", question=" + question + "]";
	}
	
	
	
	
}

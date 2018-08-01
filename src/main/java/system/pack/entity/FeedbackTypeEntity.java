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
@Table(name="feedback_types")
public class FeedbackTypeEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int feedBackTypeId;
	
	@Column
	private String description;
	
	@OneToMany(mappedBy="feedBackType")
	@JsonIgnore
	private List<CourseFeedbackEntity> courseFeedbacks;
	
	
	public FeedbackTypeEntity() {
		
	}

	public FeedbackTypeEntity(int feedBackTypeId) {
		this.feedBackTypeId = feedBackTypeId;
	}
	
	public FeedbackTypeEntity(String description) {
		this.description = description;
	}

	public FeedbackTypeEntity(int feedBackTypeId, String description) {
		this.feedBackTypeId = feedBackTypeId;
		this.description = description;
	}

	public int getFeedBackTypeId() {
		return feedBackTypeId;
	}

	public void setFeedBackTypeId(int feedBackTypeId) {
		this.feedBackTypeId = feedBackTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CourseFeedbackEntity> getCourseFeedbacks() {
		return courseFeedbacks;
	}

	public void setCourseFeedbacks(List<CourseFeedbackEntity> courseFeedbacks) {
		this.courseFeedbacks = courseFeedbacks;
	}

	@Override
	public String toString() {
		return "FeedbackTypeEntity [feedBackTypeId=" + feedBackTypeId + ", description=" + description + "]";
	}
	
	
	
	
}
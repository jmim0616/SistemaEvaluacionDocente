package system.pack.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class FeedbackTypeBean {
	

	private String feedBackTypeId;

	private String description;
		
	public FeedbackTypeBean () {
		
		
	}

	public FeedbackTypeBean(String feedBackTypeId, String description) {
		this.feedBackTypeId = feedBackTypeId;
		this.description = description;
	}

	public String getFeedBackTypeId() {
		return feedBackTypeId;
	}

	public void setFeedBackTypeId(String feedBackTypeId) {
		this.feedBackTypeId = feedBackTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	@Override
	public String toString() {
		return "FeedbackTypeBean [feedBackTypeId=" + feedBackTypeId + ", description=" + description + "]";
	}


	
}
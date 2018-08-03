package system.pack.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="coursefeedbacks")
public class CourseFeedbackEntity {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int courseFeedBackId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name="feedBackTypeId")
	private FeedbackTypeEntity feedBackType;
	
	@ManyToOne
	@JoinColumn(name="courseId")
	private CourseEntity course;
	
	@Column
	private Date creationDate;
	
	@Column
	private String comment;
	
	@Column
	private Date lastModifiedDate;

	public CourseFeedbackEntity() {

	}
	
	public CourseFeedbackEntity(int courseFeedBackId) {
		this.courseFeedBackId = courseFeedBackId;
	}
	
	public CourseFeedbackEntity(UserEntity user, FeedbackTypeEntity feedBackType,
			CourseEntity course, Date creationDate, String comment, Date lastModifiedDate) {
		this.user = user;
		this.feedBackType = feedBackType;
		this.course = course;
		this.creationDate = creationDate;
		this.comment = comment;
		this.lastModifiedDate = lastModifiedDate;
	}
	
	public CourseFeedbackEntity(int courseFeedBackId, UserEntity user, FeedbackTypeEntity feedBackType,
			CourseEntity course, Date creationDate, String comment, Date lastModifiedDate) {
		this.courseFeedBackId = courseFeedBackId;
		this.user = user;
		this.feedBackType = feedBackType;
		this.course = course;
		this.creationDate = creationDate;
		this.comment = comment;
		this.lastModifiedDate = lastModifiedDate;
	}

	public int getCourseFeedBackId() {
		return courseFeedBackId;
	}

	public void setCourseFeedBackId(int courseFeedBackId) {
		this.courseFeedBackId = courseFeedBackId;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public FeedbackTypeEntity getFeedBackType() {
		return feedBackType;
	}

	public void setFeedBackType(FeedbackTypeEntity feedBackType) {
		this.feedBackType = feedBackType;
	}

	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	
	@Override
	public String toString() {
		return "CourseFeedbackEntity [courseFeedBackId=" + courseFeedBackId + ", user=" + user + ", feedBackType="
				+ feedBackType + ", course=" + course + ", creationDate=" + creationDate + ", comment=" + comment
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}
	

}

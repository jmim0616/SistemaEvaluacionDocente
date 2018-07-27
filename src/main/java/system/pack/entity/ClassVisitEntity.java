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
@Table(name="class_visits")
public class ClassVisitEntity {
	
		@Id
		@Column
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int classVisitId;
		
		@ManyToOne
		@JoinColumn(name="courseId")
		private CourseEntity course;
		
		@Column
		private Date date;
		
		@Column
		private String comment;

		public ClassVisitEntity() {

		}
		
		public ClassVisitEntity(int classVisitId) {
			this.classVisitId = classVisitId;
		}
		
		public ClassVisitEntity(CourseEntity course, Date date, String comment) {
			this.course = course;
			this.date = date;
			this.comment = comment;
		}
	
		public ClassVisitEntity(int classVisitId, CourseEntity course, Date date, String comment) {
			this.classVisitId = classVisitId;
			this.course = course;
			this.date = date;
			this.comment = comment;
		}

		public int getClassVisitId() {
			return classVisitId;
		}

		public void setClassVisitId(int classVisitId) {
			this.classVisitId = classVisitId;
		}

		public CourseEntity getCourse() {
			return course;
		}

		public void setCourse(CourseEntity course) {
			this.course = course;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		
		
		@Override
		public String toString() {
			return "ClassVisitEntity [classVisitId=" + classVisitId + ", course=" + course + ", date=" + date
					+ ", comment=" + comment + "]";
		}
	
		
}

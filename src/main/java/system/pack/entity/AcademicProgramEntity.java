package system.pack.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="academic_programs")
public class AcademicProgramEntity {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int academicProgramId;

	@ManyToOne
	@JoinColumn(name="facultyId")
	private FacultyEntity faculty;
	
	@Column
	private String name;
	
	public AcademicProgramEntity() {
		
	}
	
	public AcademicProgramEntity(int academicProgramId) {
		this.academicProgramId = academicProgramId;
	}
	
	public AcademicProgramEntity(FacultyEntity faculty, String name) {
		this.faculty = faculty;
		this.name = name;
	}


	public AcademicProgramEntity(int academicProgramId, FacultyEntity faculty, String name) {
		this.academicProgramId = academicProgramId;
		this.faculty = faculty;
		this.name = name;
	}

	public int getAcademicProgramId() {
		return academicProgramId;
	}

	public void setAcademicProgramId(int academicProgramId) {
		this.academicProgramId = academicProgramId;
	}

	public FacultyEntity getFaculty() {
		return faculty;
	}

	public void setFaculty(FacultyEntity faculty) {
		this.faculty = faculty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AcademicProgramEntity [academicProgramId=" + academicProgramId + ", faculty=" + faculty + ", name="
				+ name + "]";
	}


	
	
	
	
	
}

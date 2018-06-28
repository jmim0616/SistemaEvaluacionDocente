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
@Table(name="disciplinary_areas")
public class DisciplinaryAreaEntity {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int disciplinaryAreaId;

	@ManyToOne
	@JoinColumn(name="facultyId")
	private FacultyEntity faculty;
	
	@Column
	private String name;
	
	public DisciplinaryAreaEntity() {

	}

	
	public DisciplinaryAreaEntity(int disciplinaryAreaId) {
		this.disciplinaryAreaId = disciplinaryAreaId;
	}
	
	public DisciplinaryAreaEntity(FacultyEntity faculty, String name) {
		this.faculty = faculty;
		this.name = name;
	}

	public DisciplinaryAreaEntity(int disciplinaryAreaId, FacultyEntity faculty, String name) {
		this.disciplinaryAreaId = disciplinaryAreaId;
		this.faculty = faculty;
		this.name = name;
	}

	public int getDisciplinaryAreaId() {
		return disciplinaryAreaId;
	}

	public void setDisciplinaryAreaId(int disciplinaryAreaId) {
		this.disciplinaryAreaId = disciplinaryAreaId;
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
		return "DisciplinaryAreaEntity [disciplinaryAreaId=" + disciplinaryAreaId + ", name=" + name + "]";
	}
	
	
	
}

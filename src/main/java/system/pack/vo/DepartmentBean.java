package system.pack.vo;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class DepartmentBean {
	
	private String departmentId;
	
	@Pattern(regexp="^[a-zA-Z]*$", message="En este campo solo se permiten letras")
	private String name;

	public DepartmentBean () {
		
	
	}

	public DepartmentBean(String departmentId, String name) {
		super();
		this.departmentId = departmentId;
		this.name = name;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "DepartmentBean [departmentId=" + departmentId + ", name=" + name + "]";
	}

	
	
	
	
}
package system.pack.vo;

import java.util.Date;

import javax.validation.constraints.Pattern;

public class AcademicPeriodBean {


	private String academicPeriodId;

	@Pattern(regexp="^[a-zA-Z-][a-zA-Z -]*$", message="El campo \"Nombre\" debe ser diligenciado solo con letras")
	private String name;
	
	@Pattern(regexp="\\d{4}\\-\\d{2}\\-\\d{2}", message="El campo \"Fecha de Inicio\" no cumple el formato adecuado. Ejm: dd/mm/yyyy")
	private String initialDate;

	@Pattern(regexp="\\d{4}\\-\\d{2}\\-\\d{2}", message="El campo \"Fecha de Fin\" no cumple el formato adecuado. Ejm: dd/mm/yyyy")
	private String endDate;

	
	public AcademicPeriodBean() {

	} 
	
	
	public AcademicPeriodBean(String academicPeriodId, String name, String initialDate, String endDate) {
		this.academicPeriodId = academicPeriodId;
		this.name = name;
		this.initialDate = initialDate;
		this.endDate = endDate;
	}


	public String getAcademicPeriodId() {
		return academicPeriodId;
	}


	public void setAcademicPeriodId(String academicPeriodId) {
		this.academicPeriodId = academicPeriodId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getInitialDate() {
		return initialDate;
	}


	public void setInitialDate(String initialDate) {
		this.initialDate = initialDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	@Override
	public String toString() {
		return "AcademicPeriodBean [academicPeriodId=" + academicPeriodId + ", name=" + name + ", initialDate="
				+ initialDate + ", endDate=" + endDate + "]";
	}


}
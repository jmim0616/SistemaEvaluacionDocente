package system.pack.fullview;

import java.io.Serializable;
import java.util.List;

public class Row implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RowHeader rowHeader;
	
	private List<Questions> questions;
	
	public Row(RowHeader rowHeader, List<Questions> questions) {
		super();
		this.rowHeader = rowHeader;
		this.questions = questions;
	}

	public List<Questions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}

	public RowHeader getRowHeader() {
		return rowHeader;
	}

	public void setRowHeader(RowHeader rowHeader) {
		this.rowHeader = rowHeader;
	}

	@Override
	public String toString() {
		return "Row [rowHeader=" + rowHeader + ", questions=" + questions + "]";
	}
	
	
	
}

package system.pack.fullview;

import java.io.Serializable;
import java.util.List;

public class Period implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Row> rows;

	public Period(List<Row> rows) {
		super();
		this.rows = rows;
	}

	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}
	
}

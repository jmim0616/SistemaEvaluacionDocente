package system.pack.fullview;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Period> periods;

	public Data(List<Period> periods) {
		super();
		this.periods = periods;
	}

	public Data() {
		// TODO Auto-generated constructor stub
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}

}

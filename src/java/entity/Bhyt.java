package entity;

import java.io.Serializable;
import java.sql.Date;

public class Bhyt implements Serializable{
	private String id;
	private Date startDate;
	private Date endDate;
	private String type;
	private Date fiveYear;
	public Bhyt() {
		super();
	}
	public Bhyt(String id, Date startDate, Date endDate, String type, Date fiveYear) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.type = type;
		this.fiveYear = fiveYear;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getFiveYear() {
		return fiveYear;
	}
	public void setFiveYear(Date fiveYear) {
		this.fiveYear = fiveYear;
	}
	
	
}

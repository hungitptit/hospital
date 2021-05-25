package entity;

import java.io.Serializable;
import java.sql.Date;

public class Bill implements Serializable{
	private int id;
	private Date dateOfDischarge;
	private Date dateOfAdmission;
	private int amount;
	private Hospital hospital;
	private Disease disease;
	public Bill() {
		super();
	}
	public Bill(int id, Date dateOfDischarge, Date dateOfAdmission, int amount) {
		super();
		this.id = id;
		this.dateOfDischarge = dateOfDischarge;
		this.dateOfAdmission = dateOfAdmission;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
	}
	public Date getDateOfDischarge() {
		return dateOfDischarge;
	}
	public void setDateOfDischarge(Date dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}
	public Date getDateOfAdmission() {
		return dateOfAdmission;
	}
	public void setDateOfAdmission(Date dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public Disease getDisease() {
		return disease;
	}
	public void setDisease(Disease disease) {
		this.disease = disease;
	}
	
	
}

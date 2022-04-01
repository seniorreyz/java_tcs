package com.tcsbpchapter.cuentasymovimientosdemo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movimiento")
public class EMovimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private long CustomerId;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	private String Credit;
	private String Debit;
	private String Remarks;
	public long getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(long customerId) {
		CustomerId = customerId;
	}
	public String getCredit() {
		return Credit;
	}
	public void setCredit(String credit) {
		Credit = credit;
	}
	public String getDebit() {
		return Debit;
	}
	public void setDebit(String debit) {
		Debit = debit;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
}

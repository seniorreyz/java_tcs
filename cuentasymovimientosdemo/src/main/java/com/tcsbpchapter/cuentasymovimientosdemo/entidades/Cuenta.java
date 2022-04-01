package com.tcsbpchapter.cuentasymovimientosdemo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"customerId", "customerName", "accountNumber", "credit", "debit", "movimiento" , "description"})
public class Cuenta {
	@JsonProperty("customerId")
	private long CustomerId;
	@JsonProperty("accountNumber")
	private String AccountNumber;
	@JsonProperty("customerName")
	private String CustomerName;
	@JsonProperty("description")
	private String Description;
	@JsonProperty("credit")
	private String Credit;
	@JsonProperty("debit")
	private String Debit;
	@JsonProperty("movimiento")
	@JsonIgnoreProperties
	private String Movimento;
	public long getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(long customerId) {
		CustomerId = customerId;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
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
	public String getMovimento() {
		return Movimento;
	}
	public void setMovimento(String movimiento) {
		Movimento = movimiento;
	}
	

}

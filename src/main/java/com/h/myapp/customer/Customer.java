package com.h.myapp.customer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tcustomer")
public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	@Column(nullable=false)
	//网名
	private String customerNikeName;
	private String customerName;
	private String customerCountry;
	private String customerEmail;
	private String customerAddress;
	private String customerTel;
	private String customerPostCode;
	private String note="";
	
	
	public Customer() {
		super();
	}


	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public String getCustomerNikeName() {
		return customerNikeName;
	}


	public void setCustomerNikeName(String customerNikeName) {
		this.customerNikeName = customerNikeName;
	}


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getCustomerCountry() {
		return customerCountry;
	}


	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}


	public String getCustomerEmail() {
		return customerEmail;
	}


	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}


	public String getCustomerAddress() {
		return customerAddress;
	}


	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}


	public String getCustomerTel() {
		return customerTel;
	}


	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}


	public String getCustomerPostCode() {
		return customerPostCode;
	}


	public void setCustomerPostCode(String customerPostCode) {
		this.customerPostCode = customerPostCode;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerNikeName=" + customerNikeName + ", customerName="
				+ customerName + ", customerCountry=" + customerCountry + ", customerEmail=" + customerEmail
				+ ", customerAddress=" + customerAddress + ", customerTel=" + customerTel + ", customerPostCode="
				+ customerPostCode + ", note=" + note + "]";
	}

	
}

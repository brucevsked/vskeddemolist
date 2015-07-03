package com.vsked.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerT")
public class Customer implements Serializable {
	
	private static final long serialVersionUID = -7211732718185228891L;
	
	private int customerId;
	private String customerName;
	private String customerShortName;
	private double resisteredCapital;
	
	@Id
	@Column(name="customerId")
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Column(name="customerName")
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	@Column(name="customerShortName")
	public String getCustomerShortName() {
		return customerShortName;
	}
	
	public void setCustomerShortName(String customerShortName) {
		this.customerShortName = customerShortName;
	}
	
	@Column(name="resisteredCapital")
	public double getResisteredCapital() {
		return resisteredCapital;
	}
	
	public void setResisteredCapital(double resisteredCapital) {
		this.resisteredCapital = resisteredCapital;
	}

	public Customer() {
		super();
	}

	public Customer(String customerName, String customerShortName,	double resisteredCapital) {
		super();
		this.customerName = customerName;
		this.customerShortName = customerShortName;
		this.resisteredCapital = resisteredCapital;
	}

	public Customer(int customerId, String customerName,String customerShortName, double resisteredCapital) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerShortName = customerShortName;
		this.resisteredCapital = resisteredCapital;
	}
	
    @Override
    public String toString() {
    	return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerShortName=" + customerShortName + ", resisteredCapital=" + resisteredCapital + "]";
    }

}

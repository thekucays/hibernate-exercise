package com.luki.entities;

import javax.persistence.Embeddable;

@Embeddable

/*
 * class ini ga berdiri sendiri, melainkan sebuah 'value object' yang akan digunakan oleh entity UserDetails
 * 
 * this class doesn't rely on its own. It's a 'value object that will be used by UserDetails entities
 */

public class Address {
	private String street;
	private String city;
	private String state;
	private String pincode; // kode pos LOL 
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}

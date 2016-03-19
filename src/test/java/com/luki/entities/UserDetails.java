package com.luki.entities;

// use this instead of hibernate's annotation class
import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * to generate getters and setters,
 * use ALT+SHIFT+R+S
 * 
 * this tutorial is using annotations, xml mapping coming soon
 */

@Entity
public class UserDetails {
	@Id
	private int userId;
	private String userName;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}

package com.luki;

import org.hibernate.Session;

import com.luki.entities.Address;
import com.luki.entities.UserDetails;
import com.luki.util.SessionFactoryUtil;

public class Tutor11 {
	public static void main(String[] args){
		/*
		 * please note kalo disini ga ada beda dengan Tutor10.java.. bedanya ada di settingan entity UserDetails nya
		 * 
		 * please note that this file is generally similar to Tutor10.java..the difference is in the UserDetails.java entity class..
		 * ..please refer to that file and compare it from the previous commit
		 */
		
		
		// get session from helper class
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		
		UserDetails user = new UserDetails();
		user.setUserName("Sixth User");
		user.setDescription("Sixth description");
		user.setJoinedDate(new java.util.Date());
		
		// creating addresses
		Address homeAddress = new Address();
		homeAddress.setCity("Depok");
		homeAddress.setState("West Java");
		homeAddress.setStreet("Pepaya 1");
		homeAddress.setPincode("16432");
		Address officeAddress = new Address();
		officeAddress.setCity("jakarta");
		officeAddress.setState("West Java");
		officeAddress.setStreet("cisanggiri II");
		officeAddress.setPincode("16430");
		
		// add addresses to user
		user.getListOfAddresses().add(homeAddress);
		user.getListOfAddresses().add(officeAddress);
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
}

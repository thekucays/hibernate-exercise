package com.luki;

import org.hibernate.Session;

import com.luki.entities.Address;
import com.luki.entities.UserDetails;
import com.luki.util.SessionFactoryUtil;

public class Tutor08 {
	public static void main(String[] args){
		// session ambil dari helper
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		
		// no need to set user id (auto generated)
		UserDetails user = new UserDetails();
		user.setUserName("Fifth User");
		user.setDescription("Fifth description");
		user.setJoinedDate(new java.util.Date());
		
		// create address value object for new user
		Address addr = new Address();
		addr.setCity("Depok");
		addr.setState("West Java");
		addr.setStreet("Pepaya 1");
		addr.setPincode("16432");
		user.setAddress(addr);
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
}

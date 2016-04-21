package com.luki;

import org.hibernate.Session;

import com.luki.entities.UserDetails;
import com.luki.util.SessionFactoryUtil;

public class Tutor07 {
	public static void main(String[] args){
		// session ambio dari helper 
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		
		// no need to specify the user id.. because its automatically generated (@GeneratedValue)
		UserDetails user = new UserDetails();
		user.setUserName("Fourth User");
		user.setJoinedDate(new java.util.Date());
		user.setDescription("Fourth Description");
		
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
	}
}

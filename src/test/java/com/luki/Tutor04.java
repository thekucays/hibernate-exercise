package com.luki;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luki.entities.UserDetails;

public class Tutor04 {

	public static void main(String[] args) {
		// create new entity
		UserDetails user = new UserDetails();
		user.setUserId(2);
		user.setUserName("First User");
		user.setJoinedDate(new Date());
		user.setDescription("description of user");
		
		// create SessionFactory.. this will be created only ONCE.. TODO removed to static method
		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		
		// create session to manipulate data
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
}

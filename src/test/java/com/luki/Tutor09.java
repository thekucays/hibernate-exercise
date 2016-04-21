package com.luki;

import org.hibernate.Session;

import com.luki.entities.UserDetails;
import com.luki.util.SessionFactoryUtil;

public class Tutor09 {
	public static void main(String[] args){
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		
		UserDetails user = new UserDetails();
		
		
		/*
		 * Tutorial 09 was temporarily skipped because it's generally similar just like Tutor08.java
		 * please continue to Tutor10.java
		 */
	}
}

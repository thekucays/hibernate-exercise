package com.luki;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.luki.entities.UserDetails;
import com.luki.util.SessionFactoryUtil;

import java.util.*;

/*
 * Retrieving objects tutorial
 */

public class Tutor06 {
	public static void main(String[] args){
		// pake helper yang ada di package util biar lebih simpel
		Session session = SessionFactoryUtil.getSessionFactory().openSession();
		
		UserDetails user = new UserDetails();
		user = null;
		
		session.beginTransaction();
		
		// query satu data.. parameter kedua adalah id nya
		user = (UserDetails) session.get(UserDetails.class, 1);
		System.out.println("user id : " + user.getUserId());
		System.out.println("user name : " + user.getUserName());
		System.out.println("description : " + user.getDescription());
		System.out.println("joined date : " + user.getJoinedDate());
		
		// query semua data pada tabel, bisa pakai createCriteria
		List<UserDetails> daftarUser = session.createCriteria(UserDetails.class).addOrder(Order.asc("userId")).list();
		
		// .., atau pakai HQL (hibernate query)
		Query query = session.createQuery("from UserDetails where userName = :uname");
		query.setParameter("uname", "Second User");
		List<UserDetails> daftar = query.list();
		System.out.println("jumlah data : " + daftar.size());
		
		session.close();
	}
}

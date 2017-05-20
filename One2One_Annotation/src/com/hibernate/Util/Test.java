package com.hibernate.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.DTO.Address;
import com.hibernate.DTO.Student;

public class Test {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");	        
 
	    SessionFactory factory = cfg.buildSessionFactory();
	    Session session = factory.openSession();
 
		Student  s = new Student();
		s.setStudentId(107);
		s.setStudentName("Anuj");
		s.setGrp("das");
 
		Address  ad = new Address();
		ad.setAddressId(7);
		ad.setPlace("Dombivali");
 
		ad.setParent(s);
		Transaction  tx = session.beginTransaction();
		session.save(ad);
		tx.commit();
		session.close();
		System.out.println("One to One with annotations is done..!!!!");
		factory.close();
	}
}

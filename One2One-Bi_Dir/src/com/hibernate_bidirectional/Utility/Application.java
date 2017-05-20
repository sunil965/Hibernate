package com.hibernate_bidirectional.Utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate_bidirectional.DTO.Country;
import com.hibernate_bidirectional.DTO.President;

public class Application {

	public static void main(String[] args) {

		Configuration cfg=new Configuration();
	    cfg.configure("hibernate.cfg.xml");	        
 
	    SessionFactory factory = cfg.buildSessionFactory();
	    Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		President p = new President();
		p.setName("Mr. Pranab Mukharji");
		p.setContact(1236547890);
		p.setMail("pranab.mukhrji@gmail.com");
		
		Country c = new Country();
		c.setName("India");
		c.setLanguage("Hindi");
		c.setPopulation(125300564);
		
		p.setCountry(c);

		c.setPresident(p);
		
		session.persist(c);
		transaction.commit();
		session.close();
		factory.close();
		System.out.println("One to One with annotations is done..!!!!");
	}

}

package com.hibernate.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.dto.Employee;

public class StoreData {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hiber.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
	    Session session=factory.openSession(); 
	      
	    Transaction t=session.beginTransaction();  
	          
	    Employee e1=new Employee();  
	    e1.setId(123);  
	    e1.setFirstName("Jagdish");  
	    e1.setLastName("Patil");  
	      
	    session.persist(e1);  
	      
	    t.commit();				  
	    session.close();  
	      
	    System.out.println("successfully saved");  
		
	}
}

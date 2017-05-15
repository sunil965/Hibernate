package com.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.hibernate.dto.Employee;

public class EmployeeDAO {
	
	public void save(Employee emp) {

		Session session=new AnnotationConfiguration().configure().buildSessionFactory().openSession();  
		      
		    Transaction t=session.beginTransaction();  
		    session.save(emp);  
		    session.persist(emp);
		    session.persist(emp);
		      
		    t.commit();  
		    session.close();  
	}
}

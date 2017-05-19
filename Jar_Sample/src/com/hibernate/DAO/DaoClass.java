package com.hibernate.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.DTO.Student;

import Utilty.MyHibernate;

public class DaoClass {
	public void addStudent(Student s) {
		Session session = MyHibernate.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();
		
		session.save(s);
		System.out.println("hughfjhgfjghk");

		transaction.commit();
		
		System.out.println("Completed");
		session.close();

	}

}

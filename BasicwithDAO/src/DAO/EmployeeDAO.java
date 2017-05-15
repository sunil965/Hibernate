package DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import DTO.EmployeeDTO;

public class EmployeeDAO {

	public void save(EmployeeDTO emp) {

		Configuration cfg = new Configuration().configure();
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(emp);
		transaction.commit();
		session.close();
		factory.close();
	}
}

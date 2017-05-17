package DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import DTO.EmployeeDTO;

public class EmployeeDAO {

	Configuration cfg = new Configuration().configure();
	SessionFactory factory = cfg.buildSessionFactory();
	Session session = factory.openSession();
	Transaction transaction = session.beginTransaction();
				
			// Insert Into DataBase
	public void save(EmployeeDTO emp) {
		session.save(emp);
	}

			// Updating Into DataBase
	public void update(int id, String firstname, String lastname) {
		EmployeeDTO emp = (EmployeeDTO) session.get(EmployeeDTO.class, id);
		emp.setFirstName(firstname);
		emp.setLastName(lastname);
		session.persist(emp);
		System.out.println("Row Updated");
		/*
		 * transaction.commit(); session.close(); factory.close();
		 */
	}
			
			// Deleting From DataBase
	public void delete(int id) {
		EmployeeDTO emp = (EmployeeDTO) session.get(EmployeeDTO.class, id);
		session.delete(emp);
		System.out.println("Row Deleted");
		transaction.commit(); session.close(); factory.close();
		 
	}

			// Retrieve Into DataBase
	public void displayAll() {
		@SuppressWarnings("rawtypes")
		List list = session.createQuery("FROM EmployeeDTO").list();
		for (Object object : list) {
			System.out.println(object);
		}
		System.out.println("All Row Displayed");
	}
	
	public void display(int id) {
		
		Query query = session.createQuery("from EmployeeDTO");
		List<EmployeeDTO> list = query.list();
		for(EmployeeDTO emp : list){
			if(emp.getId()==id){
				System.out.println(emp);
			}
		}
		System.out.println(id +" Row Displayed");
	}

	
}

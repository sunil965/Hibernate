package com.hibernate.utility;

import com.hibernate.dao.EmployeeDAO;
import com.hibernate.dto.Employee;

public class Mainmethod {

	public static void main(String[] args) {

		/*
		 * Session session=new AnnotationConfiguration()
		 * .configure().buildSessionFactory().openSession();
		 * Transaction t=session.beginTransaction();
		 */

		Employee e1 = new Employee();
		e1.setFirstName("sunil");
		e1.setLastName("kumar");

		Employee e2 = new Employee();
		e2.setFirstName("anuj");
		e2.setLastName("sachan");

		Employee e3 = new Employee();
		e3.setFirstName("manoj");
		e3.setLastName("singh");

		EmployeeDAO dao = new EmployeeDAO();
		dao.save(e1);
		dao.save(e2);
		dao.save(e3);

		System.out.println("successfully saved");

		/*
		 * session.persist(e1); session.persist(e2); session.persist(e3);
		 * 
		 * t.commit(); session.close();
		 * System.out.println("successfully saved");
		 */
	}

}

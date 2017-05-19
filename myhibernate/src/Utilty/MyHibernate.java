package Utilty;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyHibernate {

	private MyHibernate(){}

	public static synchronized SessionFactory buildSessionFactory()
	  {
		try { 	return new Configuration().configure().buildSessionFactory();   } 
		
		catch (Throwable ex)
		{
			System.err.println("My SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	  }
	
	private static SessionFactory sessionFactory = buildSessionFactory();
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

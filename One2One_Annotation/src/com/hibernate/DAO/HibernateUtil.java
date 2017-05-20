package com.hibernate.DAO;

import org.hibernate.AnnotationException;
import org.hibernate.SessionFactory;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new AnnotationException().configure().buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Session Factory could not be created." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}

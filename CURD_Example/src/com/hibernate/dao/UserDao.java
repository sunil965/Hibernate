package com.hibernate.dao;

import java.util.*;

import org.hibernate.*;

import com.hibernate.model.User;
import com.hibernate.util.HibernateUtil;

public class UserDao {

	public void addUser(User user) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

	public void deleteUser(int userid) {
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			/*
			 * User user = (User) session.load(User.class, new Integer(userid));
			 * session.delete(user);
			 */

			Query query = session.createQuery("delete from User where id="+userid);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
	}

		// Update Data With Given ID.
	public void updateUser(String email, int id) {
		System.out.println("Update() is called");
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			Query q=session.createQuery("update User set email=:n where id=:i");  
			q.setParameter("n",email);  
			q.setParameter("i",id);  
			int status=q.executeUpdate();  
			System.out.println(status); 
			/*session.update(user);*/
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {
				trns.rollback();
			}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
			System.out.println("Update() is completed");

		}
	}

	public List<User> getAllUsers() {
		System.out.println("AllUsers() is called");
		List<User> users = new ArrayList<User>();
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			users = session.createQuery("from User").list();
			for(User u:users){
				System.out.println(u);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {

			session.close();
			System.out.println("AllUsers() is completed");

		}
		return users;
	}

	public User getUserById(int userid) {
		System.out.println("Single user method is called");
		User user = null;
		Transaction trns = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			trns = session.beginTransaction();
			String queryString = "from User where id = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", userid);
			user = (User) query.uniqueResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
			System.out.println("Single user method is completed");

		}
		return user;
	}
	
	public void selectWhere(int id) {
		System.out.println("SELECT_WHERE STARTS");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trns = null;
		try{
			session.beginTransaction();
			Query query = session.createQuery("select u.firstName, u.lastName, u.email from User u where u.id =:id");
			query.setParameter("id", id);
			Object[] abc = (Object[]) query.uniqueResult();
			System.out.println(abc[0]+"   "+abc[1]+"   "+abc[2]);
		}catch (RuntimeException e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

		System.out.println("SELECT_WHERE STOPED");

	}
}

package com.criteria.DAO;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.criteria.DTO.Stock;

public class Access {

	Configuration cfg = (Configuration) new AnnotationConfiguration().configure();
	SessionFactory factory = (SessionFactory) cfg.buildSessionFactory();
	
	// Add Stock.
	public void addStock(Stock stock) {
		Transaction trns = null;
		Session session = factory.openSession();
		try {
			trns = session.beginTransaction();
			session.save(stock);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (trns != null) {	trns.rollback();}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
			System.out.println("Data Added To Database \n");
		}
	}
	
	
	// Delete Stock.
	public void deleteStock(int id) {
		Transaction trns = null;
		Session session = factory.openSession();
		try {
			trns = session.beginTransaction();
			Query query = session.createQuery("delete from Stock where id=:id");
			query.setParameter("id", id);
			query.executeUpdate();
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if(trns != null){trns.rollback();}
			e.printStackTrace();
		} finally {
			session.flush();
			session.close();
			System.out.println("Data Deleted To Database \n");
		}
	}
	
	// Retrieve Stock.
	public void getDetails(){
		Transaction trns = null;
		Session session = factory.openSession();
		try{
			List<Stock> stock = new ArrayList<Stock>();
			trns = session.beginTransaction();
			stock=session.createQuery("from Stock").list();
			for(Stock s: stock){
				System.out.println(s);
			}
		}
		catch(RuntimeException e){
			if(trns != null){trns.rollback();}
			e.printStackTrace();
		}
		finally{
			session.flush();
			session.close();
			System.out.println("All Data Fetched Database \n");
		}
	}
	
	
	// Get a Row with ID in Stock
	public void getStockById(int id){
		Stock stock = null;
		Transaction trns = null;
		Session session = factory.openSession();
		try{
			trns = session.beginTransaction();
			String queryString = "from Stock where id = :id";
			Query query = session.createQuery(queryString);
			query.setInteger("id", id);
			stock = (Stock) query.uniqueResult();
			System.out.println(stock);
		}
		catch(RuntimeException e){
			if(trns != null){trns.rollback();}
			e.printStackTrace();
		}
		finally{
			session.flush();
			session.close();
			System.out.println("Data Fetched Database \n");
		}
	}
	
	
	// Update Data With Given ID.
	public void update(String stockname, int id){
		Transaction trns = null;
		Session session = factory.openSession();
		try{
			trns = session.beginTransaction();
			Query q=session.createQuery("update Stock set stockname=:n where id=:i");  
			q.setParameter("n",stockname);  
			q.setParameter("i",id);  
			int status=q.executeUpdate();  
			System.out.println(status); 
			session.getTransaction().commit();
		}
		catch(RuntimeException e){
			if(trns != null){trns.rollback();}
			e.printStackTrace();
		}
		finally{
			session.flush();
			session.close();
			System.out.println("Data Updated In Database \n");
		}
	}

	// Details Using Criteria For Ordering In Desc Order.(Restriction can be lt, le, gt, ge or eq).
	public void companyName(){
		Transaction trns = null;
		Session session = factory.openSession();
		try{
			trns = session.beginTransaction();
			Criteria criteria = session.createCriteria(Stock.class).addOrder(Order.desc("company"));
			List list = criteria.list();
			Iterator itr = list.iterator();
			while(itr.hasNext()){
				Stock stock = (Stock) itr.next();
				System.out.println(stock.getCompany());
//				System.out.println(itr.next());
			}
		}
		catch(RuntimeException e){
			if(trns != null){trns.rollback();}
			e.printStackTrace();}
		finally {
			session.close();
			System.out.println("List of Company Name \n");
		}
	}
	
	// Criteria For Ordering in Grater/Equal To Order.
	public void restrictionQuantity(){
		Transaction trns = null;
		Session session = factory.openSession();
		try{
			trns = session.beginTransaction();
			Criteria criteria = session.createCriteria(Stock.class).add(Restrictions.ge("quantity", 100));
			List list = criteria.list();
			Iterator itr = list.iterator();
			while(itr.hasNext()){
				System.out.println(itr.next());
			}
		}
		catch(RuntimeException e){
			if(trns != null){trns.rollback();}
			e.printStackTrace();
			}
		finally {
			session.close();
			System.out.println("Done \n");
		}
	}

	
	// Criteria for Restricting Like Values.
	public void restrictionLike(){
		Transaction trns = null;
		Session session = factory.openSession();
		try{
			trns = session.beginTransaction();
			Criteria criteria = session.createCriteria(Stock.class).add(Restrictions.like("stockname", "Car%"));
			List list = criteria.list();
			Iterator itr = list.iterator();
			while(itr.hasNext()){
				System.out.println(itr.next());
			}
		}
		catch(RuntimeException e){
			if(trns != null){trns.rollback();}
			e.printStackTrace();
			}
		finally {
			session.close();
			System.out.println("Done \n");
		}
	}
	
	// Criteria for Restricting Between Two Values.
	public void restrictionBetween(){
		Transaction trns = null;
		Session session = factory.openSession();
		try{
			trns = session.beginTransaction();
			Criteria criteria = session.createCriteria(Stock.class).add(Restrictions.between("price", 25.0, 75.5));
			List list = criteria.list();
			Iterator itr = list.iterator();
			while(itr.hasNext()){
				System.out.println(itr.next());
			}
		}
		catch(RuntimeException e){
			if(trns != null){trns.rollback();}
			e.printStackTrace();
			}
		finally {
			session.close();
			System.out.println("Done \n");
		}
	}
	
	// Criteria wih Restricting AND,OR.
	public void restrictAndOr(){
		Transaction trns = null;
		Session session = factory.openSession();
		try{
			trns = session.beginTransaction();
			Criteria criteria = session.createCriteria(Stock.class);
			Criterion company = Restrictions.like("stockname", "home%");
			Criterion price = Restrictions.gt("price", 40.0);
			LogicalExpression andExp = Restrictions.and(company, price);
			criteria.add(andExp);
			List list = criteria.list();
			Iterator itr = list.iterator();
			System.out.println(itr.hasNext());
			while (itr.hasNext()) {
				System.out.println("hfhhewih");
				System.out.println(itr.next());
			}
		}
		catch (RuntimeException e) {
			if(trns != null){trns.rollback();}
			e.printStackTrace();
		}
		finally{
			session.close();
			System.out.println("Done \n");
		}
	}
}

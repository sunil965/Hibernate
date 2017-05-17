package Utility;

import java.util.ArrayList;

import org.hibernate.*;
import org.hibernate.cfg.*;

import DAO.Answer;
import DTO.Question;

public class Storedata {
	public static void main(String[] args) {
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Answer answer1 = new Answer();
		answer1.setAnswername("java is a programming language");
		answer1.setPostedBy("Sunil");
		
		 Answer answer2=new Answer();  
		 answer2.setAnswername("java implements oops");  
		 answer2.setPostedBy("Sudhir Kumar");
		
		ArrayList<Answer> list1=new ArrayList<Answer>();
		list1.add(answer1);
		list1.add(answer2);
		
		Question question1 = new Question();
		question1.setQname("Where is Bridgelabz ?");
		question1.setAnswers(list1);
		
		session.save(question1);
		
		
		transaction.commit();
		session.close();
		
		FetchData data = new FetchData();
		data.data();
		
		System.out.println("Task completed");
	}

}

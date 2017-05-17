package Utility;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import DAO.Answer;
import DTO.Question;

public class FetchData {
	
	public void data() {
		// TODO Auto-generated method stub
		Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
		
		Query query = (Query) session.createQuery("from Question");
		List<Question> queList= query.list();
		
		Iterator<Question> queIterator = queList.iterator();
		while (queIterator.hasNext()) {
			Question question = queIterator.next();
			System.out.println("Question is : "+question.getQname());
			
			List<Answer> ansList = question.getAnswers();
			Iterator<Answer> ansIterator = ansList.iterator();
			while (ansIterator.	hasNext()) {
				System.out.println(ansIterator.next());
				System.out.println("............**..........");
			}
			
		}
		session.close();
		System.out.println("Fetching data done.");
	}

}

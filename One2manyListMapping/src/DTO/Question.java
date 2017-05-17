package DTO;

import java.util.List;

import DAO.Answer;

public class Question {
	public Question(){
		
	}
	private int id;
	private String qname;
	private List<Answer> answers;
	
	public Question(int id, String qname, List<Answer> answers) {
		super();
		this.id = id;
		this.qname = qname;
		this.answers = answers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	

}

package DTO;

public class Answer {

	private int id;
	private String answername;
	private String postedBy;

	public Answer() {
	}

	public Answer(int id, String answername, String postedBy) {
		super();
		this.id = id;
		this.answername = answername;
		this.postedBy = postedBy;
	}

	/*@Override
	public String toString() {
		return "Answer [id=" + id + ", answername=" + answername + ", postedBy=" + postedBy + "]";
	}*/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswername() {
		return answername;
	}

	public void setAnswername(String answername) {
		this.answername = answername;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}
	
    public String toString(){
    	return answername+" by: "+postedBy; 
    	}
	 

}

package DTO;

public class EmployeeDTO {

	private int id;
	@Override
	public String toString() {
		return "Id = " + id + ", FirstName = " + firstName + ", lastName = " + lastName;
	}
	private String firstName, lastName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}

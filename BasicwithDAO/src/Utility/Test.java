package Utility;

import DAO.EmployeeDAO;
import DTO.EmployeeDTO;

public class Test {

	public static void main(String[] args) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setId(2);
		dto.setFirstName("Sunil");
		dto.setLastName("Kumar");
		
		EmployeeDAO dao = new EmployeeDAO();
		dao.save(dto);
		System.out.println("saved sucessfully");
	}

}

package Utility;

import DAO.EmployeeDAO;
import DTO.EmployeeDTO;

public class Test {

	public static void main(String[] args) {
		EmployeeDTO dto = new EmployeeDTO();
		/*dto.setId(3);*/
		dto.setFirstName("Anil");
		dto.setLastName("Sunil");
		
		EmployeeDAO dao = new EmployeeDAO();
		dao.save(dto);
		dao.displayAll();
		dao.update(1, "SSSSS", "PPPP");
		dao.delete(5);
		dao.displayAll();
		dao.display(3);
		System.out.println("Done sucessfully");
	}

}

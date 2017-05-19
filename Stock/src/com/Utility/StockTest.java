package com.Utility;

import com.criteria.DAO.Access;
import com.criteria.DTO.Stock;

public class StockTest {

	public static void main(String[] args) {
		Access access = new Access();
		
		Stock stock = new Stock();
		stock.setCompany("SBI");
		stock.setStockname("Home_Loan");
		stock.setPrice(15.50);
		stock.setQuantity(200);
		access.addStock(stock);
		
//		access.deleteStock(2);
		
//		access.getDetails();
		
//		access.getStockById(5);
		
//		access.update("Car_Loan", 5);
		
//		access.companyName();
		
//		access.restrictionQuantity();
		
//		access.restrictionLike();
		
//		access.restrictionBetween();
		
//		access.restrictAndOr();
	}

}

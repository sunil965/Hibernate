package com.hibernate.main;

import com.hibernate.dao.UserDao;
import com.hibernate.model.User;

public class App {

	public static void main(String[] args) {
		UserDao dao = new UserDao();

		// Add new user
		User user = new User();
		user.setFirstName("Manoj");
		user.setLastName("Pawne");
		user.setEmail("amit@gmail.com");
		// dao.addUser(user);

		// Update user with HQL Query
//		dao.updateUser("manoj@yahoo.com", 1);

		// Update user with Without HQL Query
		/*
		 * user.setEmail("sunil@updatedJdbc.com");
		 * user.setUserid(1);
		 * dao.updateUser(user);
		 */

		// Delete user
		// dao.deleteUser(4);

		// Get all users with HQL Query
		dao.getAllUsers();

		// Get all users without HQL Query
		/*
		 * for (User iter : dao.getAllUsers()) { System.out.println(iter); }
		 */

		// Get user by id
		/*
		 * System.out.println(dao.getUserById(8));
		 */
		
		dao.selectWhere(1);

	}

}

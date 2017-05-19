package com.hibernate.Utility;

import com.hibernate.DAO.DaoClass;
import com.hibernate.DTO.Student;

public class Execute {
	public static void main(String[] args) {
		Student student = new Student();
		student.setName("Aarav");
		
		Student student1 = new Student();
		student1.setName("Angel");
//		
		DaoClass class1 = new DaoClass();
//		class1.addStudent(student);
		class1.addStudent(student1);

	}
}

package com.student.management;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
	static Connection con;
public static Connection createc() {
	try {
		//load the driver//
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//create the connection/
		String url="jdbc:mysql://localhost:3306/student_m";
		String user="root";
		String password="SHI123VA45";
		con=DriverManager.getConnection(url,user,password);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return con;
	
}
}

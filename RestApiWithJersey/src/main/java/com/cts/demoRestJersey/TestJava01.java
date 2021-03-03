package com.cts.demoRestJersey;

import java.sql.*;

public class TestJava01 {

	public static void main(String[] args) {
		//For MySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb?useSSL=false", "root","Yogesh$12345");
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}

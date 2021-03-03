package com.cts.demoRestJersey;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.cts.model.Alien;

public class AlienRepository {

	Connection con = null;
	public AlienRepository() {

		try {
			
			//For MySQL
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restdb?useSSL=false", "root","Yogesh$12345");
			
			
			//For ORACLE
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl.cts.com", "SYSTEM","Yogesh$12345");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from alien");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Alien> getAlienList() {
		List<Alien> alienList = new ArrayList<>();
		Alien a1 = null;
		String sql = "select * from alien";

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				a1 = new Alien();
				a1.setId(rs.getInt(1));
				a1.setName(rs.getString(2));
				a1.setPoints(rs.getInt(3));
				alienList.add(a1);
			}
			return alienList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return alienList;
	}

	public Alien getAlienById(int id) {
		Alien a1 = null;
		String sql = "select * from alien where id="+id;

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			 if(rs.next()) {
				a1 = new Alien();
				a1.setId(rs.getInt(1));
				a1.setName(rs.getString(2));
				a1.setPoints(rs.getInt(3));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a1;
	}

	public String createAlien(Alien a1) {
		String sql = "insert into alien values(?,?,?)";

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,a1.getId());
			stmt.setString(2,a1.getName());
			stmt.setInt(3, a1.getPoints());
			Integer result = stmt.executeUpdate();
			if(result!=0)
				return "Created Succesfully!!";

		} catch (SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "Failed";
	}

	public String updateAlien(Alien a1) {
		String sql = "update alien set name=? , points=? where id="+a1.getId();

		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,a1.getName());
			stmt.setInt(2, a1.getPoints());
			Integer result = stmt.executeUpdate();
			if(result!=0)
				return "Updated Succesfully!!";

		} catch (SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "Failed";
	}

	public String deleteAlien(int id) {
		String sql = "delete from alien where id="+id;

		try {
			Statement stmt = con.createStatement();
			Boolean result = stmt.execute(sql);
			if(result)
				return "Deleted Succesfully!!";

		} catch (SQLException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "Failed";
		
	}
}

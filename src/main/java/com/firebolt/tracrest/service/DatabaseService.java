package com.firebolt.tracrest.service;

import java.sql.Connection;
import java.sql.DriverManager;



public class DatabaseService {

	Connection con = null;
	
	DatabaseService(){
		String url = "jdbc:mysql://localhost:3306/tracdb";
		String username = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, password);
		}catch(Exception e) {e.printStackTrace();}
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	
	
}

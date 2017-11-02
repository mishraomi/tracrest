package com.firebolt.tracrest.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.firebolt.tracrest.model.User;

public class UserService {
	
	Connection connection;
	DatabaseService databaseService;
	
	public UserService(){
		databaseService = new DatabaseService();
		connection = databaseService.getCon();
	}
	
	public ArrayList<User> getAllUsers(){
		ArrayList<User> allUserList = new ArrayList<>();
		String sql = "select * from user";
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				allUserList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
		} catch (SQLException e) {e.printStackTrace();}
		
		return allUserList;
	}

	public User createUser(User user){
		String sql = "insert into user values (?,?,?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, user.getId());
			st.setString(2, user.getName());
			st.setString(3, user.getEmail());
			st.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return user;
	}

	public User getUser(int id){
		User user = null;
		try {
		String sql = "select * from user where id="+id;
		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
			if(rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}

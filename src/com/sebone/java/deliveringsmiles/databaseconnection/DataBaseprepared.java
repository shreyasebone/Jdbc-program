package com.sebone.java.deliveringsmiles.databaseconnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseprepared {
	String DB_url="jdbc:mysql://127.0.0.1:3306/driver";
	String user="root";
	String password="Paliwal@123";
	
	
	public UserDataSql getUserData(int driver_id,String driver_name,String driver_contact_no){
		UserDataSql userDataSql =new UserDataSql();
		userDataSql.setDriver_id(driver_id);
		userDataSql.setDriver_name(driver_name);
		userDataSql.setDriver_contact_no(driver_contact_no);
		return userDataSql;	
	}
	public List<UserDataSql> getConnection(int driver_id) throws SQLException{
		Connection con=null;
		ArrayList<UserDataSql> list=new ArrayList<UserDataSql>();
		try {
			String query="select driver_id,driver_name,driver_contact_no from registration_table where driver_id=? ";
			con=DriverManager.getConnection(DB_url, user, password);
			PreparedStatement statement=con.prepareStatement(query);
			statement.setInt(1, driver_id);
			ResultSet rs=statement.executeQuery();
			while(rs.next()) {
				DataBaseprepared dataBaseprepared=new DataBaseprepared();
				list.add(dataBaseprepared.getUserData(rs.getInt("driver_id"),rs.getString("driver_name"),rs.getString("driver_contact_no")));
				}
		}catch(SQLException e) {
			e.getStackTrace();
		}finally {
			con.close();
		}
		return list;
		
	}
	public static void main(String[] args) throws SQLException {

		DataBaseprepared dataBaseprepared=new DataBaseprepared();
		List<UserDataSql> list1=dataBaseprepared.getConnection(105);
		for(UserDataSql u:list1) {
			System.out.println(u.getDriver_id()+" "+u.getDriver_contact_no()+" "+u.getDriver_name());
		}
	}
}

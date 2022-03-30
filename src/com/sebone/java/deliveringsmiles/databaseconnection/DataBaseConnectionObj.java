package com.sebone.java.deliveringsmiles.databaseconnection;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DataBaseConnectionObj {
	String DB_url="jdbc:mysql://127.0.0.1:3306/driver";
	String user="root";
	String password="Paliwal@123";
	public UserDataSql getUserData(int driver_id,String driver_name,String driver_contact_no) {
		UserDataSql userDataSql=new UserDataSql();
		userDataSql.setDriver_id(driver_id);
		userDataSql.setDriver_name(driver_name);
		userDataSql.setDriver_contact_no(driver_contact_no);
		return userDataSql;	
	}
	public List<UserDataSql> getDriverDetails() throws SQLException{
		Connection con=null;
		ArrayList<UserDataSql> list =new ArrayList<UserDataSql>();
		try {
			 con=DriverManager.getConnection(DB_url, user, password);
			 Statement statement=con.createStatement();
			 ResultSet rs=statement.executeQuery("select driver_id,driver_name,driver_contact_no from registration_table");
			 while(rs.next()) {
				DataBaseConnectionObj obj=new DataBaseConnectionObj();
				list.add(obj.getUserData(rs.getInt("driver_id"),rs.getString("driver_name"),rs.getString("driver_contact_no")));
			 }
		}catch(SQLException e) {
			e.printStackTrace();	
		}finally {
			con.close();
		}
		return list;
	}
	public static void main(String[] args) throws SQLException {
		DataBaseConnectionObj dataBaseConnectionObj=new DataBaseConnectionObj();
		List<UserDataSql> list1 =dataBaseConnectionObj.getDriverDetails();
		for(UserDataSql u:list1) {
			System.out.println(u.getDriver_id()+" "+u.getDriver_name()+" "+u.getDriver_contact_no());
		}
	}
}

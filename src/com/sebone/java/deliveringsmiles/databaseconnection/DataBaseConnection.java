package com.sebone.java.deliveringsmiles.databaseconnection;

import java.sql.*;

import com.mysql.cj.protocol.Resultset;

public class DataBaseConnection {
	String DB_url="jdbc:mysql://127.0.0.1:3306/driver";
	String user="root";
	String password="Paliwal@123";
	
	public static void main(String[] args) throws SQLException {
		Connection con = null;
		DataBaseConnection dataBaseConnection=new DataBaseConnection();
		try {
			//class.forName("com.mysql.jdbc.driver");
			con=DriverManager.getConnection(dataBaseConnection.DB_url, dataBaseConnection.user,dataBaseConnection.password);
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery("SELECT driver_id,driver_name,driver_contact_no,driver_email FROM registration_table");
			while(rs.next()) {
				System.out.println("ID="+rs.getInt("driver_id"));
				System.out.println("Name="+rs.getString("driver_name"));
				System.out.println("contactNo"+rs.getString("driver_contact_no"));
			}	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {

			con.close();
		}
	}
}

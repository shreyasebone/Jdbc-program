package com.sebone.java.deliveringsmiles.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedUpdateStatement {
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String DB_url="jdbc:mysql://127.0.0.1:3306/driver";
		String user="root";
		String password="Paliwal@123";
		UserDataSql userDataSql=new UserDataSql();
		Connection con=null;
		try {
			String query="update registration_table set driver_name=? where driver_id=?";
			con=DriverManager.getConnection(DB_url, user, password);
			PreparedStatement ps=con.prepareStatement(query);
			Scanner sc=new Scanner(System.in);
			
			while(true) {
				System.out.println("enter driver id");
				int driver_id=sc.nextInt();
				sc.nextLine();
//				sc.nextInt();
				ps.setInt(2,driver_id);
				System.out.println("enter driver name");
				String driver_name=sc.nextLine();
//				sc.nextLine();
				ps.setString(1,driver_name);
				int count = ps.executeUpdate();
				System.out.println("do you want to update more "+count);
				String option=sc.nextLine();
				if(option.equalsIgnoreCase("no")) {
					break;
				}
			}
		}catch(SQLException e) {
			e.getStackTrace();
		}finally {
			con.close();	
		}
	}

}

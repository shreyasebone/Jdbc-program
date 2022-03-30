package com.sebone.java.deliveringsmiles.databaseconnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class preparedStatement {
	static String DB_url="jdbc:mysql://127.0.0.1:3306/driver";
	static String user="root";
	static String password="Paliwal@123";
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			con=DriverManager.getConnection(DB_url, user, password);
			String query="insert into vehicle_table values(?,?,?,?)";
			PreparedStatement prestatement=con.prepareStatement(query);
			Scanner sc=new Scanner(System.in);
			while(true) {
				System.out.println("Enter the value of vehicle_id");
				int vehicle_id=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the value of vehicle_name");
				String vehicle_name=sc.nextLine();
				System.out.println("Enter the value of vehicle_no");
				int vehicle_no=sc.nextInt();
				System.out.println("Enter the value of driver_id");
				int driver_id=sc.nextInt();
				sc.nextLine();
				prestatement.setInt(1,vehicle_id);
				prestatement.setString(2,vehicle_name);
				prestatement.setInt(3,vehicle_no);
				prestatement.setInt(4,driver_id);
				prestatement.executeUpdate();
				System.out.println("do you want to insert");
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

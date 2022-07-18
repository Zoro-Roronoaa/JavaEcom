package com.databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EnterUserData {
	public static String username=null;
	public void getUserData() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Register Here");
		try {

			ConnectionUtility obj = new ConnectionUtility();

			Connection con = obj.getConnection();
			String query = "insert into UserRegistration(UserFirstName,UserLastName,UserContactNo,UserCity)values(?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);

			System.out.println("Enter your First Name");
			String uFirstName = sc.next();
			username=uFirstName;
			System.out.println("Enter your Last Name");
			String uLastName = sc.next();
			System.out.println("Enter your Mobile Number=");
			long mobileNo = sc.nextLong();
          String regex = "\\d{10}";
		        Pattern pattern = Pattern.compile(regex);
			     Matcher matcher = pattern.matcher(mobileNo );
			      if(matcher.matches()) {
			         System.out.println("Given phone number is valid");
			      } else { 
			         System.out.println("Given phone number is not valid");
			      }
			System.out.println("Enter Your City");
			String uCity = sc.next();

			stmt.setString(1, uFirstName);
			stmt.setString(2, uLastName);
			stmt.setLong(3, mobileNo);
			stmt.setString(4, uCity);
			stmt.executeUpdate();
			System.out.println("User Data Entered Successfully");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

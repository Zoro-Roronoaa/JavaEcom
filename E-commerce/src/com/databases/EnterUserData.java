package com.databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EnterUserData /*This class is used for to do user registration and user entered data is tored in UserRegistration database*/
{
	public static String username=null;
	public void getUserData()  //This method used to get user data
     {   
		Scanner sc = new Scanner(System.in);
		System.out.println("Register Here");
		try {

			ConnectionUtility obj = new ConnectionUtility();

			Connection con = obj.getConnection();
			String query = "insert into UserRegistration(UserFirstName,UserLastName,UserContactNo,UserCity)values(?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);

			System.out.println("Enter your First Name");       //By Using Scanner class we can take data from user
			String uFirstName = sc.next();
			username=uFirstName;
			System.out.println("Enter your Last Name");
			String uLastName = sc.next();
			System.out.println("Enter your Mobile Number=");
			long mobileNo = sc.nextLong();
          String regex = "\\d{10}";                         /* This code is used to to validate mobile number if user enter less than 10 digit or greater than 10 digit mobile number it will check that*/
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

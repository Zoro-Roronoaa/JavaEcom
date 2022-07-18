package com.MAINM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.databases.ConnectionUtility;

public class Admin {
//creating new class Admin 
	
	 
	                 public void UserHistory() {                 //Method created which is use to select the userHistoty table from database Ecommerce

		 ConnectionUtility obj= new ConnectionUtility();       //Accessing connection method from outside
		
		   PreparedStatement ps=null;
		
		try {
			
			       Connection con=obj.getConnection();
			ps = con.prepareStatement("select * from UserHistory ");        //select query in prepareStatement object

			ResultSet rs = ps.executeQuery();       //selecting Resultset which is use to print the table content

			while (rs.next()) {

				System.out.println("User_id=" + rs.getInt(1));
				System.out.println("Product_id =" + rs.getInt(2));
				System.out.println("Product_Name=" + rs.getString(3));   //printing the satatements using while loop
				System.out.println("Quantity=" + rs.getInt(4));
                                System.out.println("------------------------------------------------------------------");
			}

			con.close();
			ps.close();             
			rs.close();
		} catch (Exception e) {              //catch the exception using try catch block
			e.printStackTrace();
		}
	}

	     
	  public void ProductDetails()  {    //Method created which is use to select the Product table from database Ecommerce

        ConnectionUtility obj= new ConnectionUtility();    //Accessing connection method from outside
		
		PreparedStatement ps=null;
		
		try {
			
			Connection con=obj.getConnection();
	             ps=con.prepareStatement("select * from products ");  //select query in prepareStatement object

		ResultSet rs=ps.executeQuery();         //selecting Resultset which is use to print the table content
		
		while(rs.next()) {
			
			System.out.println("Product_id="+rs.getInt(1));
			System.out.println("Descrpition ="+rs.getString(2));
			System.out.println("Price="+rs.getInt(3));
			System.out.println("Product_Name="+rs.getString(4));      //printing the satatements using while loop
			System.out.println("Quanity="+rs.getInt(5));
			System.out.println("------------------------------------------------------------------");
		}
		con.close();
		ps.close();        
		rs.close();

		}
		catch(Exception e) {
			e.printStackTrace();           //catch the exception using try catch block
			}
	   }
	  
	  public void UseRegistration() {              //Method created which is use to select the UserRegistration table from database Ecommerce

		  
			ConnectionUtility obj= new ConnectionUtility();     //Accessing connection method from outside
		
		          PreparedStatement ps=null;
			
			try {
				
			Connection con=obj.getConnection();

		      ps=con.prepareStatement("select * from UserRegistration");     //select query in prepareStatement object

			ResultSet rs=ps.executeQuery();                                //selecting Resultset which is use to print the table content

			
			while(rs.next()) {
				System.out.println("UserId="+rs.getInt(1));
				System.out.println("UserFirstName ="+rs.getString(2));
				System.out.println("UserLastName="+rs.getString(3));
                                 System.out.println("UserContactNo="+rs.getLong(4));            //printing the satatements using while loop
                                 System.out.println("UserCity="+rs.getString(5));
                         System.out.println("------------------------------------------------------------------");
				
			}
			
			con.close();
			ps.close();
			rs.close();

		   }
			catch(Exception e) {                             //catch the exception using try catch block
				e.printStackTrace();
				}
		   }
		  
		  
	  
	  public void GetDatabase()  {              //GateDatabase method created for Accessing the above created methods

		Admin admin = new Admin();

		Scanner sc = new Scanner(System.in);   //Scanner Class is used to take input 

		System.out.println( "Enter the Required Details ,1:ProductDeatils 2:UserRegsistration 3: UserHistory:1 or 2, or  3");//taking input in the form of 1,2,3.
		int data = sc.nextInt();



		int a = 1;
		int b = 2;
		int c = 3;

		switch (data) {     //switch statement is used to selct the methods as per the input.
		case 1:
			if (a == data) {

				admin.ProductDetails();
				break;

			}
		case 2:
			if (b == data) {

				admin.UseRegistration();
				break;

			}
		case 3:
			if (c == data) {

				admin.UserHistory();
				break;

			}
		}
	}
	   	  
	   	
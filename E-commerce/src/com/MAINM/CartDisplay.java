package com.MAINM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.databases.ConnectionUtility;

public class CartDisplay {

	public void cartDisplay(String username) {
		ConnectionUtility obj=new ConnectionUtility();
		try {
			Connection con=obj.getConnection();
			PreparedStatement ps=con.prepareStatement("Select ProductName,Quantity from userhistory where username="+"'"+username+"'");
			ResultSet rs=ps.executeQuery();
			 System.out.println("|ProductName    |     Quantity|");//sop to print
			 System.out.println("|-----------------------------|");
			while(rs.next()) {
System.out.println(rs.getString("ProductName"));
     System.out.print("                    ");
	     System.out.print(rs.getInt("Quantity"));
				System.out.println("");
			}
			ps.execute();
			rs.close();
			ps.close();
			con.close();
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}

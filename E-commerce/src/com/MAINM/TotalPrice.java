package com.MAINM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.databases.ConnectionUtility;

public class TotalPrice {

	public int totalcalculator(int productId, int quantity) throws Exception {
			
		int a=0;//Stores total price of bought product
		ConnectionUtility obj=new ConnectionUtility();
		Connection con=obj.getConnection();//create database connection
		PreparedStatement stmt=con.prepareStatement("select Price from Products where Product_id="+productId);//Enter query for updating database
		ResultSet rs=stmt.executeQuery();//execute query
		while(rs.next()) {
			a=quantity*rs.getInt("Price");//get price of specified product Id
			
		}
		rs.close();
		stmt.close();
		con.close();
		return a;
			
			

		}

	}



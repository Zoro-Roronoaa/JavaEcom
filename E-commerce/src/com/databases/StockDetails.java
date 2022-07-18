package com.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StockDetails {

	public void getStockUpdate(int purchaseQty, int Product_id) {       //Method is Createdfor getting the stock details by taking input
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		
		int b=0;          //creating local variable for storing the updated stock quantity basesd on entered Product_id

		try {
			ConnectionUtility obj=new ConnectionUtility();        //Accessing connection method from outside
			Connection con=obj.getConnection();
			ps = con.prepareStatement("Select Quantity from products where Product_id=" + Product_id);  
                       //select query is used to get product quauntity based on the product id entered

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				 b =(rs.getInt("Quantity")- purchaseQty);        //storing the updated stock into the local var b
				 //System.out.println(b);
				
			}
			
     		ps1= con.prepareStatement("update products set Quantity=? where Product_id=?");  //with the help of update query stock is updated for respectived product id
			ps1.setInt(1, b);
			ps1.setInt(2,Product_id);  //setting the quantity ,product id
		      int i=ps1.executeUpdate();
		      
		  	//System.out.println("Step 5");
			
			//System.out.println("Table Updated");
			
		      }
	
		catch (Exception e) {
			e.printStackTrace();      //Exception is handled using try catch block
		

	}
	}
}

	

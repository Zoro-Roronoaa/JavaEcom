package com.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StockDetails {

	public void getStockUpdate(int purchaseQty, int Product_id) {
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		
		int b=0;

		try {
			ConnectionUtility obj=new ConnectionUtility();
			Connection con=obj.getConnection();
			ps = con.prepareStatement("Select Quantity from products where Product_id=" + Product_id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				 b =(rs.getInt("Quantity")- purchaseQty);
				 //System.out.println(b);
				
			}
			
     		ps1= con.prepareStatement("update products set Quantity=? where Product_id=?");
			ps1.setInt(1, b);
			ps1.setInt(2,Product_id);
		      int i=ps1.executeUpdate();
		      
		  	//System.out.println("Step 5");
			
			//System.out.println("Table Updated");
			
		      }
	
		catch (Exception e) {
			e.printStackTrace();
		

	}
	}
}

	

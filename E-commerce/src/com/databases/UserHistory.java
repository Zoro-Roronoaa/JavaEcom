package com.databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserHistory {

	public void storepurchase(String username, int productId, int quantity) throws Exception {
		String productName=null;
		ConnectionUtility obj = new ConnectionUtility();
		Connection con = obj.getConnection();
		PreparedStatement stmt=con.prepareStatement("select Product_Name from Products where Product_id="+productId);
		ResultSet rs=stmt.executeQuery();
		while(rs.next()) {
			productName=rs.getString("Product_Name");
			
		}
		rs.close();
		stmt.close();
		
		
		
		String query="insert into UserHistory(UserName,ProductName,Quantity)values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,username );
		ps.setString(2, productName);
		ps.setInt(3, quantity);
		ps.execute();
		ps.close();
		con.close();
	}
	
	

}

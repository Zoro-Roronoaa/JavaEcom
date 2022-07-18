package com.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//This class acts as a utility class for creating future connections with database
public class ConnectionUtility {
	
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con=null;
		Class.forName("com.mysql.cj.jdbc.Driver");// import class
		String url="jdbc:mysql://localhost:3306/ecom";//set url
		String username="root";//set user
		String pass="Aniket*1@";//enter password
		con= DriverManager.getConnection(url,username, pass);//Establish connection with given database url
		return con;
	}
	
	

}

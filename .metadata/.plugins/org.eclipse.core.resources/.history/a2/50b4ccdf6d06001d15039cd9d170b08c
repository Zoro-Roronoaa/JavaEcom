package com.MAINM;

import java.sql.SQLException;
import java.util.Scanner;

import com.databases.*;
import com.databases.ProductDetails;

//This class contains methods for  performing the purchase functions.
public class Customer extends EnterUserData {

	public void userDetails() {

		EnterUserData obj = new EnterUserData();
		obj.getUserData();//call the method to register user

	}

	public void display() throws Exception {

		ProductDetails obj = new ProductDetails();
		obj.getProductDetails();//call the method to display product list

	}

	public void carting() throws Exception//purchasing procedure 
	{
		int total = 0;//Initialize variable to store total cost of products 
		String i = "Y";//Decision variable for adding more products
		String usname=username;//get current username
		Scanner sc = new Scanner(System.in);
		while (i.equals("Y"))//loop for performing purchase orders
		{
			System.out.println("Enter Product_ID to buy");
			int productId = sc.nextInt();//store productId
			System.out.println("Enter Quantity");
			int quantity = sc.nextInt();//store product quantity
			TotalPrice obj = new TotalPrice();// create instance of total calculating class
			total = total + obj.totalcalculator(productId, quantity);//calculate total of cart 
			StockDetails obj2 = new StockDetails();// update quantity in stock database
			obj2.getStockUpdate(quantity, productId);
			UserHistory obj3=new UserHistory();//store purchase history of user
			obj3.storepurchase(username, productId, quantity);
			System.out.println("Want to buy more? Y/N");
			String terminator =sc.next();//stores deciding variable
			i=terminator;//set while loop 
		}
		//displayitems(username);
		
		System.out.println("Total Cart Value is>>>> "+total);
		System.out.println("Thankyou for shopping with us.");

	}

}

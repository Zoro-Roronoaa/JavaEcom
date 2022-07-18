package com.MAINM;

import java.util.Scanner;
//This class divides the program flow between user and admin.

public class IdentifieR {

	public void UserIdentifier() throws Exception {

		Scanner sc = new Scanner(System.in);

		System.out.println("Are you a customer or admin?");
		System.out.println("Enter 1 for Customer or 2 for Admin");
		int check = sc.nextInt();
		if (check == 1)//Check whether user or admin
		{

			Customer cus = new Customer();
			cus.userDetails();//Provide Registration form
			cus.display();// Display product list
			cus.carting();//Purchase procedures
			

		} else if (check == 2) {
			Admin adm=new Admin();
			adm.GetDatabase();//Links to admin procedures

		} else {

			System.out.println("Invalid Input");
			UserIdentifier();//ask again
			

		}

	}

}

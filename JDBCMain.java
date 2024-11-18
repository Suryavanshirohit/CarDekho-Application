
package com.qspiders.cardekhojdbc.validation;

import java.util.Scanner;

public class JDBCMain {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("WELCOME TO CARDEKHO APPLICATION");
		boolean flag = true;
		while (flag) {
			System.out.println("Select the following option\n    1.SignUp\n    2.LogIn\n    3.Exit");
			int choice =scanner.nextInt();
			switch (choice) {
			case 1:
				JDBCService.signUp(scanner);
	 			break;
			case 2:
				JDBCService.logIn(scanner);
				break;
			case 3:
				System.err.println("Thank You");
				flag= false;
				break;

			default:
				break;
			}
			
		}
	}

}

package com.qspiders.cardekhojdbc.main;


import java.util.Scanner;

import com.qspiders.cardekhojdbc.caroperations.CarOperations;

public class CarMain {

	public static void mainCardekho() {
		

		CarOperations carOp = new CarOperations();
		// Car car = new Car();

		boolean flag = true;
		while (flag) {
			System.out.println("1.View All Cars\n" + "2.Search Cars\n" + "3.Add Car\n" + "4.Remove Car\n"
					+ "5.Edit car \n" + "6.Exit\n");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("View All Cars");
				carOp.ViewAllCars();
				break;
			}
			case 2: {
				System.out.println(
						"1. Search By Id\n" + "2. Search By Name\n" + "3. Search By Model\n" + "4. Search By Price\n"
								+ "5. Search By Color\n" + "6. Search By Brand\n" + "7. Search By FuleType\n");
				int choice1 = scanner.nextInt();
				switch (choice1) {
				case 1: {
					System.out.println("===Search By Id===");
					carOp.SearchCarById();
					break;
				}
				case 2: {
					System.out.println("===Search By Name===");
					carOp.SearchCarByName();

					break;
				}
				case 3: {
					System.out.println("===Search By Model===");
					carOp.SearchByModel();
					break;
				}
				case 4: {
					System.out.println("===Search By Price===");
					carOp.SearchByPrice();
					break;				
				}
				case 5: {
					System.out.println("===Search By Color===");
					carOp.SearchByColor();
					break;
				}
				case 6: {
					System.out.println("===Search By Brand");
					carOp.SearchByBrand();
					break;
				}
				case 7: {
					System.out.println("===Search By FuleType");
					carOp.SearchByFuleType();
					break;
				}
				default: {
					System.out.println("Invalid Input");
				}
				}
				break;
			}
			case 3: {
				System.out.println("Add New Car");
				carOp.CarAdd();
				break;
			}
			case 4: {
				System.out.println("Remove Car");
				carOp.removeCar();
				break;
			}
			case 5: {
				System.out.println("Edit Car");
				carOp.editCar();
				break;
			}
			case 6: {
				System.out.println("Thank You!");
				flag = false;
				break;
			}
			default: {
				System.out.println("Invalid Input");
			}

			}
		}
	}
}

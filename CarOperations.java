package com.qspiders.cardekhojdbc.caroperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CarOperations {
	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;

	Scanner scanner = new Scanner(System.in);

	private static void openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4", "root", "root");
	}

	private static void closeConnection() throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
		}
		if (connection != null) {
			connection.close();
		}
	}

	public void CarAdd() {
		System.out.println("Enter Car Id");
		int carid = scanner.nextInt();
		System.out.println("Enter Car Name");
		String carname = scanner.next();
		System.out.println("Enter Car Model");
		String carmodel = scanner.next();
		System.out.println("Enter Car Price");
		double carprice = scanner.nextDouble();
		System.out.println("Enter Car Brand");
		String carbrand = scanner.next();
		System.out.println("Enter Car Color");
		String carcolor = scanner.next();
		System.out.println("Enter Car fuelType");
		String fuletype = scanner.next();
		try {
			openConnection();
			query = "INSERT INTO car Values(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, carid);
			preparedStatement.setString(2, carname);
			preparedStatement.setString(3, carmodel);
			preparedStatement.setDouble(4, carprice);
			preparedStatement.setString(5, carbrand);
			preparedStatement.setString(6, carcolor);
			preparedStatement.setString(7, fuletype);
			int res = preparedStatement.executeUpdate();
			System.out.println(res + " row(s) affected");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void ViewAllCars() {
		try {
			openConnection();
			statement = connection.createStatement();
			query = "SELECT * FROM car";
			statement.execute(query);
			resultSet = statement.getResultSet();
			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
						+ " " + resultSet.getDouble(4) + " " + resultSet.getString(5) + " " + resultSet.getString(6)
						+ " " + resultSet.getString(7));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void removeCar() {
		System.out.println("Enter Car Id You Want to Delete");
		int id = scanner.nextInt();
		try {
			openConnection();
			query = "DELETE FROM car  where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int res = preparedStatement.executeUpdate();
			if (res == 1) {
				System.out.println("Car is deleted");
			} else {
				System.out.println("Car not Found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void editCar() {

		System.out.println("1. Edit Car Name\n" + "2. Edit Car Model\n" + "3. Edit Car Price\n" + "4. Edit Car Color\n"
				+ "5. Edit Car Brand\n" + "6. Edit FuleType\n");
		int choice1 = scanner.nextInt();
		switch (choice1) {
		case 1: {
			System.out.println("Enter Id of Car To Edit Name");
			int id = scanner.nextInt();
			System.out.println("===Enter New Name===");
			String carname = scanner.next();
			try {
				openConnection();
				query = "UPDATE car set name = ? where id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(2, id);
				preparedStatement.setString(1, carname);
				int res = preparedStatement.executeUpdate();
				if (res == 1) {
					System.out.println("Car Name Updated");
				} else {
					System.out.println("Car not Found");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		}
		case 2: {
			System.out.println("Enter Id of Car To Edit Model");
			int id = scanner.nextInt();
			System.out.println("===Enter New Model===");
			String carmodel = scanner.next();
			try {
				openConnection();
				query = "UPDATE car set model = ? where id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(2, id);
				preparedStatement.setString(1, carmodel);
				int res = preparedStatement.executeUpdate();
				if (res == 1) {
					System.out.println("Car Model Updated");
				} else {
					System.out.println("Car not Found");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		}
		case 3: {
			System.out.println("Enter Id of Car To Edit Price");
			int id = scanner.nextInt();
			System.out.println("===Enter New Price===");
			double carprice = scanner.nextDouble();
			try {
				openConnection();
				query = "UPDATE car set price = ? where id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(2, id);
				preparedStatement.setDouble(1, carprice);
				int res = preparedStatement.executeUpdate();
				if (res == 1) {
					System.out.println("Car Price Updated");
				} else {
					System.out.println("Car not Found");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		}
		case 4: {
			System.out.println("Enter Id of Car To Edit Color");
			int id = scanner.nextInt();
			System.out.println("===Enter New Color===");
			String carcolor = scanner.next();
			try {
				openConnection();
				query = "UPDATE car set color = ? where id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(2, id);
				preparedStatement.setString(1, carcolor);
				int res = preparedStatement.executeUpdate();
				if (res == 1) {
					System.out.println("Car Color Updated");
				} else {
					System.out.println("Car not Found");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		}
		case 5: {
			System.out.println("Enter Id of Car To Edit Brand");
			int id = scanner.nextInt();
			System.out.println("===Enter New Brand");
			String carbrand = scanner.next();
			try {
				openConnection();
				query = "UPDATE car set brand = ? where id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(2, id);
				preparedStatement.setString(1, carbrand);
				int res = preparedStatement.executeUpdate();
				if (res == 1) {
					System.out.println("Car Brand Updated");
				} else {
					System.out.println("Car not Found");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		}
		case 6: {
			System.out.println("Enter Id of Car To Edit FurlType");
			int id = scanner.nextInt();
			System.out.println("===Enter New FuleType");
			String fuletype = scanner.next();
			try {
				openConnection();
				query = "UPDATE car set fuleType = ? where id = ?";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(2, id);
				preparedStatement.setString(1, fuletype);
				int res = preparedStatement.executeUpdate();
				if (res == 1) {
					System.out.println("Car FuleTypeUpdated");
				} else {
					System.out.println("Car not Found");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		}
		default: {
			System.out.println("Invalid Input");
		}
			break;
		}

	}

	public void SearchCarById() {
		System.out.println("Enter id of car");
		int id = scanner.nextInt();
		try {
			openConnection();
			query = "SELECT * FROM car where id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
						+ " " + resultSet.getDouble(4) + " " + resultSet.getString(5) + " " + resultSet.getString(6)
						+ " " + resultSet.getString(7));
			} else {
				System.out.println("Car not Found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void SearchCarByName() {
		System.out.println("Enter Car Name");
		String name = scanner.next();
		try {
			openConnection();
			query = "SELECT * FROM car where name = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			for (int i = 0; i <= count; i++) {
				if (resultSet.next()) {
					System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
							+ " " + resultSet.getDouble(4) + " " + resultSet.getString(5) + " " + resultSet.getString(6)
							+ " " + resultSet.getString(7));
					count++;
				}

			}
			if (count == 0) {
				System.out.println("Car not Found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void SearchByModel() {
		System.out.println("Enter Car Model");
		String model = scanner.next();
		try {
			openConnection();
			query = "SELECT * FROM car where model = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, model);
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			for (int i = 0; i <= count; i++) {
				if (resultSet.next()) {
					System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
							+ " " + resultSet.getDouble(4) + " " + resultSet.getString(5) + " " + resultSet.getString(6)
							+ " " + resultSet.getString(7));
					count++;
				}

			}
			if (count == 0) {
				System.out.println("Car not Found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void SearchByPrice() {
		System.out.println("Enter Car Price");
		double price = scanner.nextDouble();
		try {
			openConnection();
			query = "SELECT * FROM car where price = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, price);
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			for (int i = 0; i <= count; i++) {
				if (resultSet.next()) {
					System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
							+ " " + resultSet.getDouble(4) + " " + resultSet.getString(5) + " " + resultSet.getString(6)
							+ " " + resultSet.getString(7));
					count++;
				}

			}
			if (count == 0) {
				System.out.println("Car not Found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void SearchByColor() {
		System.out.println("Enter Car Color");
		String color = scanner.next();
		try {
			openConnection();
			query = "SELECT * FROM car where color = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, color);
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			for (int i = 0; i <= count; i++) {
				if (resultSet.next()) {
					System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
							+ " " + resultSet.getDouble(4) + " " + resultSet.getString(5) + " " + resultSet.getString(6)
							+ " " + resultSet.getString(7));
					count++;
				}

			}
			if (count == 0) {
				System.out.println("Car not Found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void SearchByBrand() {
		System.out.println("Enter Car Brand");
		String brand = scanner.next();
		try {
			openConnection();
			query = "SELECT * FROM car where brand = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, brand);
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			for (int i = 0; i <= count; i++) {
				if (resultSet.next()) {
					System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
							+ " " + resultSet.getDouble(4) + " " + resultSet.getString(5) + " " + resultSet.getString(6)
							+ " " + resultSet.getString(7));
					count++;
				}

			}
			if (count == 0) {
				System.out.println("Car not Found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void SearchByFuleType() {
		System.out.println("Enter Car FuelType");
		String fuelType = scanner.next();
		try {
			openConnection();
			query = "SELECT * FROM car where fueltype = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, fuelType);
			resultSet = preparedStatement.executeQuery();
			int count = 0;
			for (int i = 0; i <= count; i++) {
				if (resultSet.next()) {
					System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3)
							+ " " + resultSet.getDouble(4) + " " + resultSet.getString(5) + " " + resultSet.getString(6)
							+ " " + resultSet.getString(7));
					count++;
				}

			}
			if (count == 0) {
				System.out.println("Car not Found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}

package org.example;
import java.sql.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws SQLException {
		DBOperations db = new DBOperations();
//		Statement statement = db.connection.createStatement();
//		ResultSet fetchData = statement.executeQuery("Select * from accounts");
//
//		System.out.println("******************* DETAILS*****************************************************************");
//		while (fetchData.next()) {
//			System.out.println("name: " + fetchData.getString("name"));
//			System.out.println("no: " + fetchData.getString("account_no"));
//			System.out.println("type: " + fetchData.getString("type"));
//			System.out.println("bal: " + fetchData.getString("balance"));
//			System.out.println("*************************************************************************************************");
//		}

			Operation operation = new Operation();
			operation.bankStart();

	}
}

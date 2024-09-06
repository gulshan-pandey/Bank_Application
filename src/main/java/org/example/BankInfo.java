package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;

import static org.example.DBOperations.connection;


public class BankInfo 
{  
    private String accno;  
    private String name;  
    private String acc_type;  
    private String balance;
    
    
    public String getName() 
    {
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getBalance()
	{
		return balance;
	}
	public void setBalance(String balance)
	{
		this.balance = balance;
	}
	public String getAccno()
	{
		return accno;
	}
	public void setAccno(String accno)
	{
		this.accno = accno;
	}
	public String getAcc_type() 
	{
		return acc_type;
	}
	public void setAcc_type(String acc_type) 
	{
		this.acc_type = acc_type;
	}




	public void saveToDB() throws SQLException {
		String sql = "INSERT INTO accounts (name,account_no, type, balance) VALUES (?, ?, ?, ?)";
		PreparedStatement prepstmt = connection.prepareStatement(sql);
		prepstmt.setString(1, this.name);
		prepstmt.setString(2, this.accno);
		prepstmt.setString(3, this.acc_type);
		prepstmt.setString(4, this.balance);

		int rows = prepstmt.executeUpdate();
		if(rows > 0) {
			System.out.println("Account made Successfully !");
		}
		prepstmt.close();
	}



	public static void retrieveFromDB(String accno) throws SQLException {
		String sql = "SELECT * FROM accounts WHERE account_no = ?";
		PreparedStatement prepstmt = connection.prepareStatement(sql);
		prepstmt.setString(1,accno);

		ResultSet rs = prepstmt.executeQuery();
		if(rs.next()){
			System.out.println();
			System.out.println("Name of account holder :: " + rs.getString("name"));
			System.out.println("Account no             :: " + rs.getString("account_no"));
			System.out.println("Account type           :: " + rs.getString("type"));
			System.out.println("Balance                :: " + rs.getString("balance"));
			System.out.println();
		} else {
			System.out.println("No such account exists");
		}
	}

	public static void validateUser(String accno) throws SQLException {
		String query = "SELECT name FROM accounts WHERE account_no = "+accno;
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		if(resultSet.next()) {
			System.out.println("Hello " + resultSet.getString("name"));
		}
		else {
			System.out.println("No such account exists");
			Operation.bankStart();
		}
	}

	public static void depositMoney(String accno, String amount) throws SQLException {
		 PreparedStatement prepstmt =  connection.prepareStatement("SELECT balance FROM accounts WHERE account_no = ?");
		 prepstmt.setString(1,accno);
		 ResultSet res = prepstmt.executeQuery();
		 String amt ="";
		 if(res.next()){
			 amt += res.getString("balance");
		 }

		 String sql = "UPDATE accounts SET balance = ? WHERE account_no =?";

		 prepstmt = connection.prepareStatement(sql);
		 prepstmt.setString(1, String.valueOf(Integer.valueOf(amt) + Integer.valueOf(amount)));
		 prepstmt.setString(2,accno);

		 int row= prepstmt.executeUpdate();
		 if(row > 0) {
			 System.out.println("Amount deposited successfully");
		 }
		 int finalAmt = Integer.valueOf(amt) + Integer.valueOf(amount);
		System.out.println("Your Current Available Balance is Rs  :: "+ finalAmt);


	}


	public static void withdrawMoney(String accno, String amount) throws SQLException {

		PreparedStatement prepstmt =  connection.prepareStatement("SELECT balance FROM accounts WHERE account_no = ?");
		prepstmt.setString(1,accno);
		ResultSet res = prepstmt.executeQuery();
		String balance ="";
		if(res.next()){
			balance += res.getString("balance");
		}
		if(Integer.valueOf(balance)-Integer.valueOf(amount) < 0) {
			System.out.println("Insufficient Account Balance !");
			Operation.bankStart();											//restart the process
		}else{
			 int restAmount = Integer.valueOf(balance) -Integer.valueOf(amount);
			 prepstmt = connection.prepareStatement("UPDATE accounts SET balance = ? WHERE account_no =?");
			 prepstmt.setString(1,String.valueOf(restAmount));
			 prepstmt.setString(2,accno);

			 int row = prepstmt.executeUpdate();
			 if(row > 0) {
				 System.out.println("Amount withdrawn successfully");
			 }

			System.out.println(amount + " withdrawn from your account");
			System.out.println("Your Current Available Balance is Rs  :: "+ restAmount);

		}

	}
}


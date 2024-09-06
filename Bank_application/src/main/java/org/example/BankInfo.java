package org.example;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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

	}
}


package org.example;
import java.sql.SQLException;
import java.util.Scanner;

public class process
{
 Scanner sc = new Scanner(System.in);  
// static BankInfo bank1 = new BankInfo();

//    static
//    {
//    	bank1.setAccno("85462134");
//    	bank1.setName("Adam");
//    	bank1.setAcc_type("Saving");
//    	bank1.setBalance("10000000");
//
//    }

    public void openAccount()
    {
        BankInfo bank1 = new BankInfo();                     //create object of BankInfo class( for making an account)
        System.out.println("--- CREATING NEW BANK ACCOUNT ---");
        System.out.print("Enter Account No: ");  
        bank1.setAccno(sc.next()); 
        System.out.print("Select Account type: ");
        System.out.println("\n1. Saving\n2. Current\n3. Student\n ");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                bank1.setAcc_type("Saving");
                break;
            case 2:
                bank1.setAcc_type("Current");
                break;
            case 3:
                bank1.setAcc_type("Student");
                break;
            default:
                System.out.println("Invalid choice   ---> Saving by default");
                bank1.setAcc_type("Saving");
        }
        System.out.print("Enter Name: ");  
        bank1.setName(sc.next());
        System.out.print("Enter Balance: ");  
        bank1.setBalance(sc.next());

        try {
            System.out.println("Creating Your Bank Account...");
            Thread.sleep(1000);
            bank1.saveToDB();
        } catch (SQLException  | InterruptedException  e) {
            System.out.println("ERROR:-  "+e.getMessage());
        }

        System.out.println("------YOUR ACCOUNT DETAILS IS -------");
        System.out.println("Name of account holder :: " + bank1.getName());  
        System.out.println("Account no             :: " + bank1.getAccno());  
        System.out.println("Account type           :: " + bank1.getAcc_type());  
        System.out.println("Balance                :: " + bank1.getBalance());  
        
    }

    public void checkbalance()
    {
        System.out.println("ENTER YOUR ACCOUNT NO (eg- 12345):: ");
        String accno = sc.next();
        try {
            System.out.println("Checking Balance...");
            Thread.sleep(1000);
            BankInfo.retrieveFromDB(accno);
        } catch (SQLException | InterruptedException e) {
            System.out.println("ERROR:-  "+e.getMessage());
        }

    }


    public void deposit()
    {
    	System.out.println("Enter the Account Number of yours::");
        String accno = sc.next();
        try {
            BankInfo.validateUser(accno);
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            System.out.println("Account not found :: Please try again");
            deposit();

        }
        System.out.println("Enter the Amount you want to deposit ::");
		String deposit =sc.next();
        try {
            System.out.println("Adding Money...");
            Thread.sleep(1000);
            BankInfo.depositMoney(accno, deposit);
        } catch (SQLException | InterruptedException e) {
            System.out.println("Error : " + e.getMessage());
        }

    }

    public void withdraw() 
    {
        System.out.println("Enter your Account Number ::");
        String accno = sc.next();
        try {
            BankInfo.validateUser(accno);
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            System.out.println("Account not found :: Please try again");
            withdraw();

        }
        System.out.println("Enter the Amount you want to Withdraw::");
        String amt =sc.next();
        try {
            System.out.println("Withdrawing Money...");
            Thread.sleep(1000);
            BankInfo.withdrawMoney(accno, amt);
        } catch (SQLException | InterruptedException e) {
            System.out.println("Error : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void demoaccount()
    {
        String  demobalance="50000";
        System.out.println("Name of account holder :: " + "Demo user");
        System.out.println("Account no             :: " + "8529637412");
        System.out.println("Account type           :: " + "demo");
        System.out.println("Balance                :: " + demobalance);

    }




}

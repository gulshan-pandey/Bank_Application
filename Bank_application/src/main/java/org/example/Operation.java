package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operation 
{
	public static void bankStart()
	{
		Scanner scan = new Scanner(System.in);
        System.out.println(" ----------------------------------------------------------------------------------------------------------------------------------------------------------------");
	    System.out.println(" ***Banking System Application***");
	    System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
	   
	    System.out.println(" 1. Create a new account  \n 2. Check Balance\n 3. Deposit the amount \n 4. Withdraw the amount  \n 5. Watch demo account \n 6. Exit  \n\nENTER YOUR CHOISE :: ");
		int key = 0;
		boolean isValidInput = false;
		while (!isValidInput) {
			try {
				key = scan.nextInt();
				if (key < 1 || key > 6) {
					System.out.println("Invalid choice. Please enter a number between 1 and 6.");
				} else {
					isValidInput = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				scan.next(); // Clear the invalid input
			}
		}

		operation( key);
	    
	   
	}
		public static void operation(int key)
		{
//			BankInfo bank = new BankInfo();
			Scanner scan = new Scanner(System.in);
			process bankprocess = new process();
			 switch (key) 
			 {
				case 1:
				    System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
					bankprocess.openAccount();
					System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println();
				    System.out.println("MAIN PAGE_:: PRESS 1 :: OR :: PRESS ANY KEY TO EXIT ::");
					try {
						if (scan.nextInt()==1)
							bankStart();
						break;
					} catch (Exception e) {
						System.exit(0);
					}

				case 2:
				    System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");

					bankprocess.checkbalance();
					System.out.println();
					System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("MAIN PAGE_:: PRESS 1 ::");
					if (scan.nextInt()==1) 
						bankStart();
					break;

				case 3:
				    System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
				    System.out.println();
					System.out.println("---------WELCOME TO DEPOSITE PAGE---------------- ");
					bankprocess.deposite();
					System.out.println();
				    System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("MAIN PAGE_:: PRESS 1 ::");
					if (scan.nextInt()==1) 
						bankStart();
					break;
				case 4:
				    System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
					bankprocess.withdraw();
					System.out.println();
					System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("MAIN PAGE_:: PRESS 1 ::");
					if (scan.nextInt()==1) 
						bankStart();
					break;
				case 5:
				    System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
				    bankprocess.demoaccount();
				    System.out.println();
					System.out.println(" -----------------------------------------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("MAIN PAGE_:: PRESS 1 ::");
					if (scan.nextInt()==1)
						bankStart();
					break;
				case 6:
					System.out.println("THANKS FOR USING OUT BANK APPLICATION");
					break;
				}
		}

}
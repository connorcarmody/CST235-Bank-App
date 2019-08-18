package edu.gcu.cst135.ActivityGuide.CST235BankingStart.view;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import edu.gcu.cst135.ActivityGuide.CST235BankingStart.controller.Bank;
import edu.gcu.cst135.ActivityGuide.CST235BankingStart.model.Account;
import edu.gcu.cst135.ActivityGuide.CST235BankingStart.model.Customer;

/**
 * These are all the menus for the application
 * @author connorcarmody
 *
 */
public class Menus {
	
	// Create a scanner for reuse across all methods
	public static Scanner sc = new Scanner(System.in);
	
	/**
	 * Opening menu for the application
	 */ 
	public static int custMenu() {
		int option = 0;
		try {
			System.out.println("***************************");
			System.out.println("  BANK CUSTOMER MENU  ");
			System.out.println("***************************");
			System.out.println(" 1. Create an account.");
			System.out.println(" 2. Log in.");
			System.out.println("---------------------------");
			System.out.println(" 0. Exit");
			System.out.println("***************************");
			System.out.println("What is your choice?");
			String opt = sc.nextLine();
			option = Integer.parseInt(opt);
		} catch (Exception e) { // Can we parse the user's entry?
			System.out.println("Bad customer menu input. Try again!");
			option = -1;
		}
		return option;
	}
	
	
	
	/**
	 *  Picking a customer for banking transaction menu
	 *  Takes info from Login method and loads that customer into the old array functionality.
	 *  The array is still used in case multiple customers login during one use of the app.
	 * @param custs
	 * @return
	 */
	public static int pickCustomerMenu(List<Customer> custs) {
		int number;
		int cust = 0;
		Bank b = new Bank();
		
	cust = 	b.getKey();
	/*	try {
			number = 1;
			System.out.println("***************************");
			System.out.println("  PICK CUSTOMER MENU  ");
			System.out.println("***************************");
			
			// CST235 TASK: CUSTOMER LIST MUST COME FROM THE DB
			for (Customer c : custs) {
				System.out.println(number + ". " + c.toString());
				number++;
			}
			
			System.out.println("---------------------------");
			System.out.println(" 0. Exit");
			System.out.println("***************************");
			System.out.println("Who is your choice?");
			cust = sc.nextInt();
			sc.nextLine();
		} catch (Exception e) { // Can we parse the user's entry?
			System.out.println("Bad customer select. Try again!");
		}
		*/
		return cust;
	}
	
	/**
	 *  Get user STRING input
	 * @param message
	 * @return
	 */
	public static String userStrInput(String message) {
		System.out.println(message);
		return sc.nextLine();
	}
	
	/**
	 *  Get user DOUBLE input	
	 * @param message
	 * @return
	 */
	public static double userDblInput(String message) {	
		double amount = 0.0;
		try {
			System.out.println(message);
			String input = sc.nextLine();
			amount = Double.parseDouble(input);
		} catch (Exception e) { // Can we parse the user's entry?
			System.out.println("Wrong double input\n");
			amount = -1.0;
		}
		return amount;
	}
	
	/**
	 *  Banking transaction menu
	 * @param c
	 * @param name
	 * @return
	 */
	public static int viewCustomerMenu(Customer c, String name) {

		try {
			String option;
			do {
				System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("                MAIN MENU");
				//System.out.println("                " + name.toUpperCase());
				System.out.println("Hello " + c.getFirstName().toUpperCase() + " " + c.getLastName().toUpperCase());				
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println("Pick an option: ");
				System.out.println("-----------------------");
				System.out.println(" 1: Deposit to Checking");
				System.out.println(" 2: Deposit to Savings");
				System.out.println(" 3: Withdraw from Checking");
				System.out.println(" 4: Withdraw from Savings");			
				System.out.println(" 5: Get balance");
				System.out.println(" 6: Make Loan Payment");
				System.out.println(" 7: Get monthly statement");
				System.out.println("------------------------");
				System.out.println(" 9: : Logout");
				option = sc.nextLine();
				return Integer.parseInt(option);
			} while (Integer.parseInt(option) != 9);
		} catch (Exception e) { // Can we parse the user's entry?
			System.out.println("Wrong transaction menu input\n");
			viewCustomerMenu(c, name);
		}
		return 0;
	}
	
	/**
	 * Balance displays for each account class type
	 * @param cust
	 */
	public static void viewBalances(Customer cust) {
		System.out.println("------------------------");
		System.out.println("CUSTOMER BALANCES");
		System.out.println("------------------------");
		System.out.println("CHECKING : \t" + cust.getChecking().getAccountNumber() + " \t $" + cust.getChecking().getAccountBalance() );
		System.out.println("SAVING :   \t" + cust.getSaving().getAccountNumber() + " \t $" + cust.getSaving().getAccountBalance() );
		System.out.println("LOAN :     \t" + cust.getLoan().getAccountNumber() + " \t $" + cust.getLoan().getAccountBalance() );
		System.out.println("------------------------");
	}

	/**
	 *  Formatted syso method
	 * @param message
	 */
	public static void printOut(String message) {
		System.out.println(" > " + message);
	}

	/**
	 *  Formatted balance printing method
	 * @param <T>
	 * @param obj
	 */
	public static <T> void printBalance(T obj){
		System.out.println(((Account) obj).getAccountNumber() + " : $" + ((Account) obj).getAccountBalance());
	}
}

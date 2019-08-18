package edu.gcu.cst135.ActivityGuide.CST235BankingStart.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import edu.gcu.cst135.ActivityGuide.CST235BankingStart.controller.Bank;
import edu.gcu.cst135.ActivityGuide.CST235BankingStart.view.Menus;



public class SQLQueries {
Bank bank = new Bank();
Scanner scan = new Scanner(System.in);
Database connect = new Database();

/**
 * log customer in to app. if username and password match an existing one, it goes through. 
 * customer is then added to the customer array for instanced used.
 * @throws SQLException
 */
	public void login() throws SQLException {
		Bank b = new Bank();
		System.out.println("Enter your username.");
		String user = scan.nextLine();
		System.out.println("Enter your password.");
		String pw = scan.nextLine();
		
        String sql = "SELECT first_name, last_name, user_name, password FROM bank.login WHERE user_name = \"" + user.toLowerCase() + "\"AND password = \"" + 
        pw.toLowerCase() + "\"";

        try{
        	
        	connect.databaseUtil();
            Statement statement = connect.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            b.setKey(b.getKey());
            while (resultSet.next()) {
            /*	bank.customers.add(new Pair <Integer, Customer> (b.getKey(), new Customer(
            			resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("user_name"),
                        resultSet.getString("password"))));
                        */
              bank.customers.add(new Customer(
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("user_name"),
                        resultSet.getString("password")));
              connect.databaseClose();
              bank.pickCustomer();
            }
        }

        catch(SQLException e){
        System.out.println("That username or password does not exist. Please try again.");
        Menus.custMenu();

        }

       

     
    }
	
	/**
	 * get account details and put customer on database.
	 */
	public void addCustomer() {
		System.out.println("Enter your first name.");
		String fn = scan.nextLine();
		System.out.println("Enter your last name.");
		String ln = scan.nextLine();
		System.out.println("Enter your username.");
		String user = scan.nextLine();
		System.out.println("Enter your password.");
		String pw = scan.nextLine();
		System.out.println("Password once more (to be safe.)");
		String pw2 = scan.nextLine();
		/*if (pw.toString() != pw2.toString()) {
			System.out.println("Whoops! Let's try that again.");
			addCustomer();
		}
		*/
		//else {
        String sql = "INSERT INTO bank.login (first_name, last_name, user_name, password) VALUES ("+"\""+fn+"\""+", "+"\""+ln+"\""+", "
		+"\""+user+"\""+", "+"\""+pw+"\""+")";

        try{
        	
        	connect.databaseUtil();
            Statement statement = Database.connection.createStatement();
           // ResultSet resultSet =
            		statement.executeUpdate(sql);
            try {
    			connect.databaseClose();
    		} catch (SQLException e) {
    			
    			e.printStackTrace();
    		}

              bank.start();
            }
        

        catch(SQLException e){
        		e.printStackTrace();
        Menus.custMenu();

        }

       
		
	}
	
}

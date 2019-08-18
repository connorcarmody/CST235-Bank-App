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

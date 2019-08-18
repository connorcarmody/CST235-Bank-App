package edu.gcu.cst135.ActivityGuide.CST235BankingStart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	  
	static String DB_URL = "jdbc:mysql://bank.cspgybz8ciz4.us-west-1.rds.amazonaws.com:3306/?user=admin";
	    static String DB_USER = "admin";
	    static String DB_PASS = "password123";

	    static Connection connection;
/**
 * This connects us to the database.
 */
	public void databaseUtil(){
		System.out.println("Connecting . . .");
	    try {
	        connection=DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
	        System.out.println("You are connected.");
	  
	    }catch(SQLException e) {
	        e.printStackTrace();
	        System.err.println("Not connected");
	    }
	        
	    
	}
	/**
	 * Closes database connection. (VERY IMPORANT TO USE EVERY TIME YOU OPEN IT)
	 * @throws SQLException
	 */
	public void databaseClose() throws SQLException {
		connection.close();
	}
}

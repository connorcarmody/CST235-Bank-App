package edu.gcu.cst135.ActivityGuide.CST235BankingStart.controller;

public interface iTrans {
	/**
	 * forces transaction class to use these methods
	 * @param amount
	 * @param description
	 */
	void addTransaction(double amount, String description);
	void ListTransaction();

}

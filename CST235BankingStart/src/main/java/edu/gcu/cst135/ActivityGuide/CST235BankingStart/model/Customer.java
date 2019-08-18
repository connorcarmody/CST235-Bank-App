package edu.gcu.cst135.ActivityGuide.CST235BankingStart.model;

public class Customer {

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	private Checking checking;
	private Saving saving;
	private Loan loan;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Checking getChecking() {
		return checking;
	}

	public void setChecking(Checking checking) {
		this.checking = checking;
	}

	public Saving getSaving() {
		return saving;
	}

	public void setSaving(Saving saving) {
		this.saving = saving;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public Customer(String firstName, String lastName, String username, String password) {
		// CST235 TASK: CUSTOMER INFORMATION MUST BE STORED IN A DB
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		checking = new Checking(generateAcct('C'), 2000);
		saving = new Saving(generateAcct('S'), 2000);
		loan = new Loan(generateAcct('L'), 2000);
	}
	/**
	 * create random account number
	 * @param type
	 * @return
	 */
	private String generateAcct(char type) {
		String acct = "0";
		for (int x = 0; x < 9; x++) {
			acct += (int) (Math.random()* 9) + 1;
		}
		return acct + type;
	}
	
	public String toString() {
		return firstName + " " + lastName;
	}
	
}

//[Listing Two]
class Account {

	private double balance;

	public Account(double initialDeposit) {
		balance = initialDeposit;
	}

	public synchronized void deposit(double amount) {
		balance += amount;
	}

};
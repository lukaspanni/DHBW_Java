package dhbw.exercise.classes;

public class Account {

	private int accountNumber;
	private String ownerName;
	private double balance;
	private double limit;

	public Account() {
		super();
		accountNumber = -1;
		ownerName = "[Not Set]";
		balance = 0;
		limit = 0;
	}

	public Account(int accountNumber, String ownerName) {
		super();
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = 0;
		this.limit = 0;
	}

	public Account(int accountNumber, String ownerName, double balance, double limit) {
		super();
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
		this.limit = limit;
	}

	public void processDeposit(double amnt) {
		if (amnt > 0) {
			this.balance += amnt;
		}
	}

	public void processPayment(double amnt) {
		// Nur zulassen wenn limit nicht überschritten wird
		if ((this.balance - amnt) >= (-this.limit)) {
			this.balance -= amnt;
		}
	}

	public double getBalance() {
		return this.balance;
	}

	@Override
	public String toString() {
		return "Konto Nr. " + accountNumber + "(" + ownerName + "), Stand=" + balance + "€, limit=" + limit + "€";
	}

}

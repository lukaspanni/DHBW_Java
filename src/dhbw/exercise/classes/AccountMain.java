package dhbw.exercise.classes;

public class AccountMain {

	public static void main(String[] args) {
		Account account = new Account(4711, "Donald Duck", 500, 1000);
		System.out.println(account);
		account.processDeposit(200);
		System.out.println(account);
		account.processPayment(400);
		System.out.println(account);
		account.processPayment(2000);
		System.out.println(account);
	}

}

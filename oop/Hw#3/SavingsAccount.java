public class SavingsAccount extends Account {

	static int amount;
	Account balance = new Account();

	public static boolean deposit(Account balance) {

		System.out.println("Balance before deposit ");
		System.out.println(balance.toString());
		balance.setBalance(balance.getBalance() + amount);
		System.out.println("Balance after deposit " + balance.toString());
		balance.setBalance(balance.getBalance() + amount);
		return true;
		}

	}

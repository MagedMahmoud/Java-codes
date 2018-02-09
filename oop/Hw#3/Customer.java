import java.util.ArrayList;
import java.util.Iterator;

public class Customer {
	
	private int amount;
	private String name;
	private String address;
	private int age;
	private int telephoneNumber;
	private int customerNumber;
	private double checking_interest, savings_interest, check_charge;
	Iterator<Account> itr;
	private ArrayList<Account> accountList;

	public String getName() {
		return name;
	}

	public String setName() {
		return this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public int getAge() {
		return age;
	}

	public int setAge() {
		return this.age = age;
	}

	public int getTelephoneNumber() {
		return telephoneNumber;
	}

	public int setTelphoneNumber() {
		return this.telephoneNumber = telephoneNumber;

	}

	public int getCustomerNumber() {

		return customerNumber;
	}

	public int setCustomerNumber() {
		return this.customerNumber = customerNumber;
	}

	public double getSavingsInterest() {
		return savings_interest;
	}

	public double getCheckinInterest() {
		return checking_interest;
	}

	public double getCheckCharge() {

		return check_charge;

	}



	public static boolean withdraw(Account balance) {

		if (Balance.getBalance() < Amount) {
			System.out.println("Insufficient Balance.");
			return false ;
		}
		System.out.println("Balance in Savings Account before withdraw ");
		System.out.println(Balance.toString());
		Balance.setBalance(Balance.getBalance() - amount);
		System.out.println("Balance in Savings Account after withdraw " + Balance.toString());
		return true;
	}

	public void addInterest(double interest) {

		System.out.println("Balance in Savings Account before interest ");
		System.out.println(Balance.toString());
		//Savings account has 1.00% interest rate
		interest = (int) (Balance.getBalance() + amount*(.01));
		balance.setBalance(interest);
		System.out.println("Balance in Savings Account after interest" + Balance.toString());

	}

}

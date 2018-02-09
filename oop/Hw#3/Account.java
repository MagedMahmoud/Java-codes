import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.Date;

public class Account {
	
	private double amount;
	Customer customer;
	int accountNumber;
	double balance;
	Transaction transaction[] = new Transaction[20];
	Date date = new Date();
	
	Scanner sc = new Scanner(System.in);

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {

		return customer;

	}

	public void setCustomer() {

		this.customer = customer;
	}

	public String toString() {
		return "Account Number  " + accountNumber + " Current balance is " + balance + "\nLast date of update: " + date;

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void reAllocate(Transaction transaction[]) {

		int min = 0;
		int prior = transaction.length;
		if (min > prior) {
			Object oldData[] = transaction;
			int now = (prior * 2);
			if (now < min)
				now = min;
			transaction = Arrays.copyOf(transaction, now);
		}
	}

}

import java.util.*;



public class Bank {
    private ArrayList<Account> accountList;

    Account balance[] = new Account[100];
    private String transactionType;
    double amount;
    private long accountNum;
    private Date date;
    Account account = new Account();

    public void addAccount(Account e) {
        accountList.add(e);
    }

    public void Bank(long accountNum, String transactionType, double amount) {
        this.accountNum = accountNum;
        this.transactionType = transactionType;
        this.amount = amount;
        date = new Date();
    }

    public void makeDeposit() {

        if (transactionType.equalsIgnoreCase("deposit checking")) {

            System.out.println("Balance before deposit \n:");
            System.out.println(account.toString());
            account.setBalance(account.getBalance() + accountNum);
            System.out.println("Balance after deposit \n" + account.toString());
            CheckingAccount.Deposit(account);
        }
        if (transactionType.equalsIgnoreCase("deposit savings")) {

            System.out.println("Balance before deposit \n:");
            System.out.println(account.toString());
            account.setBalance(account.getBalance() + accountNum);
            System.out.println("Balance after deposit \n" + account.toString());
            SavingsAccount.Deposit(account);
        }
    }

    public void makeWithdrawl() {

        if (account.getBalance() < amount) {
            System.out.println("Insufficient Balance.");
            return;
        }
        if (transactionType.equalsIgnoreCase("withdraw checking ")) {
            System.out.println("Balance before withdrawl ");
            System.out.println(account.toString());
            account.setBalance(account.getBalance() - accountNum);
            System.out.println("Balance after withdrawal \n" + account.toString());
            CheckingAccount.withdraw(account);
        }
        if (transactionType.equalsIgnoreCase("withdraw savings ")) {
            System.out.println("Balance before withdrawl ");
            System.out.println(account.toString());
            account.setBalance(account.getBalance() - accountNum);
            System.out.println("Balance after withdrawal \n" + account.toString());
            SavingsAccount.withdraw(account);
        }
    }


    public long getAccountNum() {
        return accountNum;
    }
}
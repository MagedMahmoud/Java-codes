import java.util.*;


public class Main {
    public static void main(String args[]) {
        String choice, ch, operation;
        Transaction transaction = new Transaction();
        Scanner sc = new Scanner(System.in);
        double amount;
        long accountNo;

        do {
            System.out.println("Enter 1 to open a new Checking account");
            System.out.println("Enter 2 to open a new savings account");
            System.out.println("Enter 3 to make a transaction");
            System.out.println("q. Exit");
            choice = sc.next();
            switch (choice) {

            case "1":
                double openingChecking;

                System.out.println("Enter the opening Checking balance :");
                openingChecking = sc.nextDouble();
                transaction.Transaction(0, "Opening", openingChecking);
                break;

            case "2":
                double openingSavings;

                System.out.println("Enter the opening Checking balance :");
                openingSavings = sc.nextDouble();
                transaction.Transaction(0, "Opening", openingSavings);
                break;
            case "3":
                System.out.println("a. Deposit in Checking");
                System.out.println("b. Withdraw in Checking ");
                System.out.println("c. Deposit in Savings ");
                System.out.println("d. Withdraw in Savings ");
                ch = sc.next();
                if (ch.equalsIgnoreCase("a"))
                     operation = "deposit checking";
                else if (ch.equalsIgnoreCase("b"))
                    operation = "withdraw checking";
                else if (ch.equalsIgnoreCase("c"))
                operation = "deposit savings";
                else if (ch.equalsIgnoreCase("c"))
                    operation = "withdraw savings";
                else {
                    operation = "Invalid option";
                }
                System.out.println("Account Number ");
                accountNo = sc.nextLong();
                System.out.println("Amount transaction ");
                amount = sc.nextDouble();
                transaction.Transaction(accountNo, operation, amount);
                break;
                
            case "q":
                System.out.println("Thank you!");
                break;

            default:
                System.out.println("Wrong choice!!");
            }
        } while (choice != "q");
        sc.close();
    }
}


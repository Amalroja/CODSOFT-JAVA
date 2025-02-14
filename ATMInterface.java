
import java.util.Scanner;


class BankAccount {
    private double balance;

    
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Your new balance is: $" + balance);
        } else {
            System.out.println("Invalid amount! Deposit must be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful! Your new balance is: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Your current balance is: $" + balance);
        } else {
            System.out.println("Invalid amount! Withdrawal must be greater than zero.");
        }
    }

    
    public double getBalance() {
        return balance;
    }
}


class ATM {
    private BankAccount account;
    private Scanner scanner;

    
    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    
    public void showMenu() {
        while (true) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.println("Your current balance is: $" + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Have a great day!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please select a valid option.");
            }
        }
    }
}


public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance set to $1000
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}
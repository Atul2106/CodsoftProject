package codsoft_project;

import java.util.Scanner;


class BankAcc {
	private double balance;

	public BankAcc(double initialBal) {
	    this.balance = initialBal;
	}

	public double getBalance() {
	    return balance;
	}

	public void deposit(double amt) {
	     if (amt > 0) {
	         balance += amt;
	         System.out.println("You Deposited successfullly... New balance: " + balance);
	     } else 
	         System.out.println("Invalid amount for deposit...");
   	}

	public void withdraw(double amt) {
	     if (amt > 0 && amt <= balance) {
	         balance -= amt;
	         System.out.println("Withdrawal successful... New balance: " + balance);
	     } else 
	         System.out.println("Insufficient amount for withdrawal...");
	}
}  
	
	
	
class ATM {
	private BankAcc acc;
	private Scanner sc;

	public ATM(BankAcc acc) {
	    this.acc = acc;
	    this.sc = new Scanner(System.in);
	}

	public void showMenu() {
		System.out.println("1. Check Balance");
	    System.out.println("2. Deposit");
	    System.out.println("3. Withdraw");
	    System.out.println("4. Exit");
	    System.out.println("--------------------------");
	}

	public void run() {
		int choice;
		do {
	            showMenu();
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            switch (choice) {
	                case 1:
	                    checkBalance();
	                    break;
	                case 2:
	                    deposit();
	                    break;
	                case 3:
	                    withdraw();
	                    break;
	                case 4:
	                    System.out.println("Thank you for using the ATM!");
	                    break;
	                default:
	                    System.out.println("Invalid choice..!!!");
	                    System.out.println("Please select a valid option.");
	            }
	        } while (choice != 4);
	 }

	    private void checkBalance() {
	        System.out.println("Your current balance is: " + acc.getBalance());
	    }

	    private void deposit() {
	        System.out.print("Enter the amount to deposit: ");
	        double amt = sc.nextDouble();
	        acc.deposit(amt);
	    }

	    private void withdraw() {
	        System.out.print("Enter the amount to withdraw: ");
	        double amt = sc.nextDouble();
	        acc.withdraw(amt);
	    }
	    
	}
	

		
public class Atm_Interface {
    public static void main(String[] args) {
    	System.out.println("Welcome to the SBI ATM!");
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter your 4-digit PIN: ");
        int pin = sc.nextInt();

        if (fourDigitPIN(pin)) {
            System.out.println("PIN Accepted. You can proceed with your transaction.");
            
	        BankAcc userAcc = new BankAcc(2000.0);
	        ATM atm = new ATM(userAcc);
	        atm.run();
	        
        } else {
            System.out.println("Error: Invalid PIN !!!");
            System.out.println("Please enter a Valid PIN.");
        }

        sc.close();
    }

    private static boolean fourDigitPIN(int pin) {
        return pin >= 1000 && pin <= 9999;
    }
}


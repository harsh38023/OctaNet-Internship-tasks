import java.util.Scanner;

public class ATMSimulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM atm = new ATM("1234");  // Default PIN "1234". 

        System.out.println("Welcome to the ATM!");  // A friendly welcome message.

        // Let's keep asking for the PIN until the user gets it right.
        boolean accessGranted = false;
        while (!accessGranted) {
            System.out.print("Enter your PIN: ");  // Asking for the PIN
            String inputPin = scanner.nextLine();
            if (atm.validatePIN(inputPin)) {
                accessGranted = true;
                System.out.println("Access granted."); 
            } else {
                System.out.println("Incorrect PIN. Try again."); 
            }
        }

        // shows them the menu options
        boolean exit = false;
        while (!exit) {
            System.out.println("\nATM Menu:");  // The menu options you see at an ATM.
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Change PIN");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();  // Checks the balance 
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdrawCash(withdrawAmount);  // Dispensing cash
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.depositCash(depositAmount);  // Adding more money into the account.
                    break;
                case 4:
                    scanner.nextLine();  
                    System.out.print("Enter old PIN: ");
                    String oldPin = scanner.nextLine();
                    System.out.print("Enter new PIN: ");
                    String newPin = scanner.nextLine();
                    atm.changePIN(oldPin, newPin);  // Changing the PIN
                    break;
                case 5:
                    atm.showTransactionHistory();  // Shows the transaction history
                    break;
                case 6:
                    exit = true;  // Exits the ATM menu.
                    System.out.println("Thank you for using the ATM. Goodbye!"); 
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");  // For no valid input.
            }
        }

        scanner.close();
    }
}

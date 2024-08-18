import java.util.ArrayList;

class ATM {
    private double balance;
    private String pin;
    private ArrayList<String> transactionHistory;

    // ATM constructor - sets the initial PIN and balance 
    public ATM(String initialPin) {
        this.balance = 0.0;  // Starting balance is 0
        this.pin = initialPin;  // Initial PIN set by the user
        this.transactionHistory = new ArrayList<>();
    }

    // Check the current balance
    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
        // Adding this transaction to the history
        transactionHistory.add("Balance inquiry: $" + balance);
    }

    // Withdraw cash from the ATM
    public void withdrawCash(double amount) {
        if (amount <= 0) {
            // Negative or zero withdrawal doesn't make sense
            System.out.println("Amount must be positive. Try again.");
            return;
        }
        // Check if enough balance is available
        if (amount > balance) {
            System.out.println("Oops! You don't have enough funds.");
            transactionHistory.add("Failed withdrawal of $" + amount);
        } else {
            balance -= amount;
            System.out.println("Please take your cash: $" + amount);
            transactionHistory.add("Withdrawal of $" + amount);
        }
    }

    // Deposit cash into the ATM
    public void depositCash(double amount) {
        if (amount <= 0) {
            // Ensure the deposit is a positive number
            System.out.println("Deposit must be more than $0.");
            return;
        }

        balance += amount;
        System.out.println("You've successfully deposited: $" + amount);
        transactionHistory.add("Deposit of $" + amount);
    }

    // Change the PIN - checks if the old PIN is correct first
    public void changePIN(String oldPin, String newPin) {
        // A basic length check on the new PIN
        if (newPin == null || newPin.length() < 4) {
            System.out.println("New PIN must be at least 4 digits.");
            transactionHistory.add("Failed PIN change: New PIN too short.");
            return;
        }

        if (oldPin.equals(pin)) {
            pin = newPin;  // Update the PIN
            System.out.println("PIN changed successfully.");
            transactionHistory.add("PIN changed.");
        } else {
            System.out.println("The old PIN you entered is incorrect.");
            transactionHistory.add("Failed PIN change: Incorrect old PIN.");
        }
    }

    // Display transaction history
    public void showTransactionHistory() {
        System.out.println("Transaction History:");
        
        // Check if there's any history to display
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions have been made.");
        } else {
            for (String transaction : transactionHistory) {
                // Print each transaction
                System.out.println(transaction);
            }
        }
    }

    // PIN validation
    public boolean validatePIN(String inputPin) {
        // This could be more complex, but for now, it's just a simple match
        return inputPin.equals(pin);
    }
    
    // This method isn't really necessary, but let's leave it here for now
    public void greetUser() {
        System.out.println("Welcome to the ATM. Please enter your PIN.");
    }
}

class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;
    BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("Rohit", 12345, 10000);
        b1.displayBalance();
        b1.deposit(2000);
        b1.withdraw(5000);
        b1.displayBalance();
    }
}

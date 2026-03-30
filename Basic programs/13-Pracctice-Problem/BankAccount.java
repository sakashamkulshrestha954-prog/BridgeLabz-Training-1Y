class BankAccount {
    private String accountHolderName;
    private double balance;
    private String accountType;

    public BankAccount(String accountHolderName, double balance, String accountType) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getAccountHolderName() { return accountHolderName; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }
}

class BalanceChecker implements Runnable {
    private BankAccount account;

    public BalanceChecker(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("--------------------------------------------");
            System.out.println("User       : " + account.getAccountHolderName());
            System.out.println("Account    : " + account.getAccountType());
            System.out.println("Priority   : " + Thread.currentThread().getPriority());
            System.out.println("Check #    : " + i + " of 3");
            System.out.printf("Balance    : $%.2f%n", account.getBalance());
            System.out.println("Thread     : " + Thread.currentThread().getName());
            System.out.println("Time       : " + new java.util.Date());
            System.out.println("--------------------------------------------");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(account.getAccountHolderName() + "'s thread interrupted.");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(">> " + account.getAccountHolderName() + " has completed all balance checks.\n");
    }
}

public class BankingApp {
    public static void main(String[] args) {
        BankAccount premiumUser = new BankAccount("Alice Johnson", 75000.00, "Premium");
        BankAccount regularUser = new BankAccount("Bob Smith", 15000.00, "Regular");
        BankAccount basicUser = new BankAccount("Carol White", 2500.00, "Basic");

        BalanceChecker premiumChecker = new BalanceChecker(premiumUser);
        BalanceChecker regularChecker = new BalanceChecker(regularUser);
        BalanceChecker basicChecker = new BalanceChecker(basicUser);

        Thread premiumThread = new Thread(premiumChecker, "Premium-Thread");
        Thread regularThread = new Thread(regularChecker, "Regular-Thread");
        Thread basicThread = new Thread(basicChecker, "Basic-Thread");

        premiumThread.setPriority(Thread.MAX_PRIORITY);
        regularThread.setPriority(Thread.NORM_PRIORITY);
        basicThread.setPriority(Thread.MIN_PRIORITY);

        System.out.println("============================================");
        System.out.println("      BANKING APPLICATION STARTED");
        System.out.println("============================================");
        System.out.println("Starting balance checks for all users...\n");

        premiumThread.start();
        regularThread.start();
        basicThread.start();

        try {
            premiumThread.join();
            regularThread.join();
            basicThread.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("============================================");
        System.out.println("   ALL BALANCE CHECKS COMPLETED");
        System.out.println("============================================");
    }
}
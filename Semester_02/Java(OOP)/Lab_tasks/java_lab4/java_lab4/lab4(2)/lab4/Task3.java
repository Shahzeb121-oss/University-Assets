public class BankAccount {
    String accountNumber;
    int balance;

    BankAccount(int bal) {
        this.balance = bal;
    }

    public void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    public void deposit(int dep) {
        balance += dep;
    }

    public void withdraw(int wit, String accountName) {
        if (balance >= wit) {
            balance -= wit;
            System.out.println("Withdrawal of " + wit + " has been completed from " + accountName);
        } else {
            System.out.println("Insufficient balance for withdrawal from " + accountName);
        }
    }

    public static void main(String[] args) {
        BankAccount ac1 = new BankAccount(1000);
        BankAccount ac2 = new BankAccount(500);
        ac1.deposit(500);
        ac2.deposit(1500);
        System.out.println("Balance after deposit 500 in ac1:");
        ac1.checkBalance();
        System.out.println("Balance after deposit 1500 in ac2:");
        ac2.checkBalance();
        ac1.withdraw(500, "ac1");
        System.out.println("ac1 balance after withdrawal:");
        ac1.checkBalance();
        ac2.withdraw(3000, "ac2");
        System.out.println("ac2 balance after withdrawal:");
        ac2.checkBalance();
    }
}

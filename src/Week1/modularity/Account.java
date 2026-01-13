package Week1.modularity;

// Week1.modularity means separate and independent activity

public class Account {
    private double balance=1000;

    public double getBalance() {
        return balance;
    }
    public double updateBalance(double amount) {
        return balance += amount;
    }
}

package Week1.modularity;

public class Transaction {
    /**
     * Updates balance if sufficient; reports outcome
     */
    public void withdraw(Account acc, double amount) {
        if (amount <= acc.getBalance()){
            acc.updateBalance(-amount);
        System.out.println("withdrawn:" + amount);
    }
        else{
            System.out.println("insufficient balance");
        }

    }
    public double deposit(Account acc, double amount) {
        return acc.updateBalance(amount);
    }
}

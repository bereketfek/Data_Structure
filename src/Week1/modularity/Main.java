package Week1.modularity;

public class Main {
    /**
     * Simulates account updates and sends balance notifications
     */
    public static void main(String[] args) {
        Account acc = new Account();
        Transaction t = new Transaction();
        Notification n = new Notification();
        //
        acc.updateBalance(1000);
        n.sendNotification("Balance updated"+" "+acc.getBalance());
        t.withdraw(acc, 500);
        n.sendNotification("Balance updated"+" "+acc.getBalance());

    }
}

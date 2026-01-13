package Week1.contract;

public class debitCard implements payment{// Week1.inheritance

    @Override
    public void pay(double amount) {
        System.out.println("debit card payment");

    }
}

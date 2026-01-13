package Week1.contract;

public class creditCard implements payment {// Week1.inheritance
    @Override
    public void pay(double amount) {
        System.out.println("credit card payment");
    }
}

package Week1.contract;

public class shop {
    public static void main(String[] args){
        payment p = new creditCard();
        p.pay(200);
        payment p2 = new debitCard();
        p2.pay(300);

    }
}

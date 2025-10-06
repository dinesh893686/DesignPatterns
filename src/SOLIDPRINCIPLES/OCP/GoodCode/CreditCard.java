package SOLIDPRINCIPLES.OCP.GoodCode;


public class CreditCard implements PaymentMethod {

    @Override
    public void pay(double amount)
    {
        System.out.println("Payment method called creditCard" + amount);
    }

}

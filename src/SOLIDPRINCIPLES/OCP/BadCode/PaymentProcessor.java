package SOLIDPRINCIPLES.OCP.BadCode;

public class PaymentProcessor {
    public void processPayment(String paymentMethod, int amount)
    {
        if(paymentMethod.equals("CASH"))
        {
            System.out.println(amount + " cash");
        }
        else if(paymentMethod.equals("DEBIT"))
        {
            System.out.println(amount + " debit");
        }
        else if(paymentMethod.equals("CREDIT"))
        {
            System.out.println(amount + " credit");
        }
    }
}

package SOLIDPRINCIPLES.OCP.GoodCode;


public class PaymentProcessor {

       public void processPayment(PaymentMethod paymentMethod, double amount) {
                  paymentMethod.pay(amount);
                  System.out.println("Payment method: " + paymentMethod + " amount: " + amount);
       }
}


package SOLIDPRINCIPLES.OCP.GoodCode;



public class DebitCard implements PaymentMethod {

    @Override
     public void pay(double amount )
     {
         System.out.println("Debit card payment method" + amount );
     }
}

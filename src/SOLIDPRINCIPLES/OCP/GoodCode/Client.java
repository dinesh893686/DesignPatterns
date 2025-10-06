package SOLIDPRINCIPLES.OCP.GoodCode;



public class Client {

    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
           PaymentMethod cc = new CreditCard();
           PaymentMethod dc = new DebitCard();
           paymentProcessor.processPayment(cc,100);
    }
}

package StrategyPattern;

interface PaymentStartegy{
    void processPayment(double amount);
}

class CreditCardPayment implements PaymentStartegy{
    @Override
    public void processPayment(double amount) {
        System.out.println("Credit Card Payment: " + amount);
    }
}

class DebitCardPayment implements PaymentStartegy{
    @Override
    public void processPayment(double amount) {
        System.out.println("Debit Card Payment: " + amount);
    }
}

class CashPayment implements PaymentStartegy{
    @Override
    public void processPayment(double amount) {
        System.out.println("Cash Payment: " + amount);
    }
}

class PaymentService{
    private PaymentStartegy paymentStartegy;

    public void setPaymentStartegy(PaymentStartegy paymentStartegy) {
        this.paymentStartegy = paymentStartegy;
    }

    public void makePayment(double amount)
    {
        paymentStartegy.processPayment(amount);
    }
}

public class StrategyPattern {

    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        paymentService.setPaymentStartegy(new CreditCardPayment());
        paymentService.makePayment(100);
        paymentService.setPaymentStartegy(new DebitCardPayment());
        paymentService.makePayment(100);
        paymentService.setPaymentStartegy(new CashPayment());
        paymentService.makePayment(100);
    }
}

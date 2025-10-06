package StrategyPattern;


class PaymentProcessor{
    public void processPayment(String paymentMethod, double amount)
    {
        switch (paymentMethod) {
            case "CASH":
                System.out.println(amount + " cash");
                break;
            case "DEBIT":
                System.out.println(amount + " debit");

                break;
            case "CREDIT":
                System.out.println(amount + " credit");

                break;
        }
    }
}

public class WithoutStrategyPattern {
      public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.processPayment("CASH", 100);
        paymentProcessor.processPayment("DEBIT", 100);
        paymentProcessor.processPayment("CREDIT", 100);
    }

}

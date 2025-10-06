package Basics.OOPS;

public class Client {
 public static void main(String[] args) {
     PaymentService ps=new PaymentService();
     ps.addPaymentMethod("dineshDebitCard", new DebitCard("123","dineshDebitCard" ));
     ps.addPaymentMethod("dineshCreditCard", new CreditCard("123","debitCard" ));
     ps.addPaymentMethod("dineshUpi", new UPI("8103030@ybl"));

     ps.makePayment("dineshDebitCard");

 }
}

package SOLIDPRINCIPLES.OCP.GoodCode;



public class UPI implements PaymentMethod {
    @Override
    public void pay(double amount)
    {
        System.out.println("UPI Payment Method"+ amount);
    }
}

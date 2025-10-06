package Basics.OOPS;

public class UPI  implements PaymentMethod{
    String upiId;

    public UPI(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay() {
       System.out.println("UPI Payment Method");
    }
}

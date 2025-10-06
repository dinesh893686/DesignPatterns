package Basics.OOPS;

public class CreditCard extends Card {

    public CreditCard(String cardNo, String UserName) {
        super(cardNo, UserName);
    }

    public void pay()
    {
       System.out.println("You have paid your credit card");
    }
}



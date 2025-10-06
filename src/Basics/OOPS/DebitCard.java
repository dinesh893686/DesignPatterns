package Basics.OOPS;

public class DebitCard extends Card{
    public DebitCard(String cardNo, String userName) {
        super(cardNo, userName);
    }
    public void pay()
    {
      System.out.println("Debit Card");
    }
}

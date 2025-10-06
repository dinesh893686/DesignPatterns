package Basics.OOPS;

public  abstract class Card implements  PaymentMethod{
    private final String cardNo;
    private final String userName;

    public Card(String cardNo, String UserName) {
        this.cardNo = cardNo;
        this.userName = UserName;
    }


    public String getCardNo()
    {
        return cardNo;
    }

    public String getUserName()
    {
        return userName;
    }


}

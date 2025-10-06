package ConcurrentBiddingSystemUsingObserverPattern;

public class User implements Observer{
    private String name;

    public User(String name)
    {
        this.name=name;
    }

    @Override
    public void update(String message, float price, String name) {
        System.out.println("User "+ name+"received message:"+ message + " and price is " + price);
    }

    public String getName()
    {
       return name;
    }
}

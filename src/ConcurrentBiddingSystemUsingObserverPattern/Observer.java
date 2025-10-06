package ConcurrentBiddingSystemUsingObserverPattern;

public interface Observer {
     void update(String message,float price, String name);
     String getName();
}

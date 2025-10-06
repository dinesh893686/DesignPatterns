package ConcurrentBiddingSystemUsingObserverPattern;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObserver(String message, float price);
}

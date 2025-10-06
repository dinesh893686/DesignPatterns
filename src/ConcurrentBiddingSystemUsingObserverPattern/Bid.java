package ConcurrentBiddingSystemUsingObserverPattern;

public class Bid {
     private final double amount;
     private final String bidderName;
     private final long timeStamp;

     public Bid(double amount, String bidderName) {
        this.amount = amount;
        this.bidderName = bidderName;
        this.timeStamp = System.currentTimeMillis();
    }

    public double getAmount() {
        return amount;
    }

    public String getBidderName() {
        return bidderName;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}

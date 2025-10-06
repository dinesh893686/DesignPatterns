package ConcurrentBiddingSystemUsingObserverPattern;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class AuctionSystem implements Subject{

    private final ExecutorService notificationExecutor= Executors.newFixedThreadPool(10);
    Set<Observer> bidders=ConcurrentHashMap.newKeySet();

    private final AtomicReference<Bid> highestBid = new AtomicReference<>(new Bid(0,"None"));

    public boolean placeBid(String bidderName, double amount)
    {
        Bid newBid =new Bid(amount, bidderName );

        while(true)
        {
            Bid currentBid= highestBid.get();
            if(newBid.getAmount()<=currentBid.getAmount()) // if new bid is less than or equal to current bid reject it
            {
                return false;
            }
            if(highestBid.compareAndSet(currentBid, newBid))
            {
                notifyObserver("New Highest Bid Placed", (float) newBid.getAmount());
                return true;
            }
        }
    }


//    public void publishUpdate(String message, Integer price, Observer observer)
//    {
//        if(price>highestPrice)
//        {
//            this.highestPrice= price;
//            this.observer=observer;
//            notifyObserver(message, price);
//        }
//    }


//    public void endAuction()
//    {
//        notifyObserver("Auction Ended", highestPrice);
//    }

    @Override
    public void attach(Observer obs) {
        bidders.add(obs);
    }

    @Override
    public void detach(Observer obs) {
        bidders.remove(obs);
    }

    @Override
    public void notifyObserver(String message, float price) {
        for(Observer bidder:bidders)
        {
           notificationExecutor.submit(()->{
               try{
                   bidder.update(message, price, bidder.getName());
               }
               catch(Exception e)
               {
                   System.err.println("Error in notification");
               }
           });
        }
    }
}

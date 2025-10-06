package ConcurrentBiddingSystemUsingObserverPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        AuctionSystem auctionSystem = new AuctionSystem();


//        User user1 = new User("user1");
//        User user2 = new User("user2");
//        User user3 = new User("user3");
//        auctionSystem.attach(user1);
//        auctionSystem.attach(user2);
//        auctionSystem.attach(user3);
//        auctionSystem.placeBid(user1.getName(), 100);
//        auctionSystem.placeBid(user2.getName(), 150);

         // create multiple users
        List<User> users = new ArrayList<>();
        for(int i=1;i<=10;i++)
        {
            User user = new User("Bidder"+i);
            users.add(user);
            auctionSystem.attach(user);
        }

        ExecutorService biddingPool= Executors.newFixedThreadPool(10);

       for(int i=0;i<users.size();i++)
       {
           final int bidderIndex=i;
           final int bidAmount=100+i*10;
           biddingPool.submit(()->{
               try{
                    Thread.sleep(new Random().nextInt(1000));
                    auctionSystem.placeBid(users.get(bidderIndex).getName(), bidAmount);
               }
               catch(InterruptedException e)
               {
                     Thread.currentThread().interrupt();
               }
           });
       }

    }
}

package EventDrivenSystem;


import java.util.concurrent.BlockingQueue;
import java.util.List;
import java.util.ArrayList;

public class Topic<T> {
     private String topicName;
     private List<BlockingQueue<T>> subscribers;
     public Topic(String topicName)
     {
        this.topicName = topicName;
        this.subscribers=new ArrayList<>();
     }   

     public void subscribe(BlockingQueue<T>subscriber)
     {
        subscribers.add(subscriber);
     }

    public void  publish(T event)
     {
        for(BlockingQueue<T>subscriber:subscribers)
        {
            try{
                subscriber.put(event);
            }
            catch(InterruptedException e)
            {
                Thread.currentThread().interrupt();
                System.err.println("Error in publishing event to subscriber");
                e.printStackTrace();
            }
        }
     }
}

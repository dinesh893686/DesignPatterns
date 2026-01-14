package EventDrivenSystem;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class InventoryService implements Runnable {

   private BlockingQueue<OrderEvent> orderEvents= new LinkedBlockingQueue<>();
    
   public BlockingQueue<OrderEvent> getQueue()
   {
      return orderEvents;
   }
 
   @Override 
   public void run()
   {
    while(!Thread.currentThread().isInterrupted())
    {
        try{
            OrderEvent event= orderEvents.take();
            processOrder(event);
            Thread.sleep(100);
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
            System.err.println("Error in taking order event");
        }
    }
   }

   private void processOrder(OrderEvent event)
   {
      System.out.println("Processing order: " + event.getOrderId());
      try{
        Thread.sleep(100);
      }
      catch(InterruptedException e)
      {
        Thread.currentThread().interrupt();
      }
   }
}

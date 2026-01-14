package EventDrivenSystem;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
public class PaymentService implements Runnable {
     
    private BlockingQueue<OrderEvent>queue=new LinkedBlockingQueue<>();
   
    private ConcurrentLinkedQueue<OrderEvent> deadLetterQueue;
    public PaymentService( ConcurrentLinkedQueue<OrderEvent> deadLetterQueue1)
    {
        this.deadLetterQueue=deadLetterQueue1;
    }

    public BlockingQueue<OrderEvent> getQueue()
    {
        return queue;
    }

    @Override 
    public void run()
    {
        while(!Thread.currentThread().isInterrupted())
        {
           try{
            OrderEvent orderEvent=queue.take();
            processPayment(orderEvent);

           }
           catch(InterruptedException e)
           {
            Thread.currentThread().interrupt();
           }
        }
    }


    private void processPayment(OrderEvent event)
    {
        try{
            Thread.sleep(150);
            if(new Random().nextInt(100)<20)
            {
                deadLetterQueue.add(event);
                System.out.println("Payment failed for order: " + event.getOrderId());
            }
            else
            {
                System.out.println("Payment successful for order: " + event.getOrderId());
            }
        }
        catch(InterruptedException e)
        {
            Thread.currentThread().interrupt();
        }
    }
}

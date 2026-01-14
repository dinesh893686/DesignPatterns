package EventDrivenSystem;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SearchIndexerService implements Runnable {

    private BlockingQueue<OrderEvent> queue=new LinkedBlockingQueue<>();

    public BlockingQueue<OrderEvent> getQueue()
    {
        return queue;
    }

    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted())
        {
            try{
                OrderEvent event = queue.take();
                Thread.sleep(100);
            }
            catch(InterruptedException e)
            {
                Thread.currentThread().interrupt();
                System.err.println("Error in search indexer service");
            } 
        }
    }
}

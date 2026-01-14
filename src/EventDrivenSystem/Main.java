package EventDrivenSystem;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

// 4. Event-driven E-commerce Order System (Mediator + Kafka + ES)

// Design a system where:

// Orders are placed → Mediator routes events to multiple services:

// Inventory Service

// Payment Service

// Search Indexer Service (simulate ES update)

// Use Kafka topics (queues) for event passing.

// Each service runs in its own thread.

// Introduce dead-letter queue for failed payments.

// 👉 Why useful: End-to-end event-driven architecture with concurrency + resilience.
public class Main {
   public static void main(String[] args)
   {
    try{

      ConcurrentLinkedQueue<OrderEvent> deadLetterQueue = new ConcurrentLinkedQueue<OrderEvent>();
      Topic<OrderEvent> topic = new Topic<OrderEvent>("order.created");
      InventoryService inventoryService= new InventoryService();
      SearchIndexerService searchIndexerService= new SearchIndexerService();
      PaymentService paymentService = new PaymentService(deadLetterQueue);
      topic.subscribe(paymentService.getQueue());
      topic.subscribe(searchIndexerService.getQueue());
      topic.subscribe(inventoryService.getQueue());
      ExecutorService executorService=Executors.newFixedThreadPool(101);
      Thread.sleep(1000);
      executorService.submit(inventoryService);
      OrderEvent orderEvent1= new OrderEvent("jdkjsc","Order1",11,100.0f);
      topic.publish(orderEvent1);
      executorService.shutdown();
   }
   catch(InterruptedException e)
   {
    Thread.currentThread().interrupt();
    System.err.println("Error in main thread");
    e.printStackTrace();
   }
   finally
   {
    System.out.println("Shutting down executor service");
   }
   }
}




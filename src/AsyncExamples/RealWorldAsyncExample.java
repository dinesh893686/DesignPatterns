package AsyncExamples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Real-world example: Async operations in a web service
 * Similar to how Node.js handles multiple requests
 */
public class RealWorldAsyncExample {
    
    public static void main(String[] args) {
        System.out.println("=== Real-World Async Example ===");
        System.out.println("Simulating a web service handling multiple requests");
        
        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        // Simulate multiple users making requests simultaneously
        for (int i = 1; i <= 5; i++) {
            final int userId = i;
            
            // Each request is handled asynchronously
            CompletableFuture.supplyAsync(() -> {
                return processUserRequest(userId);
            }, executor).thenAccept(result -> {
                System.out.println("Response sent to user " + userId + ": " + result);
            });
        }
        
        System.out.println("All requests submitted, server continues handling other requests...");
        
        // Simulate server doing other work
        for (int i = 0; i < 3; i++) {
            System.out.println("Server handling other tasks: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        // Wait for all requests to complete
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        executor.shutdown();
        System.out.println("All requests completed!");
    }
    
    private static String processUserRequest(int userId) {
        System.out.println("Processing request for user " + userId + "...");
        
        // Simulate different types of heavy operations
        try {
            if (userId % 2 == 0) {
                // Database query
                Thread.sleep(2000);
                return "Database query result for user " + userId;
            } else {
                // File processing
                Thread.sleep(1500);
                return "File processing result for user " + userId;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return "Error processing request for user " + userId;
        }
    }
}

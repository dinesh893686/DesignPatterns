package AsyncExamples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture - Java's way to handle async operations
 * Similar to Promises in JavaScript
 */
public class CompletableFutureExample {
    
    public static void main(String[] args) {
        System.out.println("=== CompletableFuture (Java Promises) ===");
        
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        // Async task that returns a result
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 1: Starting heavy computation...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Task 1 Result";
        }, executor);
        
        // Async task that returns a result
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 2: Starting heavy computation...");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            return "Task 2 Result";
        }, executor);
        
        // Chain operations (like .then() in JavaScript)
        CompletableFuture<String> combined = future1.thenCombine(future2, (result1, result2) -> {
            System.out.println("Combining results: " + result1 + " + " + result2);
            return result1 + " + " + result2;
        });
        
        // Handle completion (like .then() in JavaScript)
        combined.thenAccept(result -> {
            System.out.println("Final result: " + result);
        });
        
        // Do other work while async tasks run
        System.out.println("Main thread continues with other work...");
        for (int i = 0; i < 3; i++) {
            System.out.println("Main thread work: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        // Wait for completion
        try {
            combined.get(5, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
    }
}

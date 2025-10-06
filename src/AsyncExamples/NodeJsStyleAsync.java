package AsyncExamples;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Java equivalent of Node.js async behavior
 * Heavy tasks run in background, main thread continues
 */
public class NodeJsStyleAsync {
    
    public static void main(String[] args) {
        System.out.println("=== Java Async (Node.js Style) ===");
        
        // Create thread pool for background tasks
        ExecutorService executor = Executors.newFixedThreadPool(4);
        
        System.out.println("Start");
        
        // Heavy task 1 - runs in background
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Heavy task 1 started");
            try {
                Thread.sleep(2000); // Simulate heavy work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Heavy task 1 completed");
            return "Result 1";
        }, executor);
        
        // Heavy task 2 - runs in background
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Heavy task 2 started");
            try {
                Thread.sleep(1500); // Simulate heavy work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Heavy task 2 completed");
            return "Result 2";
        }, executor);
        
        // Heavy task 3 - runs in background
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Heavy task 3 started");
            try {
                Thread.sleep(1000); // Simulate heavy work
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Heavy task 3 completed");
            return "Result 3";
        }, executor);
        
        System.out.println("End - Main thread continues immediately");
        
        // Do other work while heavy tasks run in background
        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread doing other work: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        // Wait for all tasks to complete
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        executor.shutdown();
        System.out.println("All tasks completed!");
    }
}

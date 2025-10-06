package AsyncExamples;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.CompletableFuture;

/**
 * Comparison: Blocking vs Non-Blocking operations
 */
public class BlockingVsNonBlocking {
    
    public static void main(String[] args) {
        System.out.println("=== Blocking vs Non-Blocking ===");
        
        // BLOCKING EXAMPLE
        System.out.println("\n--- BLOCKING (Traditional Java) ---");
        blockingExample();
        
        // NON-BLOCKING EXAMPLE
        System.out.println("\n--- NON-BLOCKING (Async Java) ---");
        nonBlockingExample();
    }
    
    private static void blockingExample() {
        System.out.println("Start blocking operations");
        
        // This blocks the main thread
        heavyTask("Blocking Task 1", 2000);
        heavyTask("Blocking Task 2", 1500);
        heavyTask("Blocking Task 3", 1000);
        
        System.out.println("All blocking tasks completed");
    }
    
    private static void nonBlockingExample() {
        System.out.println("Start non-blocking operations");
        
        // These run in background, main thread continues
        CompletableFuture.runAsync(() -> heavyTask("Non-blocking Task 1", 2000));
        CompletableFuture.runAsync(() -> heavyTask("Non-blocking Task 2", 1500));
        CompletableFuture.runAsync(() -> heavyTask("Non-blocking Task 3", 1000));
        
        System.out.println("Main thread continues immediately");
        
        // Main thread can do other work
        for (int i = 0; i < 5; i++) {
            System.out.println("Main thread doing other work: " + i);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        // Wait for background tasks
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("All non-blocking tasks completed");
    }
    
    private static void heavyTask(String taskName, int duration) {
        System.out.println(taskName + " started");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(taskName + " completed");
    }
}

package RideHailingSystem.ThreadingComparison;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SIMPLE EXAMPLE - Why threading matters beyond notifications
 */
public class SimpleExample {
    
    public static void main(String[] args) {
        System.out.println("=== WHY RIDERS NEED THREADS (Beyond Notifications) ===");
        
        // Without threads - unrealistic sequence
        System.out.println("\n--- WITHOUT THREADS (Unrealistic) ---");
        simulateWithoutThreads();
        
        // With threads - realistic concurrency
        System.out.println("\n--- WITH THREADS (Realistic) ---");
        simulateWithThreads();
    }
    
    private static void simulateWithoutThreads() {
        // This is what happens without threading
        System.out.println("Alice: Opens app at 10:00:00");
        System.out.println("Alice: Requests ride at 10:00:01");
        System.out.println("Alice: Waits...");
        System.out.println("Alice: Gets notification at 10:00:05");
        System.out.println("Alice: Closes app at 10:00:06");
        
        System.out.println("Bob: Opens app at 10:00:07");  // Bob waits for Alice!
        System.out.println("Bob: Requests ride at 10:00:08");
        System.out.println("Bob: Waits...");
        System.out.println("Bob: Gets notification at 10:00:12");
        System.out.println("Bob: Closes app at 10:00:13");
        
        System.out.println("❌ Problem: Bob can't use the app until Alice is done!");
    }
    
    private static void simulateWithThreads() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        executor.submit(() -> {
            System.out.println("Alice: Opens app at 10:00:00");
            System.out.println("Alice: Requests ride at 10:00:01");
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            System.out.println("Alice: Gets notification at 10:00:03");
            System.out.println("Alice: Closes app at 10:00:04");
        });
        
        executor.submit(() -> {
            try { Thread.sleep(500); } catch (InterruptedException e) {} // Bob starts slightly later
            System.out.println("Bob: Opens app at 10:00:00.5");
            System.out.println("Bob: Requests ride at 10:00:01.5");
            try { Thread.sleep(1500); } catch (InterruptedException e) {}
            System.out.println("Bob: Gets notification at 10:00:03");
            System.out.println("Bob: Closes app at 10:00:04");
        });
        
        try {
            Thread.sleep(5000); // Let them finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
        System.out.println("✅ Both Alice and Bob can use the app simultaneously!");
    }
}

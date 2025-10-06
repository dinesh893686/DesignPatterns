package RideHailingSystem.ThreadingComparison;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * GOOD EXAMPLE - Riders with separate threads
 * 
 * Benefits:
 * 1. Riders operate concurrently
 * 2. Realistic simulation
 * 3. Asynchronous operations
 * 4. Independent behavior
 */
public class WithThreading {
    
    public static void main(String[] args) {
        System.out.println("=== WITH THREADING (GOOD) ===");
        
        ExecutorService executor = Executors.newFixedThreadPool(3);
        
        // All riders run concurrently
        executor.submit(new RiderSimulation("Rider1"));
        executor.submit(new RiderSimulation("Rider2"));
        executor.submit(new RiderSimulation("Rider3"));
        
        // Let them run for a while
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
        
        System.out.println("\n=== BENEFITS ===");
        System.out.println("✅ Riders operate concurrently");
        System.out.println("✅ Realistic simulation");
        System.out.println("✅ Asynchronous operations");
        System.out.println("✅ Independent behavior");
    }
    
    static class RiderSimulation implements Runnable {
        private final String riderName;
        
        public RiderSimulation(String riderName) {
            this.riderName = riderName;
        }
        
        @Override
        public void run() {
            System.out.println(riderName + ": Started and ready to request rides");
            
            // Simulate multiple activities
            for (int i = 0; i < 3; i++) {
                System.out.println(riderName + ": Requesting ride #" + (i+1));
                
                // Simulate waiting for driver (non-blocking for other riders)
                try {
                    Thread.sleep(1000 + (int)(Math.random() * 2000));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
                
                System.out.println(riderName + ": Driver found for ride #" + (i+1));
                
                // Simulate other activities
                System.out.println(riderName + ": Browsing app while waiting...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            
            System.out.println(riderName + ": Finished all rides");
        }
    }
}

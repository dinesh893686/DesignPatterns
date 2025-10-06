package RideHailingSystem.ThreadingComparison;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * REAL-WORLD EXAMPLE - Why riders need threads
 * 
 * This demonstrates realistic ride hailing scenarios where
 * multiple riders interact with the system simultaneously
 */
public class RealWorldExample {
    
    public static void main(String[] args) {
        System.out.println("=== REAL-WORLD RIDE HAILING SCENARIO ===");
        
        // Simulate a ride hailing system
        RideHailingSystem system = new RideHailingSystem();
        
        // Create multiple riders (each on their own thread)
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        executor.submit(new RealRider("Alice", system));
        executor.submit(new RealRider("Bob", system));
        executor.submit(new RealRider("Charlie", system));
        executor.submit(new RealRider("Diana", system));
        executor.submit(new RealRider("Eve", system));
        
        // Let the system run
        try {
            Thread.sleep(15000); // Run for 15 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        executor.shutdown();
        System.out.println("\n=== SYSTEM SHUTDOWN ===");
    }
    
    static class RideHailingSystem {
        private final BlockingQueue<String> notifications = new LinkedBlockingQueue<>();
        
        public void requestRide(String riderName, String from, String to) {
            System.out.println("🚗 " + riderName + " requested ride from " + from + " to " + to);
            // Simulate processing time
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        
        public void sendNotification(String riderName, String message) {
            System.out.println("📱 " + riderName + " received: " + message);
        }
    }
    
    static class RealRider implements Runnable {
        private final String name;
        private final RideHailingSystem system;
        private final String[] locations = {"Downtown", "Airport", "Mall", "University", "Hospital"};
        
        public RealRider(String name, RideHailingSystem system) {
            this.name = name;
            this.system = system;
        }
        
        @Override
        public void run() {
            System.out.println("👤 " + name + " opened the ride hailing app");
            
            // Simulate realistic user behavior
            for (int i = 0; i < 3; i++) {
                try {
                    // Random delay between actions (realistic user behavior)
                    Thread.sleep(2000 + (int)(Math.random() * 3000));
                    
                    // Request a ride
                    String from = locations[(int)(Math.random() * locations.length)];
                    String to = locations[(int)(Math.random() * locations.length)];
                    while (from.equals(to)) {
                        to = locations[(int)(Math.random() * locations.length)];
                    }
                    
                    system.requestRide(name, from, to);
                    
                    // Simulate waiting and receiving notifications
                    Thread.sleep(1000 + (int)(Math.random() * 2000));
                    system.sendNotification(name, "Driver found! ETA: " + (2 + (int)(Math.random() * 5)) + " minutes");
                    
                    Thread.sleep(1000 + (int)(Math.random() * 2000));
                    system.sendNotification(name, "Driver arrived! Please come outside.");
                    
                    Thread.sleep(1000 + (int)(Math.random() * 2000));
                    system.sendNotification(name, "Ride completed. Rate your driver!");
                    
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            
            System.out.println("👤 " + name + " closed the app");
        }
    }
}

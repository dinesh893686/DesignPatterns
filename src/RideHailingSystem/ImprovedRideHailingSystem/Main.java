package RideHailingSystem.ImprovedRideHailingSystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== IMPROVED RIDE HAILING SYSTEM ===");
        
        // Create mediator
        RideMediator mediator = new RideMediator();
        
        // Create drivers
        Driver driver1 = new Driver(mediator, "Driver1", "John Doe");
        Driver driver2 = new Driver(mediator, "Driver2", "Jane Smith");
        Driver driver3 = new Driver(mediator, "Driver3", "Bob Johnson");
        Driver driver4 = new Driver(mediator, "Driver4", "Alice Brown");
        Driver driver5 = new Driver(mediator, "Driver5", "Charlie Wilson");
        
        // Register drivers
        mediator.registerDriver(driver1);
        mediator.registerDriver(driver2);
        mediator.registerDriver(driver3);
        mediator.registerDriver(driver4);
        mediator.registerDriver(driver5);
        
        // Create riders
        Rider rider1 = new Rider(mediator, "Rider1", "Alice");
        Rider rider2 = new Rider(mediator, "Rider2", "Bob");
        Rider rider3 = new Rider(mediator, "Rider3", "Charlie");
        Rider rider4 = new Rider(mediator, "Rider4", "Diana");
        Rider rider5 = new Rider(mediator, "Rider5", "Eve");
        
        // Register riders
        mediator.registerRider(rider1);
        mediator.registerRider(rider2);
        mediator.registerRider(rider3);
        mediator.registerRider(rider4);
        mediator.registerRider(rider5);
        
        // Create thread pool for both drivers and riders
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        
        // Start drivers on threads
        executorService.submit(driver1);
        executorService.submit(driver2);
        executorService.submit(driver3);
        executorService.submit(driver4);
        executorService.submit(driver5);
        
        // Start riders on threads
        executorService.submit(rider1);
        executorService.submit(rider2);
        executorService.submit(rider3);
        executorService.submit(rider4);
        executorService.submit(rider5);
        
        // Simulate some ride requests
        try {
            Thread.sleep(2000); // Wait for system to initialize
            
            // Create and submit ride requests
            RideRequest rideRequest1 = new RideRequest("Rider1", "REQ001", "Downtown", "Airport", "10:00 AM");
            RideRequest rideRequest2 = new RideRequest("Rider2", "REQ002", "Mall", "University", "10:15 AM");
            RideRequest rideRequest3 = new RideRequest("Rider3", "REQ003", "Hospital", "Station", "10:30 AM");
            
            mediator.requestRide(rideRequest1);
            Thread.sleep(1000);
            
            mediator.requestRide(rideRequest2);
            Thread.sleep(1000);
            
            mediator.requestRide(rideRequest3);
            
            // Let the system run for a while
            Thread.sleep(5000);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Graceful shutdown
            System.out.println("\n=== SHUTTING DOWN SYSTEM ===");
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
            }
        }
    }
}

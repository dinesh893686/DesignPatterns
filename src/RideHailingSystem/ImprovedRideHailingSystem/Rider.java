package RideHailingSystem.ImprovedRideHailingSystem;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Rider implements Runnable {
    private final String riderId;
    private final String riderName;
    private final RideMediator mediator;
    private final Random random;
    private final BlockingQueue<String> notifications;
    private volatile boolean running;
    
    public Rider(RideMediator mediator, String riderId, String riderName) {
        this.mediator = mediator;
        this.riderId = riderId;
        this.riderName = riderName;
        this.random = new Random();
        this.notifications = new LinkedBlockingQueue<>();
        this.running = true;
    }
    
    @Override
    public void run() {
        System.out.println("Rider " + riderId + " (" + riderName + ") started");
        
        while (running) {
            try {
                // Process notifications
                processNotifications();
                
                // Occasionally request a ride (simulate real behavior)
                if (random.nextDouble() < 0.1) { // 10% chance every iteration
                    requestRandomRide();
                }
                
                // Sleep for a bit to avoid busy waiting
                Thread.sleep(3000 + random.nextInt(2000));
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                System.err.println("Error in rider " + riderId + ": " + e.getMessage());
            }
        }
        
        System.out.println("Rider " + riderId + " stopped");
    }
    
    private void processNotifications() {
        String notification;
        while ((notification = notifications.poll()) != null) {
            System.out.println("Rider " + riderId + " received: " + notification);
        }
    }
    
    private void requestRandomRide() {
        String[] locations = {"Downtown", "Mall", "Airport", "University", "Hospital", "Station", "Park", "Library"};
        String pickup = locations[random.nextInt(locations.length)];
        String destination = locations[random.nextInt(locations.length)];
        
        // Make sure pickup and destination are different
        while (pickup.equals(destination)) {
            destination = locations[random.nextInt(locations.length)];
        }
        
        String requestId = "REQ_" + System.currentTimeMillis() + "_" + riderId;
        RideRequest rideRequest = new RideRequest(riderId, requestId, pickup, destination, 
            java.time.LocalTime.now().toString());
        
        mediator.requestRide(rideRequest);
    }
    
    public void requestRide(String pickup, String destination) {
        String requestId = "REQ_" + System.currentTimeMillis() + "_" + riderId;
        RideRequest rideRequest = new RideRequest(riderId, requestId, pickup, destination, 
            java.time.LocalTime.now().toString());
        mediator.requestRide(rideRequest);
    }
    
    public void cancelRide(String requestId) {
        mediator.cancelRide(requestId);
    }
    
    public void receiveNotification(String message) {
        notifications.offer(message);
    }
    
    public void stop() {
        this.running = false;
    }
    
    // Getters
    public String getRiderId() { return riderId; }
    public String getRiderName() { return riderName; }
}

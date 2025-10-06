package RideHailingSystem.ImprovedRideHailingSystem;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Driver implements Runnable {
    private final String driverId;
    private final String driverName;
    private final RideMediator mediator;
    private final Random random;
    private volatile boolean available;
    private volatile boolean running;
    
    public Driver(RideMediator mediator, String driverId, String driverName) {
        this.mediator = mediator;
        this.driverId = driverId;
        this.driverName = driverName;
        this.random = new Random();
        this.available = true;
        this.running = true;
    }
    
    @Override
    public void run() {
        System.out.println("Driver " + driverId + " (" + driverName + ") started and available for rides");
        
        while (running) {
            try {
                if (available) {
                    RideRequest rideRequest = mediator.getNextRideRequest();
                    if (rideRequest != null) {
                        processRideRequest(rideRequest);
                    }
                } else {
                    // Driver is busy with a ride, wait a bit
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                System.err.println("Error in driver " + driverId + ": " + e.getMessage());
            }
        }
        
        System.out.println("Driver " + driverId + " stopped");
    }
    
    private void processRideRequest(RideRequest rideRequest) {
        System.out.println("Driver " + driverId + " considering ride request: " + rideRequest.getRequestId());
        
        // Simulate driver decision making
        boolean shouldAccept = shouldAcceptRide(rideRequest);
        
        if (shouldAccept) {
            boolean accepted = mediator.acceptRide(driverId, rideRequest.getRequestId());
            if (accepted) {
                // Simulate ride duration
                simulateRide(rideRequest);
            }
        } else {
            mediator.rejectRide(driverId, rideRequest.getRequestId());
        }
    }
    
    private boolean shouldAcceptRide(RideRequest rideRequest) {
        // Simulate driver's decision based on various factors
        // In real system, this would consider distance, rating, etc.
        return random.nextDouble() > 0.3; // 70% acceptance rate
    }
    
    private void simulateRide(RideRequest rideRequest) {
        try {
            System.out.println("Driver " + driverId + " starting ride: " + rideRequest.getRequestId());
            
            // Simulate ride duration (2-5 seconds)
            int rideDuration = 2000 + random.nextInt(3000);
            Thread.sleep(rideDuration);
            
            // Complete the ride
            mediator.completeRide(rideRequest.getRequestId());
            mediator.notifyRider(rideRequest.getRiderId(), 
                "Your ride has been completed by " + driverName + " (Driver ID: " + driverId + ")");
            
            System.out.println("Driver " + driverId + " completed ride: " + rideRequest.getRequestId());
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    public void stop() {
        this.running = false;
    }
    
    // Getters and setters
    public String getDriverId() { return driverId; }
    public String getDriverName() { return driverName; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}

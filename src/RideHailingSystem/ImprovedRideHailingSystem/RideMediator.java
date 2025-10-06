package RideHailingSystem.ImprovedRideHailingSystem;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RideMediator {
    private final Map<String, Driver> drivers;
    private final Map<String, Rider> riders;
    private final BlockingQueue<RideRequest> rideRequestsQueue;
    private final Map<String, RideRequest> activeRequests;
    private final Map<String, String> driverRideAssignments; // driverId -> requestId
    private final ReadWriteLock lock;
    
    public RideMediator() {
        this.drivers = new ConcurrentHashMap<>();
        this.riders = new ConcurrentHashMap<>();
        this.rideRequestsQueue = new LinkedBlockingQueue<>();
        this.activeRequests = new ConcurrentHashMap<>();
        this.driverRideAssignments = new ConcurrentHashMap<>();
        this.lock = new ReentrantReadWriteLock();
    }
    
    public void registerDriver(Driver driver) {
        drivers.put(driver.getDriverId(), driver);
        System.out.println("Driver registered: " + driver.getDriverId());
    }
    
    public void registerRider(Rider rider) {
        riders.put(rider.getRiderId(), rider);
        System.out.println("Rider registered: " + rider.getRiderId());
    }
    
    public void requestRide(RideRequest rideRequest) {
        try {
            lock.writeLock().lock();
            rideRequestsQueue.offer(rideRequest);
            activeRequests.put(rideRequest.getRequestId(), rideRequest);
            System.out.println("Ride requested: " + rideRequest.getRequestId() + 
                             " by " + rideRequest.getRiderId() + 
                             " from " + rideRequest.getPickupLocation() + 
                             " to " + rideRequest.getDestination());
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    public void cancelRide(String requestId) {
        try {
            lock.writeLock().lock();
            RideRequest request = activeRequests.get(requestId);
            if (request != null) {
                request.setStatus(RideRequestStatus.CANCELLED);
                activeRequests.remove(requestId);
                rideRequestsQueue.remove(request);
                
                // If driver was assigned, make them available again
                String assignedDriverId = driverRideAssignments.get(requestId);
                if (assignedDriverId != null) {
                    drivers.get(assignedDriverId).setAvailable(true);
                    driverRideAssignments.remove(requestId);
                }
                
                System.out.println("Ride cancelled: " + requestId);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    public RideRequest getNextRideRequest() {
        try {
            return rideRequestsQueue.poll(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }
    
    public boolean acceptRide(String driverId, String requestId) {
        try {
            lock.writeLock().lock();
            RideRequest request = activeRequests.get(requestId);
            Driver driver = drivers.get(driverId);
            
            if (request != null && driver != null && driver.isAvailable()) {
                request.setStatus(RideRequestStatus.ACCEPTED);
                driver.setAvailable(false);
                driverRideAssignments.put(requestId, driverId);
                activeRequests.remove(requestId);
                rideRequestsQueue.remove(request);
                
                System.out.println("Ride accepted: " + requestId + " by driver: " + driverId);
                return true;
            }
            return false;
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    public void rejectRide(String driverId, String requestId) {
        try {
            lock.writeLock().lock();
            RideRequest request = activeRequests.get(requestId);
            if (request != null) {
                // Put the request back in the queue for other drivers
                rideRequestsQueue.offer(request);
                System.out.println("Ride rejected: " + requestId + " by driver: " + driverId);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    public void completeRide(String requestId) {
        try {
            lock.writeLock().lock();
            String driverId = driverRideAssignments.get(requestId);
            if (driverId != null) {
                Driver driver = drivers.get(driverId);
                if (driver != null) {
                    driver.setAvailable(true);
                }
                driverRideAssignments.remove(requestId);
                System.out.println("Ride completed: " + requestId + " by driver: " + driverId);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }
    
    public void notifyRider(String riderId, String message) {
        Rider rider = riders.get(riderId);
        if (rider != null) {
            rider.receiveNotification(message);
        }
    }
    
    public int getAvailableDriversCount() {
        return (int) drivers.values().stream().filter(Driver::isAvailable).count();
    }
    
    public int getPendingRideRequestsCount() {
        return rideRequestsQueue.size();
    }
}

package RideHailingSystem.ImprovedRideHailingSystem;

import java.time.LocalDateTime;

public class RideRequest {
    private final String riderId;
    private final String requestId;
    private final String pickupLocation;
    private final String destination;
    private final String requestTime;
    private RideRequestStatus status;
    private final LocalDateTime createdAt;
    
    public RideRequest(String riderId, String requestId, String pickupLocation, 
                      String destination, String requestTime) {
        this.riderId = riderId;
        this.requestId = requestId;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.requestTime = requestTime;
        this.status = RideRequestStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters
    public String getRiderId() { return riderId; }
    public String getRequestId() { return requestId; }
    public String getPickupLocation() { return pickupLocation; }
    public String getDestination() { return destination; }
    public String getRequestTime() { return requestTime; }
    public RideRequestStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    
    // Setters
    public void setStatus(RideRequestStatus status) { this.status = status; }
    
    @Override
    public String toString() {
        return "RideRequest{" +
                "requestId='" + requestId + '\'' +
                ", riderId='" + riderId + '\'' +
                ", pickup='" + pickupLocation + '\'' +
                ", destination='" + destination + '\'' +
                ", status=" + status +
                ", time='" + requestTime + '\'' +
                '}';
    }
}

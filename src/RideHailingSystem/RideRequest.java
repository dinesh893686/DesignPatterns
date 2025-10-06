package RideHailingSystem;

public class RideRequest {
    private String riderId;
    private RideRequestStatus status;
    private String requestId;
    private String pickupLocation;
    private String destination;
    private String requestTime;

    public RideRequest(String riderId, RideRequestStatus status, String requestId, String pickupLocation, String destination, String requestTime) {
        this.riderId = riderId;
        this.status = status;
        this.requestId = requestId;
        this.pickupLocation = pickupLocation;
        this.destination = destination;
        this.requestTime = requestTime;
    }
    
    public String getRiderId() {
        return riderId;
    }
    public RideRequestStatus getStatus() {
        return status;
    }
    public String getRequestId() {
        return requestId;
    }
    public String getPickupLocation() {
        return pickupLocation;
    }
    public String getDestination() {
        return destination;
    }
    public String getRequestTime() {
        return requestTime;
    }
    public void setStatus(RideRequestStatus status) {
        this.status = status;
    }
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    } 
}

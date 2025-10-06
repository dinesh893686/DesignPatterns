package RideHailingSystem.ImprovedRideHailingSystem;

public enum RideRequestStatus {
    PENDING,    // Request created, waiting for driver
    ACCEPTED,   // Driver accepted the ride
    REJECTED,   // Driver rejected the ride
    CANCELLED,  // Rider cancelled the ride
    IN_PROGRESS,// Ride is in progress
    COMPLETED   // Ride completed successfully
}

package RideHailingSystem;

public interface MediatorInterface {   
    void registerDriver(Driver driver);
    void registerRider(Rider rider);
    void requestRide(RideRequest rideRequest);
    void cancelRide(RideRequest rideRequest);
    void acceptRide(String driverId, String requestId);
    void completeRide(String requestId);
}


package RideHailingSystem;

public class Rider {

    private String riderId;
   
    private Mediator mediator;
      
    public Rider(Mediator mediator, String riderId) {
        this.mediator = mediator;
        this.riderId = riderId;
    }

    public void requestRide(RideRequest rideRequest) {
        mediator.requestRide(rideRequest);
    }
    
    public void cancelRide(RideRequest rideRequest) {
        mediator.cancelRide(rideRequest);
    }

    public String getRiderId() {
        return riderId;
    }
}

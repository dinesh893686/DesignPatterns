package RideHailingSystem;

import java.util.Random;
public class Driver implements Runnable  {
    private String driverId;
   
    private Random random;
    private Mediator mediator;

    public Driver(Mediator mediator, String driverId) {
     this.mediator = mediator;
     this.random = new Random();
     this.driverId = driverId;
    }

    public Driver(String driverId, String driverName, String driverEmail, String driverPhone, String driverAddress, String driverCity, String driverState, String driverZip) {
        this.driverId = driverId;
    }

    public void acceptRideRequest(RideRequest rideRequest) {
        mediator.acceptRide(driverId, rideRequest.getRequestId());
    }

    public void rejectRideRequest(RideRequest rideRequest)
    {
        mediator.rejectRide(driverId, rideRequest.getRequestId());
    }
    @Override
    public void run() {
        while(true){
            RideRequest rideRequest = mediator.getNextRideRequest();
            if(rideRequest == null){
                continue;
            }
            try{
                if(wantToAcceptRideRequest()){
                    acceptRideRequest(rideRequest);
                }
                else{
                    rejectRideRequest(rideRequest);
                }
            }
            catch(Exception e){
                System.err.println("Error in accepting or rejecting ride request");
            }
        }
           }
    

    public boolean wantToAcceptRideRequest() {
        return  random.nextBoolean();
    }

}

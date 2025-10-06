package RideHailingSystem;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Mediator implements MediatorInterface {
    private List<Driver> drivers;
    private List<Rider> riders;
    private BlockingQueue<RideRequest> rideRequestsQueue;
    private Map<String, RideRequest> activeRequests;
    

    public Mediator() {
        this.drivers = new ArrayList<>();
        this.riders = new ArrayList<>();
        this.rideRequestsQueue = new LinkedBlockingQueue<>();    
        this.activeRequests = new ConcurrentHashMap<>();
    }

    @Override
    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    @Override
    public void registerRider(Rider rider) {
        riders.add(rider);
    }

    public void requestRide(RideRequest rideRequest) {
        rideRequestsQueue.add(rideRequest);
        activeRequests.put(rideRequest.getRequestId(), rideRequest);
    }

    public void cancelRide(RideRequest rideRequest) {
        rideRequestsQueue.remove(rideRequest);
    }

    public void acceptRide(String driverId, String requestId) {
        RideRequest request= activeRequests.get(requestId);
        if(request!=null){
            request.setStatus(RideRequestStatus.ACCEPTED);
            activeRequests.remove(requestId);
            rideRequestsQueue.remove(request);
            System.out.println("Ride request accepted by driver: " + driverId);
        }else{
            System.out.println("Ride request not found");
        }
    }

    public void rejectRide(String driverId,String requestId )
    {
        try{
        rideRequestsQueue.put(activeRequests.get(requestId));
        }
        catch(InterruptedException e)
        {
            System.out.println("Ride request not found");
            e.printStackTrace();
        }
    }

    public RideRequest getNextRideRequest(){
        try {
            RideRequest request = rideRequestsQueue.take();
            return request;
        } catch (InterruptedException e) {
            System.out.println("No ride request found");
            e.printStackTrace();
            return null;
        }
    }  

    public void completeRide(String requestId)
    {
        RideRequest request= activeRequests.get(requestId);
        if(request!=null){
            request.setStatus(RideRequestStatus.COMPLETED);
            activeRequests.remove(requestId);
            rideRequestsQueue.remove(request);
            System.out.println("Ride request completed: " + requestId);
        }else{
            System.out.println("Ride request not found");
        }
    }
}

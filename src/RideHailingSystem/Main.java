package RideHailingSystem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) { 
        Mediator mediator = new Mediator();
        Driver driver1 = new Driver(mediator, "Driver1");
        Driver driver2 = new Driver(mediator, "Driver2");
        Driver driver3 = new Driver(mediator, "Driver3");
        Driver driver4 = new Driver(mediator, "Driver4");
        Driver driver5 = new Driver(mediator, "Driver5");
        
        mediator.registerDriver(driver1);
        mediator.registerDriver(driver2);
        mediator.registerDriver(driver3);
        mediator.registerDriver(driver4);
        mediator.registerDriver(driver5);
        

        Rider rider1 = new Rider(mediator, "Rider1");
        Rider rider2 = new Rider(mediator, "Rider2");
        Rider rider3 = new Rider(mediator, "Rider3");
        Rider rider4 = new Rider(mediator, "Rider4");
        Rider rider5 = new Rider(mediator, "Rider5");
        
        mediator.registerRider(rider1);
        mediator.registerRider(rider2);
        mediator.registerRider(rider3);
        mediator.registerRider(rider4);
        mediator.registerRider(rider5);

        RideRequest rideRequest1 = new RideRequest(rider1.getRiderId(), RideRequestStatus.PENDING, "RideRequest1", "Location1", "Location2", "Time1");
        RideRequest rideRequest2 = new RideRequest(rider2.getRiderId(), RideRequestStatus.PENDING, "RideRequest2", "Location2", "Location3", "Time2");
        RideRequest rideRequest3 = new RideRequest(rider3.getRiderId(), RideRequestStatus.PENDING, "RideRequest3", "Location3", "Location4", "Time3");
        RideRequest rideRequest4 = new RideRequest(rider4.getRiderId(), RideRequestStatus.PENDING, "RideRequest4", "Location4", "Location5", "Time4");
        RideRequest rideRequest5 = new RideRequest(rider5.getRiderId(), RideRequestStatus.PENDING, "RideRequest5", "Location5", "Location6", "Time5");
        
        mediator.requestRide(rideRequest1);
        mediator.requestRide(rideRequest2);
        mediator.requestRide(rideRequest3);
        mediator.requestRide(rideRequest4);
        mediator.requestRide(rideRequest5);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(driver1);
        executorService.submit(driver2);
        executorService.submit(driver3);
        executorService.submit(driver4);
        executorService.submit(driver5);     
    }       
}

package RideBookingWorkflowSystemDesign;

public class Main {

    public static void main(String[] args) {
        Ride ride = new Ride();
        ride.searchRide();
        ride.bookRide();
        ride.assignDriver();
        ride.startRide();
        ride.endRide();
    }
}

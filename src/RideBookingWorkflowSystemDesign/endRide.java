package RideBookingWorkflowSystemDesign;

public class endRide implements  State{
    private final Ride ride;

    public endRide(Ride ride )
    {
        this.ride=ride;
    }

    @Override
    public void searchRide() {
        System.out.println("Searching ride");
        ride.setState(ride.getSearchRideState());
    }

    @Override
    public void bookRide() {
        System.out.println("First search the ride then only you can book");
    }

    @Override
    public void assignDriver() {
        System.out.println("First search and book the ride");
    }

    @Override
    public void cancelRide() {
        System.out.println("First search and book the ride");
    }

    @Override
    public void startRide() {
          System.out.println("First search and book the ride");
    }

    @Override
    public void endRide() {
        System.out.println("Ride is already ended");
    }
}

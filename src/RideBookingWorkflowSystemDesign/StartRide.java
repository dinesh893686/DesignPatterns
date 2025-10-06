package RideBookingWorkflowSystemDesign;

public class StartRide implements State{
    private final Ride ride;

    public StartRide(Ride ride)
    {
        this.ride=ride;
    }

    @Override
    public void searchRide()
    {
        System.out.println("Cannot search ride:Ride is already started. Please end ride first");
    }
    @Override
    public void bookRide()
    {
        System.out.println("Cannot book ride:Ride is already started. Please end ride first");
    }

    @Override
    public void assignDriver()
    {
     System.out.println("Cannot assign driver:Ride is already started. Please end ride first");
    }

    @Override
    public void cancelRide()
    {
       System.out.println("Cannot cancel ride:Ride is already started. Please end ride first");
    }


    @Override
    public void startRide()
    {
        System.out.println("Ride is already started");
    }

    @Override
    public void endRide()
    {
        System.out.println("End Ride");
        ride.setState(ride.getEndRideState());
    }
}

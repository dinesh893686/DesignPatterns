package RideBookingWorkflowSystemDesign;

public class assignedDriver implements State{

    private final Ride ride;

    public assignedDriver(Ride ride)
    {
        this.ride=ride;
    }

    @Override
    public void searchRide()
    {
        System.out.println("Cannot search ride:Ride is already assigned.Please cancel ride first");
    }

    @Override
    public void bookRide()
    {
        System.out.println("Cannot book ride:Ride is already assigned. Please cancel ride first");
    }

    @Override
    public void assignDriver()
    {
        System.out.println("Ride is already assigned");

    }

    @Override
    public void cancelRide()
    {
       System.out.println("cancel Ride");
       ride.setState(ride.getCancelRideState());
    }

    @Override
    public void startRide()
    {
        System.out.println("start Ride");
       ride.setState(ride.getStartRideState());
    }

    @Override
    public void endRide()
    {
        System.out.println("Cannot end ride: Ride is not started.Please start ride first");
    }
}

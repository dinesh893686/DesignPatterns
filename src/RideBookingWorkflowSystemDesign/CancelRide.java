package RideBookingWorkflowSystemDesign;

import Basics.OOPS.PaymentMethod;

public class CancelRide implements State{
    private final Ride ride;

    public CancelRide(Ride ride)
    {
        this.ride=ride;
    }

    @Override
    public void searchRide()
    {
        System.out.println("search Ride");
        ride.setState(ride.getSearchRideState());
    }

    @Override
    public void bookRide()
    {
        System.out.println("First complete the search ride process");
    }

    @Override
    public void assignDriver() {
        System.out.println("First search and book ride");
    }


    @Override
    public void cancelRide()
    {
        System.out.println("Ride is already cancelled");
    }


    @Override
    public void startRide()
    {
        System.out.println("First search and book ride");
    }

    @Override
    public void endRide()
    {
        System.out.println("First search and book ride");
    }

}

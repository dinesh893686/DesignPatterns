package RideBookingWorkflowSystemDesign;

public class searchRide implements State{

    private final Ride ride;

    public searchRide(Ride ride)
    {
        this.ride= ride;
    }

   @Override
   public void searchRide()
   {
       System.out.println("Search ride is already in search state");
   }

   @Override
   public void bookRide(){
        System.out.println("Booking ride");
        ride.setState(ride.getBookRideState());
   }

    @Override
    public void assignDriver()
    {
       System.out.println("Cannot assign driver:Ride is not booked. Please book first");
    }

    @Override
    public void cancelRide()
    {
        System.out.println("Cannot cancel ride:Ride is not booked first.Please book first");
    }

    @Override
    public void startRide() {
        System.out.println("Cannot start ride:Ride is not booked. Please book first");
    }

    @Override
    public void endRide() {
         System.out.println("Cannot end ride:Ride is not booked. Please book first");
    }
}

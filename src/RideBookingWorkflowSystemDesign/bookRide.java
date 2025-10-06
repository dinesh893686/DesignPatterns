package RideBookingWorkflowSystemDesign;

public class bookRide implements State{
     private final Ride ride;

     public bookRide(Ride ride)
     {
         this.ride = ride;
     }

     @Override
     public void searchRide()
     {
         System.out.println("Cannot search ride:Ride is already booked. Please cancel the ride first.");
     }

     @Override
     public void bookRide()
     {
        System.out.println("Ride is already booked");
     }

     @Override
     public void assignDriver()
     {
         System.out.println("assign driver");
         ride.setState(ride.getAssignDriverState());
     }

     @Override
     public void cancelRide()
     {
         System.out.println("Cancel Ride");
         ride.setState(ride.getCancelRideState());
     }

     @Override
     public void startRide()
     {
         System.out.println("Cannot start ride :Ride is not assigned. Please assign driver first");
     }

     @Override
    public void endRide()
     {
         System.out.println("Cannpt end ride: Ride is not started.Please start ride first");
     }

}

package RideBookingWorkflowSystemDesign;

public class Ride{
         State state;
         State searchRideState;
         State bookRideState;
         State assignDriverState;
         State startRideState;
         State cancelRideState;
         State endRideState;

         public Ride()
         {
             searchRideState = new searchRide(this);
             bookRideState= new bookRide(this);
             assignDriverState= new assignedDriver(this);
             startRideState= new StartRide(this);
             cancelRideState= new CancelRide(this);
             endRideState= new endRide(this);
             state=searchRideState;
         }

         public void searchRide()
         {
            state.searchRide();
         }

         public void bookRide()
         {
             state.bookRide();

         }
         public void assignDriver()
         {
             state.assignDriver();
         }

         public void cancelRide()
         {
             state.cancelRide();
         }

         public void startRide()
         {
             state.startRide();
         }
         public void endRide()
         {
             state.endRide();
         }


         public void setState(State state )
         {
             this.state=state;
         }

         public State getSearchRideState()
         {
             return searchRideState;
         }

         public State getBookRideState()
         {
             return bookRideState;
         }

         public State getAssignDriverState()
         {
             return assignDriverState;
         }

         public State getStartRideState()
         {
             return startRideState;
         }

         public State getCancelRideState()
         {
             return cancelRideState;
         }

         public State getEndRideState()
         {
             return endRideState;
         }
}

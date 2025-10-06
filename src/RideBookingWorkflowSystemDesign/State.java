package RideBookingWorkflowSystemDesign;

public interface State {
    void searchRide();
    void bookRide();
    void assignDriver();
    void cancelRide();
    void startRide();
    void endRide();
}



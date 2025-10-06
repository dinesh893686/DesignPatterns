package OrderManagementSystem;

public class Order {

    private State state;
    private final State createdState;
    private final State paidState;
    private final State shippedState;
    private final State deliveredState;
    private final State cancelledState;

    public Order() {
        this.createdState = new Created(this);
        this.paidState =    new Paid(this);
        this.shippedState =  new Shipped(this);
        this.deliveredState = new Delivered(this);
        this.cancelledState = new Cancelled(this);
        this.state = createdState;
    }


    public void created() {
        state.created();
    }

    public void paid() {
        state.paid();
    }

    public void shipped() {
        state.shipped();
    }

    public void delivered() {
        state.delivered();
    }

    public void cancelled() {
        state.cancelled();
    }

    public void setState(State state) {
        this.state = state;
    }
    public State getCreatedState() {
        return createdState;
    }
    public State getPaidState() {
        return paidState;
    }
    public State getShippedState() {
        return shippedState;
    }
    public State getDeliveredState() {
        return deliveredState;
    }
    public State getCancelledState() {
        return cancelledState;
    }
    public State getState() {
        return state;
    }
    public void printState() {
        System.out.println("Current state: " + state.getClass().getSimpleName());
    }


}

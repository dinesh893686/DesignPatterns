package ElevatorDesignPattern;

public class Elevator {

    private State state;

    private final State openState;
    private final State closedState;
    private final State movingUpState;
    private final State movingDownState;


    public Elevator() {
        this.openState = new open(this);
        this.closedState = new close(this);
        this.movingUpState = new up(this);
        this.movingDownState = new down(this);
        this.state = closedState;
    }

    public void openDoor() {
        state.openDoor();
    }
    public void closeDoor() {
        state.closeDoor();
    }
    public void moveUp() {
        state.moveUp();
    }
    public void moveDown() {
        state.moveDown();
    }
    public void idle() {
        state.idle();
    }
    public void setState(State state) {
        this.state = state;
    }
    public State getOpenState() {
        return openState;
    }
    public State getClosedState() {
        return closedState;
    }
    public State getMovingUpState() {
        return movingUpState;
    }
    public State getMovingDownState() {
        return movingDownState;
    }
    public State getState() {
        return state;
    }
    public void printState() {
        System.out.println("Current state: " + state.getClass().getSimpleName());
    }




}

package ElevatorDesignPattern;

public class close implements State{

    private final Elevator elevator;

    public close(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void openDoor() {
        System.out.println("Opening door...");
        elevator.setState(elevator.getOpenState());
    }

    @Override
    public void closeDoor() {
        System.out.println("Door is already closed");
    }

    @Override
    public void moveUp() {
        System.out.println("Moving up...");
        elevator.setState(elevator.getMovingUpState());
    }

    @Override
    public void moveDown() {
        System.out.println("Moving down...");
        elevator.setState(elevator.getMovingDownState());
    }

    @Override
    public void idle() {
        System.out.println("Elevator is idle");
    }

}

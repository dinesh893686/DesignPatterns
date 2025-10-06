package ElevatorDesignPattern;

public class open implements State{

    private final Elevator elevator;

    public open(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void openDoor() {
        System.out.println("Door is already open");
    }

    @Override
    public void closeDoor() {
        System.out.println("Closing door...");
        elevator.setState(elevator.getClosedState());
    }

    @Override
    public void moveUp() {
        System.out.println("Cannot move up: Door is open. Please close door first.");
    }

    @Override
    public void moveDown() {
        System.out.println("Cannot move down: Door is open. Please close door first.");
    }

    @Override
    public void idle() {
        System.out.println("Elevator is idle");
    }
}

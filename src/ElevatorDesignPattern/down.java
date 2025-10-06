package ElevatorDesignPattern;


public class down implements State{

    private final Elevator elevator;

    public down(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void openDoor() {
        System.out.println("Cannot open door: Elevator is moving. Please wait until it stops.");
    }

    @Override
    public void closeDoor() {
        System.out.println("Cannot close door: Elevator is moving. Please wait until it stops.");
    }

    @Override
    public void moveUp() {
        System.out.println("Cannot move up: Elevator is moving down. Please wait until it stops.");
    }

    @Override
    public void moveDown() {
        System.out.println("Elevator is already moving down");
    }

    @Override
    public void idle() {
        System.out.println("Elevator is idle");
    }
}

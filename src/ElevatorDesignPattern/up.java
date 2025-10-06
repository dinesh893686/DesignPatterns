package ElevatorDesignPattern;

public class up implements State{

    private final Elevator elevator;

    public up(Elevator elevator) {
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
        System.out.println("Elevator is already moving up");
    }

    @Override
    public void moveDown() {
        System.out.println("Cannot move down: Elevator is moving up. Please wait until it stops.");
    }

    @Override
    public void idle() {
        System.out.println("Elevator is idle");
    }

}

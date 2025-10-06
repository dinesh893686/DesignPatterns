package ElevatorDesignPattern;

public class Main {
    public static void main(String[] args) {
        Elevator elevator = new Elevator();
        elevator.printState();
        elevator.openDoor();
        elevator.printState();
        elevator.closeDoor();
        elevator.printState();
        elevator.moveUp();
        elevator.printState();
        elevator.moveDown();
        elevator.printState();
        elevator.idle();
        elevator.printState();
    }
}

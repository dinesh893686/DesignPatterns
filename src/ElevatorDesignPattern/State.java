package ElevatorDesignPattern;

public interface State  {
    void openDoor();
    void closeDoor();
    void moveUp();
    void moveDown();
    void idle();
}


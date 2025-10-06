package StateDesignPatternTCPConnection;

public class TCPConnection  {

    private State state;
    private final State openState;
    private final State closeState;
    private final State sendState;
    private final State receiveState;
    

    public TCPConnection() {
        this.openState = new Open(this);
        this.closeState = new Close(this);
        this.sendState = new Send(this);
        this.receiveState = new Receive(this);
        
        this.state = closeState;
    }

    public void open() {
        state.open();
    }

    public void close() {
        state.close();
    }

    public void send() {
        state.send();
    }

    public void receive() {
        state.receive();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getOpenState() {
        return openState;
    }

    public State getCloseState() {
        return closeState;
    }

}

package StateDesignPatternTCPConnection;

public class Receive implements  State{
    
    private final TCPConnection tcpConnection;
    
    public Receive(TCPConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }
    
    @Override
    public void open() {
        System.out.println("Connection is already open");
    }
    
    @Override
    public void close() {
        System.out.println("Connection is closed");
        tcpConnection.setState(tcpConnection.getCloseState());
    }
    
    @Override
    public void send() {
        System.out.println("Sending data");
    }
    
    @Override
    public void receive() {
        System.out.println("Receiving data");
    }
}

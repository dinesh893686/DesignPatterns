package StateDesignPatternTCPConnection;

public class Open implements State {
    private final TCPConnection tcpConnection;

    public Open(TCPConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public void open() {
      
        System.out.println("Open connection");
        tcpConnection.setState(tcpConnection.getOpenState());
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

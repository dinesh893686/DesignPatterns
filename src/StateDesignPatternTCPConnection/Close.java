package StateDesignPatternTCPConnection;

public class Close implements State {
    private final TCPConnection tcpConnection;

    public Close(TCPConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public void open() {
        System.out.println("Connection is already closed");
    }


    @Override
    public void close() {
        System.out.println("Connection is already closed");
    }

    @Override
    public void send() {
        System.out.println("Connection is closed");
    }

    @Override
    public void receive() {
        System.out.println("Connection is closed");
    }
}

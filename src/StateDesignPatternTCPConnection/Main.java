package StateDesignPatternTCPConnection;

public class Main {
    
    public static void main(String[] args) {
        TCPConnection tcpConnection = new TCPConnection();
        tcpConnection.open();
        tcpConnection.send();
        tcpConnection.receive();
        tcpConnection.close();
    }
}

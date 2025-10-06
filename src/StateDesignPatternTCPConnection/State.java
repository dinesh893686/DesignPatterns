package StateDesignPatternTCPConnection;

public interface State {
    void open();
    void close();
    void send();
    void receive();
}

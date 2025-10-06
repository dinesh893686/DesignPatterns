package FlightControlSystemUsingMediatorPattern;

interface FlightMEdiator {
    void sendMessage(String message, String flightNo);
    void registerFlight( Flight flight);
}

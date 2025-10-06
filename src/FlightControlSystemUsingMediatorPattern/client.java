package FlightControlSystemUsingMediatorPattern;

public class client {

    public static void main(String[] args) {
        ATC atc = new ATC();
        Flight flight1 = new Flight("123", atc);
        Flight flight2 = new Flight("456", atc);
        atc.registerFlight(flight1);
        atc.registerFlight(flight2);


        flight1.setFlightStatus("Airborne");
        flight2.setFlightStatus("Landing");
        flight1.sendMessage("Landing", "123");
        flight2.sendMessage("Takeoff", "456");  

    }
}

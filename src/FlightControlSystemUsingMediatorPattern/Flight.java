package FlightControlSystemUsingMediatorPattern;

public class Flight {

    private String flightNo;
    FlightMEdiator flightMEdiator;
    String flightStatus;

    public Flight(String flightNo , FlightMEdiator flightMEdiator)
    {
        this.flightNo=flightNo;
        this.flightMEdiator=flightMEdiator;
    
    }
     

    public void setFlightStatus(String flightStatus)
    {
        this.flightStatus=flightStatus;
    }
    public String getFlightStatus()
    {
        return flightStatus;
    }
    public String getFlightNo()
    {
        return flightNo;
    }
    public void sendMessage(String message , String flightNo)
    {
         flightMEdiator.sendMessage(message, flightNo);
    }
    public void receiveMessage(String message , String flightNo)
    {
        System.out.println("Flight "+ flightNo+" received message: "+ message);
    }

}

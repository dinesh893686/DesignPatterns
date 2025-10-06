package FlightControlSystemUsingMediatorPattern;

import java.util.ArrayList;
import java.util.List;

public class ATC implements FlightMEdiator{

    
    List<Flight> flights=new ArrayList<>();

    @Override
    public void registerFlight(Flight flight) 
    {
        flights.add(flight);
    }

    @Override
    public void sendMessage(String message, String flightNo)
    {
        System.out.println("ATC received request: " + message);

        if(message.contains("Landing"))
        {
            boolean flag=false;
            for(Flight flight:flights)
            {
                if(flight.getFlightStatus().equals("Landing"))
                {
                    flag=true;
                    notifyFlight(flightNo,"Abort landing another flight is landing");
                    return;
                }
                
            }
            if(!flag)
            {
                notifyFlight(flightNo,"Landing approved");
            }

        }
        else if(message.contains("Takeoff"))
        {
            boolean flag=false;
            for(Flight flight:flights)
            {
                if(flight.getFlightStatus().equals("Takeoff"))
                {

                    notifyFlight(flightNo,"Abort takeoff another flight is taking off");
                    return;
                }

            }
            notifyFlight(flightNo,"Takeoff approved");
        }
    }

    public void notifyFlight(String flightNo, String message)
    {
        for(Flight flight:flights)
        {
            if(flight.getFlightNo().equals(flightNo))
            {
                flight.setFlightStatus("Landing");
                flight.receiveMessage(message, flightNo);

            }
        }
    }
}

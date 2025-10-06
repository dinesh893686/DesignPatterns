package StatePattern.Solution;

public class DirectionService {
    TransportationModeState transportationModeState;

    public DirectionService(TransportationModeState transportationModeState) {
        this.transportationModeState = transportationModeState;
    }

    public void setTransportationModeState(TransportationModeState transportationModeState) {
        this.transportationModeState = transportationModeState;
    }

    public String getDirection()
    {
        return transportationModeState.getDirection();
    }

    public int calculateETA()
    {
        return transportationModeState.calculateETA();
    }
}

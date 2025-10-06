package StatePattern.Solution;

public class Train implements TransportationModeState{
    @Override
    public String getDirection() {
        return "";
    }

    @Override
    public int calculateETA() {
        return 0;
    }
}

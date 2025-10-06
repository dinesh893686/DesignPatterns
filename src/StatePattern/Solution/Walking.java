package StatePattern.Solution;

public class Walking implements TransportationModeState {


     @Override
     public String getDirection() {
          return "give directions to walk";
     }

     @Override
     public int calculateETA() {
          return 10;
     }
}

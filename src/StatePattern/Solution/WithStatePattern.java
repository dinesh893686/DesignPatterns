package StatePattern.Solution;

public class WithStatePattern {
    public static  void main(String[] args) {
        DirectionService directionService = new DirectionService(new Walking());
        System.out.println(directionService.getDirection());
        System.out.println(directionService.calculateETA());
        directionService.setTransportationModeState(new Car());
        System.out.println(directionService.getDirection());
        System.out.println(directionService.calculateETA());
    }
}

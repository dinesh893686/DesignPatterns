package StateDesignPatternVM;

public class DispensingState implements State {


    private final VendingMachine vendingMachine;
    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
    @Override
    public void insertCoin() {
        System.out.println("Please wait");

    }

    @Override
    public void dispense() {
        System.out.println("Dispensing product");
        vendingMachine.setState(vendingMachine.getNoCoinState());

    }

    @Override
    public void selectProduct(String code) {
        System.out.println("Please wait");

    }

    @Override
    public void refund() {
        System.out.println("Please wait");
    }
}

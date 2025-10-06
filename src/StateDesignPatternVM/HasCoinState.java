package StateDesignPatternVM;

public class HasCoinState implements State{
    private final VendingMachine vendingMachine;

    public HasCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted");

    }

    @Override
    public void dispense() {
          System.out.println("Please select product first");
    }

    @Override
    public void selectProduct(String code) {
        System.out.println("Product selected");

        vendingMachine.setState(vendingMachine.getDispensingState());
    }

    @Override
    public void refund() {
         System.out.println("Coin refunded");

         vendingMachine.setState(vendingMachine.getNoCoinState());
    }
}

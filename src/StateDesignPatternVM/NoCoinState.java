package StateDesignPatternVM;

public class NoCoinState implements State{


    private final VendingMachine vendingMachine;

    public NoCoinState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin Inserted");
        // change the state to has coin state
        // vendingMachine.setState(vendingMachine.getHasCoinState());
        vendingMachine.setState(vendingMachine.getHasCoinState());
    }

    @Override
    public void dispense() {

        System.out.println("Please insert coin first");

    }

    @Override
    public void selectProduct(String code) {
        System.out.println("Please insert coin first");

    }

    @Override
    public void refund() {
        System.out.println("No coin to refund");

    }
}

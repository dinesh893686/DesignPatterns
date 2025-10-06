package StateDesignPatternVM;

public class Refund implements State{

    private final VendingMachine vendingMachine;

    public Refund(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin Inserted");
    }

    @Override
    public void dispense() {
        System.out.println("Please select product first");

    }

    @Override
    public void selectProduct(String code) {
        System.out.println("Please select product first");

    }

    @Override
    public void refund() {
        System.out.println("Coin refunded");
        vendingMachine.setState(vendingMachine.getNoCoinState());

    }
}

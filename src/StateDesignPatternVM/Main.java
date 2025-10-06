package StateDesignPatternVM;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // vending machine should start with no coin state
        // we will pass the inventory to the vending machine
        // do not create a class lets use hashmap to do this
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("A", 10);
        inventory.put("B", 10);
        inventory.put("C", 10);
        VendingMachine vendingMachine = new VendingMachine(inventory);
        vendingMachine.insertCoin();
        vendingMachine.selectProduct("A");
        vendingMachine.dispense();
        vendingMachine.refund();
    }
}

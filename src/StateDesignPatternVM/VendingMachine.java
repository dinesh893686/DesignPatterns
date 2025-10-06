package StateDesignPatternVM;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
      private State state;
      private final Map<String, Integer> inventory= new HashMap<>();
      public VendingMachine(Map<String, Integer> inventory) {
           State noCoinState =  new NoCoinState(this);
           State hasCoinState =  new HasCoinState(this);
           State dispensingState =  new DispensingState(this);
           State refundState =  new Refund(this);
           this.inventory.putAll(inventory);
           this.state = noCoinState;
      }

      public void insertCoin() {
        state.insertCoin();
      }

      public void dispense() {
        state.dispense();
      }

      public void selectProduct(String code) {
        state.selectProduct(code);
      }

      public void refund() {
        state.refund();
      }

      public void setState(State state) {
        this.state = state;
      }

    public State getHasCoinState() {
          return new HasCoinState(this);
    }

    public State getNoCoinState() {
          return new NoCoinState(this);
    }

    public State getDispensingState() {
          return new DispensingState(this);
    }

    public State getRefundState() {
          return new Refund(this);
    }

}

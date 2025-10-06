package StateDesignPatternVM;

public interface State {
    void insertCoin();
    void dispense();
    void selectProduct(String code);
    void refund();
}





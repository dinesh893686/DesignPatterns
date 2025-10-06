package OrderManagementSystem;

public class Cancelled implements State{
    private final Order order;

    public Cancelled(Order order) {
        this.order = order;
    }

    @Override
    public void created() {
        System.out.println("Order cannot be created: Order is already cancelled. Please create a new order.");
    }

    @Override
    public void paid() {
        System.out.println("Order cannot be paid: Order is already cancelled. Please create a new order.");
    }
    @Override
    public void shipped() {
        System.out.println("Order cannot be shipped: Order is already cancelled. Please create a new order.");
    }

    @Override
    public void delivered() {
        System.out.println("Order cannot be delivered: Order is already cancelled. Please create a new order.");
    }

    @Override
    public void cancelled() {
        System.out.println("Order is already cancelled");
    }
}

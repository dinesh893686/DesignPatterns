package OrderManagementSystem;

public class Delivered implements State{

    private final Order order;
    public Delivered(Order order) {
        this.order = order;
    }
    @Override
    public void created() {
        System.out.println("Order cannot be created: Order is already delivered. Please create a new order.");
    }
    @Override
    public void paid() {
        System.out.println("Order cannot be paid: Order is already delivered. Please create a new order.");
    }
    @Override
    public void shipped() {
        System.out.println("Order cannot be shipped: Order is already delivered. Please create a new order.");
    }
    @Override
    public void delivered() {
        System.out.println("Order is already delivered");
    }
    @Override
    public void cancelled() {
        System.out.println("Order cannot be cancelled: Order is already delivered. Please contact customer support.");
    }

}

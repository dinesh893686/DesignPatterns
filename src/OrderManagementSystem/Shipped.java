package OrderManagementSystem;

public class Shipped implements State{
    private final Order order;

    public Shipped(Order order) {
        this.order = order;
    }

    @Override
    public void created() {
        System.out.println("Order cannot be created: Order is already shipped. Please create a new order.");
    }

    @Override
    public void paid() {
        System.out.println("Order cannot be paid: Order is already shipped. Please create a new order.");
    }

    @Override
    public void shipped() {
        System.out.println("Order is already shipped");
    }
    @Override
    public void delivered() {
        System.out.println("Order is delivered");
        order.setState(order.getDeliveredState());
    }

    @Override
    public void cancelled() {
        System.out.println("Order cannot be cancelled: Order is already shipped. Please contact customer support.");
    }
}

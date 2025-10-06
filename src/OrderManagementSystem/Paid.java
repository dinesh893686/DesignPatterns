package OrderManagementSystem;

public class Paid implements State{
    private final Order order;

    public Paid(Order order) {
        this.order = order;
    }

    @Override
    public void created() {
        System.out.println("Order cannot be created: Order is already paid. Please create a new order.");
    }

    @Override
    public void paid() {
        System.out.println("Order is already paid");
    }

    @Override
    public void shipped() {
        System.out.println("Order is shipped");
        order.setState(order.getShippedState());
    }

    @Override
    public void delivered() {
        System.out.println("Order cannot be delivered: Order is not shipped. Please ship first.");
    }

    @Override
    public void cancelled() {
        System.out.println("Order cannot be cancelled: Order is already paid. Please contact customer support.");
    }
}

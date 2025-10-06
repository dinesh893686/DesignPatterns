package OrderManagementSystem;

public class Created implements State{

      private final Order order;

      public Created(Order order) {
          this.order = order;
      }

      @Override
      public void created() {
          System.out.println("Order is already created");
      }

      @Override
      public void paid() {
          System.out.println("Order is paid");
          order.setState(order.getPaidState());
      }

      @Override
      public void shipped() {
          System.out.println("Order cannot be shipped: Order is not paid. Please pay first.");
      }

      @Override
      public void delivered() {
          System.out.println("Order cannot be delivered: Order is not shipped. Please ship first.");
      }

      @Override
      public void cancelled() {
          System.out.println("Order is cancelled");
          order.setState(order.getCancelledState());
      }
}

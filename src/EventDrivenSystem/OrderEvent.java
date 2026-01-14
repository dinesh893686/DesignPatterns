package EventDrivenSystem;


public class OrderEvent {
   String orderId;
   String productId;
   int quantity;
   float amount;

   public OrderEvent(String orderId, String productId, int quantity, float amount) {
    this.orderId = orderId;
    this.productId = productId;
    this.quantity = quantity;
    this.amount = amount;
   }

   public String getOrderId()
   {
    return orderId;
   }

   public String getProductId()
   {
    return productId;
   }

   public int getQuantity()
   {
    return quantity;
   }

   public float getAmount()
   {
    return amount;
   }
}

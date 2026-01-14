package ApiGatewayAndMicroserviceAdapter;
public class ProductServiceResponse {
     private String productId;
     private String productName;
     private double price;

     public ProductServiceResponse(String productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
     }

     public String getProductId() {
        return productId;
     }

     public String getProductName() {
        return productName;
     }

     public double getPrice() {
        return price;
     }
}

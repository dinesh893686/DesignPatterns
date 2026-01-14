package ApiGatewayAndMicroserviceAdapter;
public class ProductService {
    public ProductServiceResponse getProductServiceResponse(String productId)
    {
        String productName ="product-" +productId;
        double price =1000;
        return new ProductServiceResponse(productId, productName, price);
    }
}

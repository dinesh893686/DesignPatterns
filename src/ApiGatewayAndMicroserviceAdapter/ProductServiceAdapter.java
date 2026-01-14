package ApiGatewayAndMicroserviceAdapter;

public class ProductServiceAdapter implements ServiceAdapter {
    @Override
    public UnifiedResponse adaptRequest(Object request)
    {
        ProductServiceResponse productResponse = (ProductServiceResponse)request;

        return new UnifiedResponse("success", productResponse, 200); 
    }
}

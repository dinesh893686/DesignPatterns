package ApiGatewayAndMicroserviceAdapter;
public class Main {
    public static void main(String[] args)
    {
        testAuthAdapter();
        testProductAdapter();
        testLambdaAdapter();
    }

    private static void testAuthAdapter()
    {
        AuthServiceResponse authResponse = new AuthServiceResponse("123", "authToken", 1000);
        ServiceAdapter authAdapter = AdapterFactory.getAdapter("AuthService");
        UnifiedResponse response = authAdapter.adaptRequest(authResponse);
        System.out.println(response.getData());
    }

    private static void testProductAdapter()
    {
        ProductServiceResponse productResponse = new ProductServiceResponse("123", "productName", 1000);
        ServiceAdapter productAdapter = AdapterFactory.getAdapter("ProductService");
        UnifiedResponse response = productAdapter.adaptRequest(productResponse);
        System.out.println(response.getData());
    }
    
    private static void testLambdaAdapter()
    {
        LambdaServiceResponse lambdaResponse = new LambdaServiceResponse("123", 200, "success");
        ServiceAdapter lambdaAdapter = AdapterFactory.getAdapter("LambdaService");
        UnifiedResponse response = lambdaAdapter.adaptRequest(lambdaResponse);
        System.out.println(response.getData());
    }
}

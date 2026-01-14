package ApiGatewayAndMicroserviceAdapter;
public class ApiGateway {
  
      private AuthService authService;
      private ProductService productService;
      private LambdaService lambdaService;

      public ApiGateway(AuthService authService, ProductService productService, LambdaService lambdaService)
      {
        this.authService=authService;
        this.productService=productService;
        this.lambdaService=lambdaService;
      }

      public UnifiedResponse handleAuthRequest(String username, String password)
      {
         AuthServiceResponse authServiceResponse =authService.authenticate(username, password);
         return  AdapterFactory.getAdapter("AuthService").adaptRequest(authServiceResponse);
      }

      public UnifiedResponse handleProductRequest(String productId)
      {
        ProductServiceResponse productServiceResponse =productService.getProductServiceResponse(productId);
        return AdapterFactory.getAdapter("ProductService").adaptRequest(productServiceResponse);
      }

      public UnifiedResponse handleLambdaRequest(String functionName, Object payload)
      {
        LambdaServiceResponse lambdaServiceResponse =lambdaService.callLambdaFunction(functionName, payload);
        return AdapterFactory.getAdapter("LambdaService").adaptRequest(lambdaServiceResponse);
      }
}

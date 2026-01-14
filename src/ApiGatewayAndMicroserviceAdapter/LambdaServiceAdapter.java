package ApiGatewayAndMicroserviceAdapter;
public class LambdaServiceAdapter implements ServiceAdapter{
    @Override
    public UnifiedResponse adaptRequest(Object request)
    {
        LambdaServiceResponse lambdaResponse = (LambdaServiceResponse)request;
        return new UnifiedResponse("success", lambdaResponse, 200); 
    }
}

package ApiGatewayAndMicroserviceAdapter;
public class LambdaService {
    public LambdaServiceResponse callLambdaFunction(String functionName, Object payload)
    {
       return new LambdaServiceResponse(payload, 200, "Function"+ functionName+"executed successfully");
       
    }
}

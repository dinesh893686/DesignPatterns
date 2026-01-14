package ApiGatewayAndMicroserviceAdapter;

public class AuthServiceAdapter implements ServiceAdapter {
   @Override
   public UnifiedResponse adaptRequest(Object request)
   {
     AuthServiceResponse authResponse = (AuthServiceResponse)request;
     return new UnifiedResponse("success", authResponse, 200);
   }
}

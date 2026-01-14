package ApiGatewayAndMicroserviceAdapter;
public class AuthService {
public AuthServiceResponse authenticate(String username, String password)
    { 
        String userId ="user-" +username;
        String token="toekn-"+System.currentTimeMillis();
        long expiresIn=3600;       
        return new AuthServiceResponse(userId, token, expiresIn);
    }

}

package ApiGatewayAndMicroserviceAdapter;
public class AuthServiceResponse {
    private String userId;
    private String authToken;
    private long expiresIn;

    public AuthServiceResponse(String userId, String authToken, long expiresIn) {
        this.userId = userId;
        this.authToken = authToken;
        this.expiresIn = expiresIn;
    }

    public String getUserId() {
        return userId;
    }

    public String getAuthToken() {
        return authToken;
    }
    
    public long getExpiresIn() {
        return expiresIn;
    }
}

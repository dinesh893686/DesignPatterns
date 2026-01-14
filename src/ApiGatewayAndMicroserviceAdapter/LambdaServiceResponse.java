package ApiGatewayAndMicroserviceAdapter;
public class LambdaServiceResponse {
     private Object data;
     private int statusCode;
     private String message;

     public LambdaServiceResponse(Object data, int statusCode, String message) {
        this.data = data;
        this.statusCode = statusCode;
        this.message = message;
     }

     public Object getData() {
        return data;
     }

     public int getStatusCode() {
        return statusCode;
     }

     public String getMessage() {
        return message;
     }
}

package ApiGatewayAndMicroserviceAdapter;

public class UnifiedResponse {
    private String status;
    private Object data;
    private int statusCode;

    public UnifiedResponse(String status, Object data, int statusCode)
    {
        this.status=status;
        this.data=data;
        this.statusCode=statusCode;
    }

    public String getStatus()
    {
        return status;

    }

    public Object getData()
    {
        return data;

    }

    public int getStatusCode()
    {
        return statusCode;
    }
}

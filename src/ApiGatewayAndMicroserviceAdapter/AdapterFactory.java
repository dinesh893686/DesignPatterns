package ApiGatewayAndMicroserviceAdapter;
public class AdapterFactory { 
   public static ServiceAdapter getAdapter(String adapterType)
   {
         if(adapterType.equals("AuthService"))
         {
            return new AuthServiceAdapter();
         }
         else if(adapterType.equals("ProductService"))
         {
            return new ProductServiceAdapter();
         }
         else {
            if(adapterType.equals("LambdaService"))
            {
                return new LambdaServiceAdapter();
            }
            else{
                throw new IllegalArgumentException("Invalid adapter type");
            }
         }
   }
}

package EventDrivenSystem;
import java.util.List;


import java.util.ArrayList;


public class ServiceMediator implements MediatorEventDriven {
    private List<IServiceDefintion>services= new ArrayList<>();


   
    public void addService(IServiceDefintion service){
      services.add(service);
    }
}

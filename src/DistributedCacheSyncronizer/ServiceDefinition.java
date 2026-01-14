package DistributedCacheSyncronizer;

public class ServiceDefinition implements Runnable {
    private String serviceName;
    private CacheMediator cacheMediator;
    public ServiceDefinition(String serviceName, CacheMediator cacheMediator) {
        this.serviceName = serviceName;
        this.cacheMediator = cacheMediator;
    }

    @Override
    public void run()
    {
        while(!Thread.currentThread().isInterrupted())
        {  

            try{ // Create new order
             String orderId = "order:4";
             String orderData = "pending";
             
             cacheMediator.set(orderId, orderData);
             
              Thread.sleep(3000);  // New order every 3 seconds
             
            }
            catch(InterruptedException e)
            {
                Thread.currentThread().interrupt();
                System.err.println("Error in running service: "+serviceName);
                break;
            }
        }
    }

    public void onCacheUpdate()
    {
        System.out.println("Cache updated for service: "+serviceName);
    }
    
    public void onCacheRemove(){
        System.out.println("Cache removed for service: "+serviceName);
    }

    public void setCache(String key, String value)
    {
        cacheMediator.set(key,value);
    }

    public void getCache(String key)
    {
        cacheMediator.get(key);
    } 
}

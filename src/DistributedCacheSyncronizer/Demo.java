package DistributedCacheSyncronizer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Demo {
     public static void main(String [] args)
     {
    CacheMediator cacheMediator=new CacheMediator();
    ServiceDefinition serviceDefinition1=new ServiceDefinition("Service1", cacheMediator);
    ServiceDefinition serviceDefinition2=new ServiceDefinition("Service2", cacheMediator);
    ServiceDefinition serviceDefinition3=new ServiceDefinition("Service3", cacheMediator);
    cacheMediator.addService(serviceDefinition1);
    cacheMediator.addService(serviceDefinition2);
    cacheMediator.addService(serviceDefinition3);

     
    serviceDefinition1.setCache("key1","value1");
    serviceDefinition2.setCache("key2","value2");
    serviceDefinition3.setCache("key3","value3");

    serviceDefinition1.getCache("key1");
    serviceDefinition2.getCache("key2");
    serviceDefinition3.getCache("key3");
    // do i need executor service here?  
    // I need it because one service will not depend on other service i will not have to wait for other service to complete
  
     
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    executorService.submit(serviceDefinition1);
    executorService.submit(serviceDefinition2);
    executorService.submit(serviceDefinition3);

     }
}

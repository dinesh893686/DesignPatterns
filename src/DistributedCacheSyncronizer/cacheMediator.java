package DistributedCacheSyncronizer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import ChatRoomWithMediator.ConcurrentChatDemo;


public class cacheMediator implements mediator {

    private List<ServiceDefinition> serviceDefinitions= new ArrayList<>();
    
    Map<String,String> cache =new  ConcurrentHashMap<>();
    @Override
    public void addService(ServiceDefinition serviceDefinition)
    {
        serviceDefinitions.add(serviceDefinition);
    }

    @Override
    public String get(String key)
    {
       return cache.get(key);
    }

    @Override
    public void set(String key, String value)
    {
       cache.put(key,value);
    }
}

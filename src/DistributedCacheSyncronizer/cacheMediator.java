package DistributedCacheSyncronizer;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// 3. Distributed Cache Synchronizer (Mediator + Redis Concepts)

// Imagine multiple services accessing a shared cache.

// Design a mediator that:

// Routes cache get/set requests.

// Uses a ConcurrentHashMap to simulate Redis.

// Implements locking (ReentrantLock) to avoid race conditions on writes.

// Extend: Add an LRU eviction policy (using LinkedHashMap + locks).

// 👉 Why useful: Practice with concurrency primitives, cache design, Redis-style locks.

public class CacheMediator implements mediator {

    private static final int MAX_CACHE_SIZE=100;

    private List<ServiceDefinition> serviceDefinitions= new ArrayList<>();

    private ReentrantReadWriteLock lock =new ReentrantReadWriteLock();
   
    Map<String, String>lruCache= new LinkedHashMap<String, String>(16,0.75f,true){
      @Override
      protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
          return size() > MAX_CACHE_SIZE;
      }
   };
    
    @Override
    public void addService(ServiceDefinition serviceDefinition)
    {
        serviceDefinitions.add(serviceDefinition);
    }

    @Override
    public String get(String key)
    {
         lock.readLock().lock();
         try{
            return lruCache.get(key);
         }
         finally{ 
          lock.readLock().unlock();
         }
    }

  

    @Override
    public void set(String key, String value)
    {
       lock.writeLock().lock();
       try{
         lruCache.put(key,value);
          notifyAllServices();
       
       }
       finally{
        lock.writeLock().unlock();
       }
    }

    private void notifyAllServices()
    {
        for(ServiceDefinition serviceDefinition:serviceDefinitions)
        {
            serviceDefinition.onCacheUpdate();
        }
    }


// DELETE
@Override
public void remove(String key) {
    lock.writeLock().lock();
    try {
      lruCache.remove(key);
      notifyAllServices();
    } finally {
        lock.writeLock().unlock();
    }
}

// SIZE
@Override
public int size() {
    lock.readLock().lock();
    try {
        return lruCache.size();
    } finally {
        lock.readLock().unlock();
    }
}

// CLEAR
@Override
public void clear() {
    lock.writeLock().lock();
    try {
      lruCache.clear();
    } finally {
        lock.writeLock().unlock();
    }
}
}

package DistributedCacheSyncronizer;

public interface mediator {
    void addService(ServiceDefinition serviceDefinition);

    void get(String key);

    void set(String key, String value);
}

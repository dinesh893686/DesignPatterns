package DistributedCacheSyncronizer;

public interface mediator {
    void addService(ServiceDefinition serviceDefinition);

    String get(String key);

    void set(String key, String value);

    void remove(String key);
    int size();
    void clear();
}

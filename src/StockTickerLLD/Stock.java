package StockTickerLLD;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Stock implements Subject{
    private final ExecutorService notificationExecutor = Executors.newFixedThreadPool(10);
    private final String Symbol;
    private float price;

    public Stock(String Symbol, int price)
    {
        this.Symbol=Symbol;
        this.price=price;
    }

    Set<Observer> s = ConcurrentHashMap.newKeySet();
    void publish(float price ,String Symbol)
    {
           notifyObservers(price ,Symbol);
    }

    @Override
    public void attach(Observer observer) {
         s.add(observer);
    }

    @Override
    public void detach(Observer observer) {
       s.remove(observer);
    }

    @Override
    public void notifyObservers(float price, String Symbol) {
      for(Observer observer:s)
      {
          notificationExecutor.submit(()->{
              try{
                  observer.update(price, Symbol);
              }
              catch(Exception e)
              {
                  System.err.println("Error in notification");
              }
          });
      }
    }

    public void shutdown()
    {
        notificationExecutor.shutdown();
    }

}

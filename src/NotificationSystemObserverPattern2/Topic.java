package NotificationSystemObserverPattern2;

import java.util.HashSet;
import java.util.Set;

public class Topic implements Subject{

    Set<Observer> s =new HashSet<>();
    public void publish(String message)
    {
        notifyObservers(message);
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
    public void notifyObservers(String message) {
        for(Observer observer: s)
        {
            observer.getName();
          observer.update(message, "Topic" );
        }
    }
}

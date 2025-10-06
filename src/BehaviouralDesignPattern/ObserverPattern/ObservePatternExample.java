package BehaviouralDesignPattern.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

//Observer Interface
interface Observer{
    void update(float temp);
}

// subject Interface
interface Subject{
  void attach(Observer obs);
  void detach(Observer obs);
  void notifyObservers();
}

// weather station
class WeatherStationing implements  Subject{

    private float temp;
    private List<Observer> observerList=new ArrayList<>();


    public void setTemperature(float temp)
    {
        this.temp = temp;
        notifyObservers();
    }

    @Override
    public void attach(Observer obs) {
       if(obs!=null)
        observerList.add(obs);
    }

    @Override
    public void detach(Observer obs) {
         observerList.remove(obs);
    }

    @Override
    public void notifyObservers() {
       for(Observer obs:observerList)
       {
           obs.update(temp);
       }
    }
}


class DisplayDevice2 implements Observer{
    @Override
    public void update(float temp) {
        System.out.println("Current temperature is  on display device :" +temp);
    }
}

class MobileDevice implements Observer{
    @Override
    public void update(float temp) {
        System.out.println("Current temperature is on mobile :" +temp);
    }
}

public class ObservePatternExample {
    public static void main(String[] args) {
        // Create a Publisher
        WeatherStationing weatherStationing = new WeatherStationing();
        // Create Subscribers
        DisplayDevice2 displayDevice2 = new DisplayDevice2();
        MobileDevice mobileDevice = new MobileDevice();
        // Register Subscribers with Publisher
        weatherStationing.attach(displayDevice2);
        weatherStationing.attach(mobileDevice);
        // Update temperature
        weatherStationing.setTemperature(10);
        weatherStationing.setTemperature(15);
    }
}

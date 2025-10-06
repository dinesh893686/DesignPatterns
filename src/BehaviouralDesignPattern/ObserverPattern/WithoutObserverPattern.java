package BehaviouralDesignPattern.ObserverPattern;

class DisplayDevice
{
    public void showTemp(float temp)
    {
       System.out.println("Current temperature is :" +temp);
    }
}

class WeatherStation{
  private float temperature;
  private DisplayDevice displayDevice; // can be multiple such devices later on
     public WeatherStation(DisplayDevice displayDevice)
    {
      this.displayDevice = displayDevice;
    }

    public void setTemperature(float temperature)
    {
        this.temperature = temperature;
        notifyDevice();
    }
    public void notifyDevice()
    {
        displayDevice.showTemp(temperature);
    }
}


public class WithoutObserverPattern {

    public static void main(String[] args) {
        DisplayDevice displayDevice = new DisplayDevice();
        WeatherStation weatherStation = new WeatherStation(displayDevice);
        weatherStation.setTemperature(10);
        weatherStation.setTemperature(15);
    }
}

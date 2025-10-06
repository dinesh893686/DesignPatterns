package NotificationSystemObserverPattern2;

public class User implements Observer{

   private final String name;
    @Override
    public void update(String message, String name) {
        System.out.println("User "+ name+"received message:"+ message);
    }
    @Override
    public void getName() {
        System.out.println("User name is:"+ name);
    }


    public User(String name)
    {
        this.name=name;
    }
}

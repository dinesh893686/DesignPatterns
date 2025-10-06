package NotificationSystemObserverPattern2;

public class Main {
    public static void main(String[] args) {
        Topic topic = new Topic();
        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");
        topic.attach(user1);
        topic.attach(user2);
        topic.attach(user3);
        topic.publish("Hello World");
    }
}

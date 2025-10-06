package SOLIDPRINCIPLES.DIP.GoodCode;

public class Main {
    public static void main(String[] args) {
       NotificationService ns=new NotificationService(new EmailService());
       ns.sendNotification("Hello World");
    }
}

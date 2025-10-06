package SOLIDPRINCIPLES.DIP.GoodCode;

public class SMSService implements NotificationChannel {
    @Override
    public void sendNotification(String msg) {
        System.out.println(msg);
    }
}

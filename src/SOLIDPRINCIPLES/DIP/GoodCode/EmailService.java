package SOLIDPRINCIPLES.DIP.GoodCode;

public class EmailService implements  NotificationChannel {


    @Override
    public void sendNotification(String msg) {
         System.out.println(msg);
    }
}

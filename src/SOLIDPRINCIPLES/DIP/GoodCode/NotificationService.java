package SOLIDPRINCIPLES.DIP.GoodCode;

public class NotificationService  {

   private final NotificationChannel notificationChannel;

   public NotificationService(NotificationChannel notificationChannel) {
       this.notificationChannel = notificationChannel;
   }

   public void sendNotification(String message) {
       notificationChannel.sendNotification(message);
   }


}

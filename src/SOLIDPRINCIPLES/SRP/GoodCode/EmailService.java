package SOLIDPRINCIPLES.SRP.GoodCode;

/**
 * GOOD CODE EXAMPLE - Follows Single Responsibility Principle
 * 
 * This class has ONLY ONE responsibility:
 * - Sending emails
 */
public class EmailService {
    
    public void sendWelcomeEmail(User user) {
        System.out.println("Sending welcome email to: " + user.getEmail());
        System.out.println("Subject: Welcome to our platform!");
        System.out.println("Body: Hello " + user.getName() + ", welcome to our platform!");
    }
    
    public void sendPasswordResetEmail(User user) {
        System.out.println("Sending password reset email to: " + user.getEmail());
        System.out.println("Subject: Password Reset Request");
        System.out.println("Body: Click here to reset your password...");
    }
    
    public void sendNotificationEmail(User user, String subject, String message) {
        System.out.println("Sending notification email to: " + user.getEmail());
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + message);
    }
}

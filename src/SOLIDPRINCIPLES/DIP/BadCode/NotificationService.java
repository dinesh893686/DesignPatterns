package SOLIDPRINCIPLES.DIP.BadCode;

public class NotificationService  {

    private final EmailService emailService;
    private final SMSService smsService;

    public NotificationService(EmailService emailService, SMSService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void notifyByEmail(String email)
    {
        emailService.sendEmail(email);
    }

    public void notifyBySMS(String SMS)
    {
        smsService.sendSMS(SMS);
    }

}

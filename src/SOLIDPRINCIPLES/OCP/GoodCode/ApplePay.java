package SOLIDPRINCIPLES.OCP.GoodCode;

/**
 * ANOTHER NEW PAYMENT METHOD - More "Open for Extension" examples
 * 
 * We can keep adding new payment methods without touching existing code
 */
public class ApplePay implements PaymentMethod {
    private String deviceId;
    private String cardLastFour;
    
    public ApplePay(String deviceId, String cardLastFour) {
        this.deviceId = deviceId;
        this.cardLastFour = cardLastFour;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Apple Pay Payment - Amount: " + amount);
        System.out.println("Device ID: " + deviceId);
        System.out.println("Card ending in: " + cardLastFour);
        System.out.println("Using Touch ID / Face ID authentication...");
    }
    
    public String getDeviceId() {
        return deviceId;
    }
    
    public String getCardLastFour() {
        return cardLastFour;
    }
    
    @Override
    public String toString() {
        return "ApplePay{Device: " + deviceId + "}";
    }
}

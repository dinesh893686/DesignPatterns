package SOLIDPRINCIPLES.OCP.GoodCode;

/**
 * DEMONSTRATION: "Open for Extension" in Action
 * 
 * This shows how we can add new payment methods WITHOUT modifying
 * any existing code (PaymentProcessor, PaymentMethod interface, etc.)
 */
public class ExtensionDemo {
    
    public static void main(String[] args) {
        System.out.println("=== OPEN FOR EXTENSION DEMONSTRATION ===");
        System.out.println();
        
        PaymentProcessor processor = new PaymentProcessor();
        
        // EXISTING payment methods (no changes needed)
        System.out.println("--- Existing Payment Methods ---");
        PaymentMethod creditCard = new CreditCard();
        PaymentMethod debitCard = new DebitCard();
        PaymentMethod upi = new UPI();
        
        processor.processPayment(creditCard, 100.0);
        processor.processPayment(debitCard, 200.0);
        processor.processPayment(upi, 50.0);
        
        System.out.println();
        System.out.println("--- NEW Payment Methods (Extension) ---");
        
        // NEW payment methods - we can add these WITHOUT changing existing code!
        PaymentMethod crypto = new CryptoPayment("Bitcoin", "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");
        PaymentMethod applePay = new ApplePay("iPhone-12345", "1234");
        
        processor.processPayment(crypto, 500.0);
        processor.processPayment(applePay, 75.0);
        
        System.out.println();
        System.out.println("=== KEY POINTS ===");
        System.out.println("✅ We added NEW payment methods");
        System.out.println("✅ We did NOT modify PaymentProcessor class");
        System.out.println("✅ We did NOT modify PaymentMethod interface");
        System.out.println("✅ We did NOT modify existing payment classes");
        System.out.println("✅ The system is 'OPEN FOR EXTENSION'");
        System.out.println();
        System.out.println("This is what 'Open for Extension' means:");
        System.out.println("- Add new features by creating new classes");
        System.out.println("- Don't modify existing, working code");
        System.out.println("- Extend functionality through interfaces/abstractions");
    }
}

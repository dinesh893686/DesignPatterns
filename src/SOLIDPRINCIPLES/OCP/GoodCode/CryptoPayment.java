package SOLIDPRINCIPLES.OCP.GoodCode;

/**
 * NEW PAYMENT METHOD - Demonstrates "Open for Extension"
 * 
 * This is a NEW payment method that we can add WITHOUT modifying
 * any existing code (PaymentProcessor, PaymentMethod interface, etc.)
 */
public class CryptoPayment implements PaymentMethod {
    private String cryptoType;
    private String walletAddress;
    
    public CryptoPayment(String cryptoType, String walletAddress) {
        this.cryptoType = cryptoType;
        this.walletAddress = walletAddress;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Crypto Payment: " + cryptoType + " - Amount: " + amount);
        System.out.println("Wallet Address: " + walletAddress);
        System.out.println("Processing blockchain transaction...");
    }
    
    public String getCryptoType() {
        return cryptoType;
    }
    
    public String getWalletAddress() {
        return walletAddress;
    }
    
    @Override
    public String toString() {
        return "CryptoPayment{" + cryptoType + "}";
    }
}

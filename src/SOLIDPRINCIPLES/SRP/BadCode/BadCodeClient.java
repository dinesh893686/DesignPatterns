package SOLIDPRINCIPLES.SRP.BadCode;

/**
 * CLIENT EXAMPLE - Demonstrates the problems with violating SRP
 * 
 * This shows how the bad User class violates Single Responsibility Principle
 */
public class BadCodeClient {
    
    public static void main(String[] args) {
        System.out.println("=== BAD CODE EXAMPLE - Violates SRP ===");
        System.out.println();
        
        // Create a user
        User user = new User("John Doe", "john@example.com", "password123");
        
        // The User class is doing too many things:
        
        // 1. Data management (OK - this is its responsibility)
        System.out.println("User: " + user);
        
        // 2. Validation (Should be separate responsibility)
        System.out.println("Is user valid? " + user.isUserValid());
        
        // 3. Email sending (Should be separate responsibility)
        user.sendWelcomeEmail();
        user.sendPasswordResetEmail();
        
        // 4. Database operations (Should be separate responsibility)
        user.saveToDatabase();
        user.updateInDatabase();
        
        // 5. Authentication (Should be separate responsibility)
        System.out.println("Authentication successful? " + user.authenticate("password123"));
        user.changePassword("password123", "newpassword456");
        
        // 6. Mixed responsibilities in one method
        System.out.println("\n--- Registering a new user ---");
        User newUser = new User("Jane Smith", "jane@example.com", "password789");
        newUser.registerUser(); // This method does validation, database save, AND email sending
        
        System.out.println("\n=== PROBLEMS WITH THIS APPROACH ===");
        System.out.println("1. User class has multiple reasons to change");
        System.out.println("2. Hard to test individual responsibilities");
        System.out.println("3. Violates Single Responsibility Principle");
        System.out.println("4. Difficult to maintain and extend");
        System.out.println("5. Changes to email logic affect user data logic");
    }
}

package SOLIDPRINCIPLES.SRP.GoodCode;

/**
 * CLIENT EXAMPLE - Demonstrates the benefits of following SRP
 * 
 * This shows how separating responsibilities into different classes
 * makes the code more maintainable, testable, and follows SRP
 */
public class GoodCodeClient {
    
    public static void main(String[] args) {
        System.out.println("=== GOOD CODE EXAMPLE - Follows SRP ===");
        System.out.println();
        
        try {
            // Create user service that orchestrates all operations
            UserService userService = new UserService();
            
            // Create a user (only data management)
            User user = new User("John Doe", "john@example.com", "password123");
            System.out.println("Created user: " + user);
            
            // Register user (orchestrated by UserService)
            System.out.println("\n--- Registering user ---");
            userService.registerUser(user);
            
            // Login user
            System.out.println("\n--- User login ---");
            boolean loginSuccess = userService.loginUser("john@example.com", "password123");
            System.out.println("Login successful: " + loginSuccess);
            
            // Change password
            System.out.println("\n--- Changing password ---");
            userService.changeUserPassword("john@example.com", "password123", "newpassword456");
            
            // Create another user to demonstrate
            System.out.println("\n--- Creating another user ---");
            User user2 = new User("Jane Smith", "jane@example.com", "password789");
            userService.registerUser(user2);
            
            // Deactivate user
            System.out.println("\n--- Deactivating user ---");
            userService.deactivateUser("jane@example.com");
            
            System.out.println("\n=== BENEFITS OF THIS APPROACH ===");
            System.out.println("1. Each class has a single responsibility");
            System.out.println("2. Easy to test individual components");
            System.out.println("3. Follows Single Responsibility Principle");
            System.out.println("4. Easy to maintain and extend");
            System.out.println("5. Changes to email logic don't affect user data logic");
            System.out.println("6. Can easily swap implementations (e.g., different email services)");
            
        } catch (ValidationException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}

package SOLIDPRINCIPLES.SRP.GoodCode;

/**
 * COMPARISON DEMO - Shows the difference between bad and good approaches
 */
public class ComparisonDemo {
    
    public static void main(String[] args) {
        System.out.println("=== SINGLE RESPONSIBILITY PRINCIPLE COMPARISON ===");
        System.out.println();
        
        demonstrateBadApproach();
        System.out.println();
        demonstrateGoodApproach();
    }
    
    private static void demonstrateBadApproach() {
        System.out.println("--- BAD APPROACH (Violates SRP) ---");
        System.out.println("One class doing everything:");
        System.out.println("❌ User class handles: data + validation + email + database + auth");
        System.out.println("❌ Multiple reasons to change");
        System.out.println("❌ Hard to test individual features");
        System.out.println("❌ Tightly coupled responsibilities");
        System.out.println("❌ Difficult to maintain");
    }
    
    private static void demonstrateGoodApproach() {
        System.out.println("--- GOOD APPROACH (Follows SRP) ---");
        System.out.println("Separate classes for separate responsibilities:");
        System.out.println("✅ User class: Only user data management");
        System.out.println("✅ UserValidator: Only validation logic");
        System.out.println("✅ EmailService: Only email operations");
        System.out.println("✅ UserRepository: Only database operations");
        System.out.println("✅ AuthenticationService: Only authentication");
        System.out.println("✅ UserService: Only orchestration");
        System.out.println();
        System.out.println("Benefits:");
        System.out.println("✅ Single responsibility per class");
        System.out.println("✅ Easy to test each component");
        System.out.println("✅ Easy to maintain and extend");
        System.out.println("✅ Loose coupling between responsibilities");
        System.out.println("✅ Can swap implementations easily");
    }
}

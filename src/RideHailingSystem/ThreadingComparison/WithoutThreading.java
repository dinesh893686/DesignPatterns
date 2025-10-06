package RideHailingSystem.ThreadingComparison;

/**
 * BAD EXAMPLE - Riders without separate threads
 * 
 * Problems:
 * 1. Riders block each other
 * 2. No concurrent operations
 * 3. Unrealistic simulation
 * 4. No asynchronous notifications
 */
public class WithoutThreading {
    
    public static void main(String[] args) {
        System.out.println("=== WITHOUT THREADING (BAD) ===");
        
        // Simulate riders without threads
        simulateRider1();
        simulateRider2();
        simulateRider3();
        
        System.out.println("\n=== PROBLEMS ===");
        System.out.println("❌ Riders execute one after another");
        System.out.println("❌ No concurrent operations");
        System.out.println("❌ Unrealistic simulation");
        System.out.println("❌ No asynchronous notifications");
    }
    
    private static void simulateRider1() {
        System.out.println("Rider1: Requesting ride...");
        // Simulate some work
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        System.out.println("Rider1: Ride requested");
        
        System.out.println("Rider1: Waiting for driver...");
        try { Thread.sleep(3000); } catch (InterruptedException e) {}
        System.out.println("Rider1: Driver found!");
    }
    
    private static void simulateRider2() {
        System.out.println("Rider2: Requesting ride...");
        // Simulate some work
        try { Thread.sleep(1500); } catch (InterruptedException e) {}
        System.out.println("Rider2: Ride requested");
        
        System.out.println("Rider2: Waiting for driver...");
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        System.out.println("Rider2: Driver found!");
    }
    
    private static void simulateRider3() {
        System.out.println("Rider3: Requesting ride...");
        // Simulate some work
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        System.out.println("Rider3: Ride requested");
        
        System.out.println("Rider3: Waiting for driver...");
        try { Thread.sleep(2500); } catch (InterruptedException e) {}
        System.out.println("Rider3: Driver found!");
    }
}

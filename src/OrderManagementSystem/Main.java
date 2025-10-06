package OrderManagementSystem;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Order Management System Demo ===\n");

        // Scenario 1: Normal order flow
        System.out.println("--- Scenario 1: Normal Order Flow ---");
        Order order1 = new Order();
        order1.printState();

        System.out.println("\n1. Attempting to create order (already created):");
        order1.created();

        System.out.println("\n2. Processing payment:");
        order1.paid();
        order1.printState();

        System.out.println("\n3. Shipping order:");
        order1.shipped();
        order1.printState();

        System.out.println("\n4. Delivering order:");
        order1.delivered();
        order1.printState();

        System.out.println("\n5. Attempting to cancel delivered order:");
        order1.cancelled();

        // Scenario 2: Order cancellation
        System.out.println("\n\n--- Scenario 2: Order Cancellation ---");
        Order order2 = new Order();
        order2.printState();

        System.out.println("\n1. Cancelling order before payment:");
        order2.cancelled();
        order2.printState();

        System.out.println("\n2. Attempting operations on cancelled order:");
        order2.paid();
        order2.shipped();

        // Scenario 3: Invalid transitions
        System.out.println("\n\n--- Scenario 3: Invalid Transitions ---");
        Order order3 = new Order();

        System.out.println("\n1. Attempting to ship unpaid order:");
        order3.shipped();

        System.out.println("\n2. Attempting to deliver unshipped order:");
        order3.delivered();
    }
}

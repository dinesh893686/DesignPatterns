package ChatRoomWithMediator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentChatDemo {
    
    public static void main(String[] args) throws InterruptedException {
        
        // Create thread-safe chat room
        ThreadSafeChatRoom chatRoom = new ThreadSafeChatRoom();
        
        // Create users
        ChatUser alice = new ChatUser("Alice", chatRoom);
        ChatUser bob = new ChatUser("Bob", chatRoom);
        ChatUser charlie = new ChatUser("Charlie", chatRoom);
        ChatUser diana = new ChatUser("Diana", chatRoom);
        
        // Add users to chat room
        chatRoom.addUser(alice);
        chatRoom.addUser(bob);
        chatRoom.addUser(charlie);
        chatRoom.addUser(diana);
        
        System.out.println("\n=== Starting Concurrent Chat Simulation ===\n");
        
        // Create thread pool for concurrent operations
        ExecutorService executor = Executors.newFixedThreadPool(6);
        
        // Simulate multiple users sending messages concurrently
        executor.submit(() -> {
            for (int i = 1; i <= 3; i++) {
                alice.sendMessage("Hello everyone! Message " + i);
                sleep(100);
            }
        });
        
        executor.submit(() -> {
            for (int i = 1; i <= 3; i++) {
                bob.sendMessage("Hey there! Bob's message " + i);
                sleep(150);
            }
        });
        
        executor.submit(() -> {
            for (int i = 1; i <= 2; i++) {
                charlie.sendMessage("Charlie here! Message " + i);
                sleep(200);
            }
        });
        
        // Simulate someone joining late
        executor.submit(() -> {
            sleep(300);
            ChatUser eve = new ChatUser("Eve", chatRoom);
            chatRoom.addUser(eve);
            eve.sendMessage("Hi! I just joined!");
        });
        
        // Simulate reading active users while messages are being sent
        executor.submit(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Active users: " + chatRoom.getActiveUsers());
                sleep(250);
            }
        });
        
        // Simulate someone leaving
        executor.submit(() -> {
            sleep(800);
            chatRoom.removeUser(bob);
        });
        
        // Wait for all tasks to complete
        executor.shutdown();
        executor.awaitTermination(2, TimeUnit.SECONDS);
        
        System.out.println("\n=== Chat Simulation Complete ===");
        System.out.println("Final active users: " + chatRoom.getActiveUsers());
    }
    
    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

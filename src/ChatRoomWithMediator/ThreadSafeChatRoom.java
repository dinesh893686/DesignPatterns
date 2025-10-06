package ChatRoomWithMediator;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeChatRoom implements ChatMediator {
    
    private final List<ChatUser> users;
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    
    public ThreadSafeChatRoom() {
        // Using CopyOnWriteArrayList for thread safety
        this.users = new CopyOnWriteArrayList<>();
    }
    
    @Override
    public void addUser(ChatUser user) {
        // WRITE operation - needs exclusive access
        writeLock.lock();
        try {
            users.add(user);
            System.out.println("User " + user.getName() + " joined the chat");
        } finally {
            writeLock.unlock();
        }
    }
    
    @Override
    public void sendMessage(String message, ChatUser sender) {
        // READ operation - multiple users can send messages simultaneously
        // because we're only reading the users list, not modifying it
        readLock.lock();
        try {
            System.out.println("Broadcasting message from " + sender.getName() + ": " + message);
            
            // Deliver message to all other users
            for (ChatUser user : users) {
                if (!user.getName().equals(sender.getName())) {
                    user.receiveMessage(message, sender.getName());
                }
            }
        } finally {
            readLock.unlock();
        }
    }
    
    public void removeUser(ChatUser user) {
        // WRITE operation - needs exclusive access
        writeLock.lock();
        try {
            users.remove(user);
            System.out.println("User " + user.getName() + " left the chat");
        } finally {
            writeLock.unlock();
        }
    }
    
    public List<String> getActiveUsers() {
        // READ operation - multiple threads can read simultaneously
        readLock.lock();
        try {
            List<String> userNames = new ArrayList<>();
            for (ChatUser user : users) {
                userNames.add(user.getName());
            }
            return userNames;
        } finally {
            readLock.unlock();
        }
    }
}

package MediatorDesignPattern;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ChatRoom implements ChatMediator{

    private List<ChatUser> users= new ArrayList<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public void addUser(ChatUser user) {
       lock.writeLock().lock();
       try{
        this.users.add(user);
        lock.writeLock().unlock();
       }
       catch(Exception e)
       {
        lock.writeLock().unlock();
       }
    }
    
    @Override
    public void sendMessage(String message, ChatUser user) {
        lock.readLock().lock();
        try{
        for(ChatUser u: users) {
            if(u.getName() != user.getName()) {
            u.receiveMessage(message);
            }
        }
        }
        catch(Exception e)
        {
            lock.readLock().unlock();
        }
    }
}

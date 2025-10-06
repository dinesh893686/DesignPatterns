package MediatorDesignPattern;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class ConcurrentChatSimulator {
  
    private ExecutorService executorService;
    private ChatRoom chatRoom;
    private List<ChatUser> users;

    public ConcurrentChatSimulator() {
        this.executorService = Executors.newFixedThreadPool(10);
        this.chatRoom = new ChatRoom();
        this.users=new  CopyOnWriteArrayList<>();
    }

    public void startSimulation(){
          for(int i=1;i<=5;i++)
          {
            ChatUser user = new ChatUser( "User"+i, chatRoom);
            users.add(user);
            chatRoom.addUser(user);
          }
         
          for(ChatUser user:users)
          {
            executorService.submit(user);
          }
          executorService.shutdown();
          while(!executorService.isTerminated())
          {
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
          }
          System.out.println("Simulation ended");
    }
}

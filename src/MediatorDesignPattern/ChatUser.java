package MediatorDesignPattern;

public class ChatUser implements Runnable {

    private String name;
    private ChatRoom chatRoom;

    @Override
    public void run() {
    
        for(int i=0;i<10;i++)
        {
            sendMessage("Hello, I'm " + name);
            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }

            
        }
        
    }
  
    public ChatUser(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }

    public void sendMessage(String message) {
        chatRoom.sendMessage(message, this);
    }

    public void receiveMessage(String message) {
        System.out.println(name + " received message: " + message);
    }

    
    public String getName() {
        return name;
    }
}

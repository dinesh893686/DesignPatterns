package ChatRoomWithMediator;

public class ChatUser {
    private String name;
    private ChatMediator mediator;
    
    public ChatUser(String name, ChatMediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
    
    public void sendMessage(String message) {
        System.out.println(name + " is sending: " + message);
        mediator.sendMessage(message, this);
    }
    
    public void receiveMessage(String message, String senderName) {
        System.out.println("[" + name + "] received from " + senderName + ": " + message);
    }
    
    public String getName() {
        return name;
    }
}


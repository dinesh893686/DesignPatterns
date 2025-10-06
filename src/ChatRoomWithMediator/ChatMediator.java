package ChatRoomWithMediator;

public interface ChatMediator {
    void addUser(ChatUser user);
    void sendMessage(String message, ChatUser user);
}


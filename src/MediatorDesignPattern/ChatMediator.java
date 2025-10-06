package MediatorDesignPattern;

public interface ChatMediator {

    void addUser(ChatUser user);
    void sendMessage(String messaString, ChatUser user);

}



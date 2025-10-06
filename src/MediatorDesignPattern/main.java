package MediatorDesignPattern;

public class main {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();
        ChatUser user1 = new ChatUser("User 1", chatRoom);
        ChatUser user2 = new ChatUser("User 2", chatRoom);
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        user1.sendMessage("Hello User 2");
        user2.sendMessage("Hello User 1");
    }
}

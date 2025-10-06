package SOLIDPRINCIPLES.SRP.GoodCode;

import java.util.ArrayList;
import java.util.List;

/**
 * GOOD CODE EXAMPLE - Follows Single Responsibility Principle
 * 
 * This class has ONLY ONE responsibility:
 * - Database operations for users
 */
public class UserRepository {
    private List<User> users = new ArrayList<>();
    
    public void saveUser(User user) {
        System.out.println("Saving user to database: " + user.getName() + ", " + user.getEmail());
        users.add(user);
        // Simulate database save
    }
    
    public void updateUser(User user) {
        System.out.println("Updating user in database: " + user.getName() + ", " + user.getEmail());
        // Simulate database update
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getEmail().equals(user.getEmail())) {
                users.set(i, user);
                break;
            }
        }
    }
    
    public void deleteUser(User user) {
        System.out.println("Deleting user from database: " + user.getName() + ", " + user.getEmail());
        users.removeIf(u -> u.getEmail().equals(user.getEmail()));
    }
    
    public User findUserByEmail(String email) {
        System.out.println("Finding user by email: " + email);
        return users.stream()
                   .filter(user -> user.getEmail().equals(email))
                   .findFirst()
                   .orElse(null);
    }
    
    public List<User> getAllUsers() {
        System.out.println("Retrieving all users from database");
        return new ArrayList<>(users);
    }
}

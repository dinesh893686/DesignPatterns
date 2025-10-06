package SOLIDPRINCIPLES.SRP.GoodCode;

/**
 * GOOD CODE EXAMPLE - Follows Single Responsibility Principle
 * 
 * This class has ONLY ONE responsibility:
 * - User authentication and password management
 */
public class AuthenticationService {
    
    public boolean authenticate(User user, String inputPassword) {
        return user.getPassword() != null && user.getPassword().equals(inputPassword);
    }
    
    public void changePassword(User user, String oldPassword, String newPassword) throws ValidationException {
        if (!authenticate(user, oldPassword)) {
            throw new ValidationException("Old password is incorrect");
        }
        
        if (newPassword == null || newPassword.length() < 8) {
            throw new ValidationException("New password must be at least 8 characters long");
        }
        
        user.setPassword(newPassword);
        System.out.println("Password changed successfully for user: " + user.getName());
    }
    
    public boolean login(User user, String password) {
        if (authenticate(user, password)) {
            System.out.println("Login successful for user: " + user.getName());
            return true;
        } else {
            System.out.println("Login failed for user: " + user.getName());
            return false;
        }
    }
    
    public void logout(User user) {
        System.out.println("User logged out: " + user.getName());
    }
}

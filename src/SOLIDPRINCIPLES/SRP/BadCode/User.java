package SOLIDPRINCIPLES.SRP.BadCode;

import java.util.ArrayList;
import java.util.List;

/**
 * BAD CODE EXAMPLE - Violates Single Responsibility Principle
 * 
 * This User class has multiple responsibilities:
 * 1. User data management (name, email)
 * 2. User validation
 * 3. Email sending
 * 4. Database operations
 * 5. User authentication
 * 
 * This violates SRP because the class has more than one reason to change.
 */
public class User {
    private String name;
    private String email;
    private String password;
    private boolean isActive;
    
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isActive = true;
    }
    
    // Responsibility 1: User data management
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    // Responsibility 2: User validation
    public boolean isValidEmail() {
        return email != null && email.contains("@") && email.contains(".");
    }
    
    public boolean isValidPassword() {
        return password != null && password.length() >= 8;
    }
    
    public boolean isUserValid() {
        return isValidEmail() && isValidPassword() && name != null && !name.trim().isEmpty();
    }
    
    // Responsibility 3: Email sending
    public void sendWelcomeEmail() {
        if (isValidEmail()) {
            System.out.println("Sending welcome email to: " + email);
            System.out.println("Subject: Welcome to our platform!");
            System.out.println("Body: Hello " + name + ", welcome to our platform!");
        }
    }
    
    public void sendPasswordResetEmail() {
        if (isValidEmail()) {
            System.out.println("Sending password reset email to: " + email);
            System.out.println("Subject: Password Reset Request");
            System.out.println("Body: Click here to reset your password...");
        }
    }
    
    // Responsibility 4: Database operations
    public void saveToDatabase() {
        System.out.println("Saving user to database: " + name + ", " + email);
        // Simulate database save
    }
    
    public void updateInDatabase() {
        System.out.println("Updating user in database: " + name + ", " + email);
        // Simulate database update
    }
    
    public void deleteFromDatabase() {
        System.out.println("Deleting user from database: " + name + ", " + email);
        // Simulate database delete
    }
    
    // Responsibility 5: User authentication
    public boolean authenticate(String inputPassword) {
        return password != null && password.equals(inputPassword);
    }
    
    public void changePassword(String oldPassword, String newPassword) {
        if (authenticate(oldPassword) && newPassword != null && newPassword.length() >= 8) {
            this.password = newPassword;
            System.out.println("Password changed successfully for user: " + name);
        } else {
            System.out.println("Password change failed for user: " + name);
        }
    }
    
    // Additional method that mixes responsibilities
    public void registerUser() {
        if (isUserValid()) {
            saveToDatabase();
            sendWelcomeEmail();
            System.out.println("User registered successfully: " + name);
        } else {
            System.out.println("User registration failed - invalid data");
        }
    }
    
    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "', isActive=" + isActive + "}";
    }
}

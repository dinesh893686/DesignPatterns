package SOLIDPRINCIPLES.SRP.GoodCode;

/**
 * GOOD CODE EXAMPLE - Follows Single Responsibility Principle
 * 
 * This User class has ONLY ONE responsibility:
 * - Managing user data (name, email, password, isActive)
 * 
 * It does NOT handle validation, email sending, database operations, or authentication.
 * Those responsibilities are delegated to separate classes.
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
    
    // Only data management methods - single responsibility
    public String getName() { 
        return name; 
    }
    
    public void setName(String name) { 
        this.name = name; 
    }
    
    public String getEmail() { 
        return email; 
    }
    
    public void setEmail(String email) { 
        this.email = email; 
    }
    
    public String getPassword() { 
        return password; 
    }
    
    public void setPassword(String password) { 
        this.password = password; 
    }
    
    public boolean isActive() { 
        return isActive; 
    }
    
    public void setActive(boolean active) { 
        this.isActive = active; 
    }
    
    @Override
    public String toString() {
        return "User{name='" + name + "', email='" + email + "', isActive=" + isActive + "}";
    }
}

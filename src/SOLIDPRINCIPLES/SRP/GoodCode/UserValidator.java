package SOLIDPRINCIPLES.SRP.GoodCode;

/**
 * GOOD CODE EXAMPLE - Follows Single Responsibility Principle
 * 
 * This class has ONLY ONE responsibility:
 * - Validating user data
 */
public class UserValidator {
    
    public boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
    
    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 8;
    }
    
    public boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }
    
    public boolean isUserValid(User user) {
        return isValidEmail(user.getEmail()) && 
               isValidPassword(user.getPassword()) && 
               isValidName(user.getName());
    }
    
    public void validateUser(User user) throws ValidationException {
        if (!isValidEmail(user.getEmail())) {
            throw new ValidationException("Invalid email format");
        }
        if (!isValidPassword(user.getPassword())) {
            throw new ValidationException("Password must be at least 8 characters long");
        }
        if (!isValidName(user.getName())) {
            throw new ValidationException("Name cannot be empty");
        }
    }
}

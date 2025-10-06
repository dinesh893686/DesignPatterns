package SOLIDPRINCIPLES.SRP.GoodCode;

/**
 * GOOD CODE EXAMPLE - Follows Single Responsibility Principle
 * 
 * This class has ONLY ONE responsibility:
 * - Orchestrating user operations by coordinating between different services
 * 
 * It acts as a facade that uses other single-responsibility classes
 */
public class UserService {
    private UserValidator validator;
    private EmailService emailService;
    private UserRepository userRepository;
    private AuthenticationService authService;
    
    public UserService() {
        this.validator = new UserValidator();
        this.emailService = new EmailService();
        this.userRepository = new UserRepository();
        this.authService = new AuthenticationService();
    }
    
    public void registerUser(User user) throws ValidationException {
        // Validate user data
        validator.validateUser(user);
        
        // Save to database
        userRepository.saveUser(user);
        
        // Send welcome email
        emailService.sendWelcomeEmail(user);
        
        System.out.println("User registered successfully: " + user.getName());
    }
    
    public boolean loginUser(String email, String password) {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            return authService.login(user, password);
        }
        return false;
    }
    
    public void changeUserPassword(String email, String oldPassword, String newPassword) throws ValidationException {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            authService.changePassword(user, oldPassword, newPassword);
            userRepository.updateUser(user);
        } else {
            throw new ValidationException("User not found");
        }
    }
    
    public void deactivateUser(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            user.setActive(false);
            userRepository.updateUser(user);
            System.out.println("User deactivated: " + user.getName());
        }
    }
}

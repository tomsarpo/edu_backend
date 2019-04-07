package fi.haagahelia.backend.divelog.web;

public class UserNotFoundException extends RuntimeException {
 
    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    // ...
}
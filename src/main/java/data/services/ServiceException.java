package data.services;

public class ServiceException extends RuntimeException{

    // Constructor with error message
    public ServiceException(String message) {
        super(message);
    }

    // Constructor with both message and cause if needed
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}

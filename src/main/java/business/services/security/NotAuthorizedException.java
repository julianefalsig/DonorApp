package business.services.security;

public class NotAuthorizedException extends Throwable {
    public NotAuthorizedException(String s) {
        super((s));
    }
}



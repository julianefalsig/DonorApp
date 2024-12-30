package business.security;

import jakarta.annotation.Priority;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.util.Map;

//The class handles filtering-out all incoming API requests that does not have a Token in the header
@Provider
@Priority(1000) // Ensures this filter runs early
public class AuthFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String path = containerRequestContext.getUriInfo().getPath(); // Logging the URI of incoming requests
        System.out.println("Incoming request path: " + path);

        // Skip authentication for the login endpoint
        if ("login".equals(path)) {
            System.out.println("It was a login request");
            return;

        }

        // Retrieve the Authorization header
        String authHeader = containerRequestContext.getHeaderString("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            // If no valid Authorization header is present, block the request
            containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Missing or invalid Authorization header")
                    .build());
            return;
        }

        // Extract the token from the Authorization header
        String token = authHeader.substring("Bearer ".length());

        try {
            // Validate the token
            Map<String, Object> userData = JWTHandler.validate(token);

            // Log or store user information in the request context if needed
            System.out.println("Authenticated user: " + userData);

            // Optionally, you could attach user data to the request context for further use
            containerRequestContext.setProperty("userData", userData);

        } catch (RuntimeException e) {
            // If token validation fails, block the request
            containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Invalid or expired token")
                    .build());
        }
    }
}



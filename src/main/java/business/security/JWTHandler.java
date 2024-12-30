
package business.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import data.entities.User;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

//The class handles token generation, and validation of tokens
public class JWTHandler {
    private static final String key = "hæmli";  // Secret key for signing
    private static final int TOKEN_EXPIRY = 30; // Token expiry in minutes
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper(); // Singleton for JSON parsing

    /**
     * Generate a JWT token with minimal payload.
     *
     * @param user The user for whom the token is generated.
     * @return A signed JWT token as a string.
     */

    public static String generateJwtToken(User user) {
        Calendar expiry = Calendar.getInstance();
        expiry.add(Calendar.MINUTE, TOKEN_EXPIRY);
        Map<String, Object> userPayload = new HashMap<>();

        if (user.getDonor() != null) {  // If the User is a donor
            // Create a minimal payload with essential information only
            userPayload.put("id", user.getId());
            userPayload.put("username", user.getUsername());
            userPayload.put("donorId", user.getDonor().getDonorId());
        } else {// User is a superuser
            userPayload.put("id", user.getId());
            userPayload.put("username", user.getUsername());
        }
        try {
            // Convert payload to JSON string
            String userJson = new ObjectMapper().writeValueAsString(userPayload);

            // Generate the JWT token
            return JWT.create()
                    .withIssuer("ESB")
                    .withClaim("user", userJson)
                    .withExpiresAt(expiry.getTime())
                    .sign(Algorithm.HMAC512(key));
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize user data into JSON", e);
        }
    }

    /**
     * Validate a JWT token and extract its payload.
     *
     * @param token The JWT token to validate.
     * @return A map containing the extracted user information.
     */
    public static Map<String, Object> validate(String token) {
        try {
            // Create a JWT verifier with the secret key
            JWTVerifier verifier = JWT.require(Algorithm.HMAC512(key)).build();

            // Decode and verify the token
            DecodedJWT decodedJWT = verifier.verify(token);

            // Extract the "user" claim
            Claim userClaim = decodedJWT.getClaim("user");

            // Deserialize the JSON payload into a Map
            return OBJECT_MAPPER.readValue(userClaim.asString(), Map.class);
        } catch (Exception e) {
            // Wrap exceptions with a meaningful message
            throw new RuntimeException("Invalid or expired token", e);
        }
    }
}


package business.services.security;
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

public class JWTHandler {
    private static String key = "hæmli";
    private static final int TOKEN_EXPIRY = 30; //2 days


    /**
     * Generate a JWT token with minimal payload.
     *
     * @param user The user for whom the token is generated.
     * @return A signed JWT token as a string.
     */
    public static String generateJwtToken(User user) {
        Calendar expiry = Calendar.getInstance();
        expiry.add(Calendar.MINUTE, TOKEN_EXPIRY);

        // Create a minimal payload with essential information only
        Map<String, Object> userPayload = new HashMap<>();
        userPayload.put("id", user.getId());
        userPayload.put("username", user.getUsername());
        userPayload.put("donorId", user.getDonor().getDonorId());

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

            // Extract the user claim
            Claim userClaim = decodedJWT.getClaim("user");

            // Deserialize the JSON payload back into a Map
            return new ObjectMapper().readValue(userClaim.asString(), Map.class);
        } catch (Exception e) {
            throw new RuntimeException("Invalid or expired token", e);
        }
    }
}




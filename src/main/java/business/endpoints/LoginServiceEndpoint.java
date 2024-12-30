package business.endpoints;
import business.services.LoginService;
import business.security.LoginData;
import business.security.JWTHandler;
import data.entities.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;

//The class contains the endpoint for logging in and also a token test endpoint
@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginServiceEndpoint {

    private LoginService loginService = new LoginService();

    @POST
    public String postLoginData(LoginData login) throws NotAuthorizedException {
        if (login != null) {
            User user = loginService.validateUser(login.getUsername(), login.getPassword());
            if (user != null) {
                String token = JWTHandler.generateJwtToken(user);
                System.out.println(token);
                return token;
            }
        }
        throw new NotAuthorizedException("Incorrect username/password");
    }
    @POST
    @Path("tokentest")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String, Object> postToken(Map<String, String> requestBody) {
        String token = requestBody.get("token");
        return JWTHandler.validate(token);
    }
}
package business.endpoints;
import business.services.LoginService;
import business.services.security.LoginData;
import business.services.security.JWTHandler;
import data.entities.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginServiceEndpoint {

    private LoginService loginService = new LoginService();

    /*public LoginServiceEndpoint(LoginService loginService) {
        this.loginService = loginService;
    }*/

    @POST
    public String postLoginData(LoginData login) throws NotAuthorizedException {
        if (login != null) {
            User user = loginService.validateUser(login.getUsername(), login.getPassword());
            if (user != null) {
                return JWTHandler.generateJwtToken(user);
            }
        }
        throw new NotAuthorizedException("Incorrect username/password");
    }





    @POST
    @Path("tokentest")
    public User postToken(String token) {
        return JWTHandler.validate(token);
    }
}
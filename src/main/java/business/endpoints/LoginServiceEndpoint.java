package business.endpoints;

import business.services.security.LoginData;
import business.services.security.JWTHandler;
import data.entities.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginServiceEndpoint {

    @POST
    public String postLoginData(LoginData login) throws NotAuthorizedException
    {
        if (login!=null && "Bo".equals(login.getUsername()) && "kodeord".equals(login.getPassword())){
            System.out.println(login.getUsername());
            return JWTHandler.generateJwtToken(new User(login.getUsername(), ""));
        }
        throw new NotAuthorizedException("forkert brugernavn/kodeord");
    }

    @POST
    @Path("tokentest")
    public User postToken(String token){
        User validate = JWTHandler.validate(token);
        return validate;
    }

}
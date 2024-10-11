package service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import data.Entities.User;
import data.HibernateController;

@Path("users")
public class UserServiceEndpoint {

    private UserService userService;

    public UserServiceEndpoint() {
        // Opret en ny instans af HibernateController og injicér i UserService
        HibernateController hibernateController = new HibernateController("pgdatabase.donor.4a4b.dk:5432/postgres");
        this.userService = new UserService(hibernateController);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
}

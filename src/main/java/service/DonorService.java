package service;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.Arrays;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Path("donors")
public class DonorService {
    //TODO: replace with real database
    List<String> donor = Arrays.asList("Henrik", "Henning");
    @GET
    public List<String> getDonor(){
        return donor;
    }
}
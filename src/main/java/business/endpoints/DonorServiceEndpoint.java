package business.endpoints;

import business.services.DonorService;
import data.entities.Donor;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("donors")
@Produces(MediaType.APPLICATION_JSON)
public class DonorServiceEndpoint {
    private DonorService donorService = new DonorService();

    // HTTP GET method that returns a list of donor first names
    @GET
    public List<String> getDonorFirstNames() {
        return donorService.getAllDonors();  // Delegate to service layer
    }

    @GET
    @Path("{id}")
    public Donor getdonor(@PathParam("id") int id){
        return donorService.getdonor(id);

}
}




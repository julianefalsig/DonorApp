package business.endpoints;

import business.services.DonorService;
import data.entities.Donor;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

//The class contains the current endpoints related to the donor
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
        return donorService.getdonor(id);}

    @POST
    @Path("/{id}/substep-completed/{done}")
    public void setSubStepCompleted(@PathParam("id") int subStepId, @PathParam("done") boolean status){
        donorService.updateSubIsCompleted(subStepId, status);
    }

    @POST
    @Path("/{id}/step-completed/{stepNumber}/{done}")
    public void setCompleted(@PathParam("id") int donorId, @PathParam("stepNumber") int stepNumber, @PathParam("done") boolean status) {
        donorService.updateIsCompleted(donorId, stepNumber, status);
    }
}




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
        return donorService.getAllDonors();  // This one is not being used, has just been for testing
    }
    @GET //Endpoint for fetching all donor data  given the donorID
    @Path("{id}")
    public Donor getdonor(@PathParam("id") int id){ //Endpoint for fetching all donor data  given the donorID
        return donorService.getdonor(id);}

    @POST //endpoint for updating/completing a donor sub-step
    @Path("/{id}/substep-completed/{done}")
    public void setSubStepCompleted(@PathParam("id") int subStepId, @PathParam("done") boolean status){
        donorService.updateSubIsCompleted(subStepId, status);
    }

    @POST //Endpoint for updating/completing a donor qulificationstep
    @Path("/{id}/step-completed/{stepNumber}/{done}")
    public void setCompleted(@PathParam("id") int donorId, @PathParam("stepNumber") int stepNumber, @PathParam("done") boolean status) {
        donorService.updateIsCompleted(donorId, stepNumber, status);
    }
}




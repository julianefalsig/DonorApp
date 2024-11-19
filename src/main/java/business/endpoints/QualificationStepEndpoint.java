package business.endpoints;

import business.DTOs.DonorQualificationStepDTO;
import business.services.DonorService;
import business.services.QualificationStepService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("qualificationstep")
@Produces(MediaType.APPLICATION_JSON)
public class QualificationStepEndpoint {

    QualificationStepService qualificationStepService = new QualificationStepService();
    @GET
    public List<DonorQualificationStepDTO> getQualificationStep() {
        return qualificationStepService.getQualificationStepOnDonor(852);  // Delegate to service layer
    }
    @POST
    @Path("/{id}/completed/{done}")
    public void setCompleted(@PathParam("id") int completed, @PathParam("done") Boolean done)
    {
        System.out.println(completed);
           }
}

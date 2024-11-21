package business.endpoints;

import business.DTOs.DonorQualificationStepDTO;
import business.services.testServices.QualificationStepService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("qualificationstep")
@Produces(MediaType.APPLICATION_JSON)
public class QualificationStepEndpoint {

    QualificationStepService qualificationStepService = new QualificationStepService();
    @GET
    /*
    public List<QualificationStep> getQualificationStep() {
        return qualificationStepService.getQualificationStepOnDonor(952);  // Delegate to service layer
    }*/
    public List<DonorQualificationStepDTO> getQualificationStep() {
        return qualificationStepService.getQualificationStepOnDonor(952);
    }
    @POST
    @Path("/{id}/completed/{done}")
    public void setCompleted(@PathParam("id") int completed, @PathParam("done") Boolean done){
        System.out.println(completed);       }
}

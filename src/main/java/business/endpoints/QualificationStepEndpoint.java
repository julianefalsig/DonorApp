package business.endpoints;

import business.DTOs.DonorQualificationStepDTO;
import business.services.DonorService;
import business.services.QualificationStepService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
}

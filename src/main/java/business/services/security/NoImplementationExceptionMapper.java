

package business.services.security;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.core.Response;

@Provider
public class NoImplementationExceptionMapper implements ExceptionMapper<NoImplementationException> {

    @Override
    public Response toResponse(NoImplementationException e) {
        return Response.status(Response.Status.NOT_IMPLEMENTED)
                .entity(e.getMessage())
                .build();
    }


}


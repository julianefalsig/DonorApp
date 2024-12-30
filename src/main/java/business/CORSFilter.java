package business;

import jakarta.annotation.Priority;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
//The class handles filtering of API requests
@Provider
@Priority(500)
public class CORSFilter implements ContainerRequestFilter {
    @Context
    private HttpServletRequest request;
    @Context
    private HttpServletResponse response;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS, PATCH");
        String requestAllowHeader = request.getHeader("Access-Control-Request-Headers");
        response.setHeader("Access-Control-Allow-Headers", requestAllowHeader);
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        response.setHeader("encoding", "utf-8");

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK); // Respond with HTTP 200 for OPTIONS.
            System.out.println(" det lykkedes");
            requestContext.abortWith(Response.ok().build());
            return;
            // Skip further processing for preflight requests.
        }
    }
}
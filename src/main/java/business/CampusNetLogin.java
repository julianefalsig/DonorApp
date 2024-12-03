package business;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import kong.unirest.Unirest;

@Path("campusnet")
public class CampusNetLogin {

    @GET
    @Path("login")
    public Response login(){
        String URI =  "https://auth.dtu.dk/dtu/?service=http://localhost:8080/api/campusnet/redirect";
        return Response.seeOther(UriBuilder.fromUri(URI).build()).build();
    }

    @GET @Path("redirect")
    public String callback(@QueryParam("ticket") String cnTicket){
        System.out.println(cnTicket); //Check if we got something back
        //Tjek ticket mod CampusNet
        String body = Unirest.get( "https://auth.dtu.dk/dtu/validate?service=http://localhost:8080/api/campusnet/redirect&ticket="
                        + cnTicket)
                .asString()
                .getBody();
        return body; //Just return the result for now
    }

}
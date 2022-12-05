package fr.em.mailapi.endpoint;

import fr.em.mailapi.security.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/mail")
@Tag(name = "mail")
public class MailRessource {

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(User user){
        if (user.getLogin().equals("admin") && user.getPassword().equals("string")){
            return Response.ok().build();
        }
        else
            return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}

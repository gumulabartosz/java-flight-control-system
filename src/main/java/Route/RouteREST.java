package Route;

import Airplane.Airplane;
import Airport.Airport;
import Flight.Flight;
import Route.DTO.CreateRouteRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
@Path("/routes")
public class RouteREST {

    @Inject
    RouteService routeService;

    @GET
    @Path("/all")
    public List<Route> all(){
        return Route.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Route add(CreateRouteRequest req){
        return routeService.createRoute(req);
    }
}

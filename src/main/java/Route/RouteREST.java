package Route;

import Airplane.Airplane;
import Airport.Airport;
import Flight.Flight;
import Reservation.Reservation;
import Route.DTO.CreateRouteRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
@Path("/routes")
public class RouteREST {

    @Inject
    RouteService routeService;

    @GET
    public Response getAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("50") int size
    ) {

        size = Math.min(size, 100);

        List<Route> routes = routeService.findAllPaged(page, size);
        long total = routeService.count();

        return Response.ok(routes)
                .header("X-Total-Count", total)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Route add(CreateRouteRequest req){
        return routeService.createRoute(req);
    }
}

package Flight;

import Flight.DTO.CreateFlightRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/flights")

public class FlightREST {

    @Inject
    FlightService flightService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Flight createFlight(CreateFlightRequest req){
        return flightService.createFlight(req);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("50") int size){

        size = Math.min(size, 100);

        List<Flight> flights = flightService.findAllPaged(page, size);
        long total = flightService.count();
        return Response.ok(flights).header("X-Total-Count", total).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {

        Flight flight = flightService.findById(id);

        if (flight == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Flight with id " + id + " not found.")
                    .build();
        }
        return Response.ok(flight).build();
    }
}

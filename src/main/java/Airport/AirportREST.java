package Airport;

import Airport.DTO.CreateAirportRequest;
import Flight.Flight;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Path("/airports")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class AirportREST {

    @Inject
    AirportService airportService;


    @POST
    public Airport createAirport(CreateAirportRequest request){

        return airportService.createAirport(request);
    }

    @GET
    public Response getAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("50") int size
    ) {
        size = Math.min(size, 100);

        List<Airport> airports = airportService.findAllPaged(page, size);
        long total = airportService.count();

        return Response.ok(airports)
                .header("X-Total-Count", total)
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {

        Airport airport = airportService.findById(id);

        if (airport == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Flight with id " + id + " not found")
                    .build();
        }
        return Response.ok(airport).build();
    }

}

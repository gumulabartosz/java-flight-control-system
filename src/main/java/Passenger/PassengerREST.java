package Passenger;

import Airplane.Airplane;
import Airplane.AirplaneService;
import Flight.Flight;
import Passenger.DTO.CreatePassengerRequest;
import Route.Route;
import Route.RouteService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/passengers")
public class PassengerREST {

    @Inject
    PassengerService passengerService;

    @GET
    public Response getAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("20") int size
    ) {

        size = Math.min(size, 100);

        List<Passenger> passengers = passengerService.findAllPaged(page, size);
        long total = passengerService.count();

        return Response.ok(passengers)
                .header("X-Total-Count", total)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Passenger create(CreatePassengerRequest req){
        return passengerService.cretePassenger(req);

    }

}






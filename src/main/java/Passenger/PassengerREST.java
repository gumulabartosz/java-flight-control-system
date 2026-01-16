package Passenger;

import Airplane.Airplane;
import Airplane.AirplaneService;
import Airplane.DTO.UpdateAirplaneRequest;
import Flight.Flight;
import Passenger.DTO.CreatePassengerRequest;
import Passenger.DTO.UpdatePassengerRequest;
import Route.Route;
import Route.RouteService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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

    @PUT
    @Path("/{id}")
    public Response update(
            @PathParam("id") Long id,
            @NotNull @Valid UpdatePassengerRequest req
    ) {
        Passenger passenger = passengerService.update(id, req);
        return Response.ok(passenger).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        passengerService.delete(id);
        return Response.noContent().build();
    }

}






package Reservation;

import Passenger.DTO.CreatePassengerRequest;
import Passenger.Passenger;
import Passenger.PassengerService;
import Reservation.DTO.CreateReservationRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/reservations")
public class ReservationREST {

    @Inject
    ReservationService reservationService;

    @GET
    public Response getAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("10") int size
    ) {

        size = Math.min(size, 100);

        List<Reservation> reservations = reservationService.findAllPaged(page, size);
        long total = reservationService.count();

        return Response.ok(reservations)
                .header("X-Total-Count", total)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Reservation create(CreateReservationRequest req){
        return  reservationService.createReservation(req);
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        reservationService.delete(id);
        return Response.noContent().build();
    }

}


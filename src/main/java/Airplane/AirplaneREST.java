package Airplane;

import Airplane.DTO.CreateAirplaneRequest;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/airplanes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class AirplaneREST {

    @Inject
    AirplaneService airplaneService;

    @GET
    public Response getAll(
            @QueryParam("page") @DefaultValue("0") int page,
            @QueryParam("size") @DefaultValue("50") int size
    ) {

        size = Math.min(size, 100);

        List<Airplane> airplanes = airplaneService.findAllPaged(page, size);
        long total = airplaneService.count();

        return Response.ok(airplanes)
                .header("X-Total-Count", total)
                .build();
    }


    @POST
    public Airplane createAirplane(CreateAirplaneRequest req){
        return airplaneService.createAirplane(req);
    }
}

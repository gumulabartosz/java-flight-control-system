package Flight;

import Airplane.Airplane;
import Airport.Airport;
import Route.Route;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/flight")

public class FlightREST {

    List<Flight> flights = new ArrayList<Flight>();


    @Inject
    FlightService flightService;

    @GET
    @Path("/generate")
    public Flight generate() {

        Route route1 = new Route(Airport.POZ, Airport.GDN, 45);
        Airplane a1 = new Airplane("Airbus", "A320", 200, 5);
        flights.add(new Flight(route1, LocalDateTime.now(), a1));

        Flight f1 = flightService.createFlight(route1, LocalDateTime.now(), a1);
        f1.persist();

        return flights.getLast();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/all")
    public List<Flight> getAll(){

        return flights;
    }
}

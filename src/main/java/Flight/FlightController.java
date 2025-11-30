package Flight;

import Airplane.Airplane;
import Airport.Airport;
import Route.Route;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/flight")

public class FlightController {

    List<Flight> flights = new ArrayList<Flight>();

    @GET
    @Path("/generate")
    public String generate() {

        Route route1 = new Route(Airport.POZ, Airport.GDN, 45);
        Airplane a1 = new Airplane("Airbus", "A320", 200, 5);
        flights.add(new Flight(route1, LocalDateTime.now(), a1));

        return flights.getLast().toString();
    }


    @GET
    @Path("/all")
    public int getAll(){


        return flights.size();
    }
}

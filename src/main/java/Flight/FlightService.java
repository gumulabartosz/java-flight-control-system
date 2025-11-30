package Flight;

import Airplane.Airplane;
import Route.Route;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

@ApplicationScoped
public class FlightService {

    @Transactional
    public Flight createFlight(Route route, LocalDateTime departure, Airplane airplane) {
        Flight f = new Flight(route, departure, airplane);
        f.persist();
        return f;
    }
}
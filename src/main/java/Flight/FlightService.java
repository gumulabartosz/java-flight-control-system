package Flight;

import Airplane.*;
import Flight.DTO.CreateFlightRequest;
import Route.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class FlightService {

    @Inject
    AirplaneService airplaneService;

    @Inject
    RouteService routeService;

    @Transactional
    public Flight createFlight(CreateFlightRequest req) {

        Route r = routeService.findById((long)req.routeId);
        if (r == null) {
            throw new EntityNotFoundException(
                    "Route with ID: " + req.routeId + " not found."
            );
        }
        Airplane a = airplaneService.findById((long)req.airplaneId);
        if (a == null) {
            throw new EntityNotFoundException(
                    "Airplane with ID: " + req.airplaneId + " not found."
            );
        }

        Flight f = new Flight(r, req.departure, a);
        f.persist();
        return f;
    }

    public Flight findById(Long id) {
        return Flight.findById(id);
    }

    public List<Flight> findAllPaged(int page, int size) {

        return Flight.findAll()
                .page(page, size)
                .list();
    }

    public long count() {
        return Flight.count();
    }



}
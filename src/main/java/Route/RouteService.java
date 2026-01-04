package Route;


import Airplane.Airplane;
import Airport.*;
import Flight.Flight;
import Route.DTO.CreateRouteRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;

import java.time.LocalDateTime;

@ApplicationScoped
public class RouteService {

    @Inject
    AirportService airportService;

    @Transactional
    public Route createRoute(CreateRouteRequest req) {

        if (req.sourceId == null || req.destinationId== null) {
            throw new WebApplicationException("Airport not found", 404);
        }

        Airport source = airportService.findById((long)req.sourceId);
        Airport destination = airportService.findById((long)req.destinationId);

        Route r = new Route(source, destination, req.estimatedTime);
        r.persist();
        return r;
    }

    public Route findById(Long id) {
        return Route.findById(id);
    }

}

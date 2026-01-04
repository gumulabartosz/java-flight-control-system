package Route;


import Airport.*;
import Route.DTO.CreateRouteRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class RouteService {

    @Inject
    AirportService airportService;

    @Transactional
    public Route createRoute(CreateRouteRequest req) {

        Airport source = airportService.findById((long)req.sourceId);
        if (source == null) {
            throw new EntityNotFoundException(
                    "Flight with ID: " + req.sourceId + " not found."
            );
        }
        Airport destination = airportService.findById((long)req.destinationId);
        if (destination == null) {
            throw new EntityNotFoundException(
                    "Flight with ID: " + req.destinationId + " not found."
            );
        }

        Route r = new Route(source, destination, req.estimatedTime);
        r.persist();
        return r;
    }

    public Route findById(Long id) {
        return Route.findById(id);
    }

    public List<Route> findAllPaged(int page, int size) {

        return Route.findAll()
                .page(page, size)
                .list();
    }

    public long count() {
        return Route.count();
    }

}

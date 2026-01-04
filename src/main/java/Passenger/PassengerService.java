package Passenger;


import Airport.Airport;
import Passenger.DTO.CreatePassengerRequest;
import Route.Route;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;

import java.util.List;

@ApplicationScoped
public class PassengerService {

    @Transactional
    public Passenger cretePassenger(CreatePassengerRequest req) {

        Passenger p = new Passenger(req.firstName, req.lastName, req.age, req.sex, req.isDisabled);
        p.persist();
        return p;
    }

    public Passenger findById(Long id) {
        return Passenger.findById(id);
    }

    public List<Passenger> findAllPaged(int page, int size) {

        return Passenger.findAll()
                .page(page, size)
                .list();
    }

    public long count() {
        return Passenger.count();
    }


}

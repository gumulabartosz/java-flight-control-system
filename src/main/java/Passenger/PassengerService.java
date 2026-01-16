package Passenger;


import Airplane.Airplane;
import Airplane.DTO.UpdateAirplaneRequest;
import Airport.Airport;
import Passenger.DTO.CreatePassengerRequest;
import Passenger.DTO.UpdatePassengerRequest;
import Route.Route;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityNotFoundException;
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


    @Transactional
    public Passenger update(Long id, UpdatePassengerRequest req) {
        Passenger passenger = Passenger.findById(id);
        if (passenger == null) {
            throw new EntityNotFoundException(
                    "Passenger with ID " + id + " not found"
            );
        }
        if(req.age != null) passenger.age = req.age ;
        if(req.firstName != null) passenger.firstName = req.firstName ;
        if(req.lastName != null) passenger.lastName = req.lastName ;
        if(req.isDisabled != null) passenger.isDisabled = req.isDisabled ;

        return passenger;
    }

    @Transactional
    public void delete(Long id) {

        Passenger passenger = Passenger.findById(id);

        if (passenger == null) {
            throw new EntityNotFoundException(
                    "Passenger with id " + id + " not found."
            );
        }
        passenger.delete();

    }


}

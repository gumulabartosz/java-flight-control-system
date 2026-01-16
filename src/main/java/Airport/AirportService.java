package Airport;

import Airplane.Airplane;
import Airport.DTO.CreateAirportRequest;

import Utils.AlreadyExistsException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class AirportService {
    @Transactional
    public Airport createAirport(CreateAirportRequest req){
        if(Airport.find("code", req.code.toUpperCase()).firstResult() != null){
            throw new AlreadyExistsException(
                    "Airport with code " + req.code + " already exists"
            );
        }
        Airport airport = new Airport(req.code);

        airport.persist();
        return airport;
    }

    public Airport findById(Long id) {
        return Airport.findById(id);
    }

    public List<Airport> findAllPaged(int page, int size){
        return Airport.findAll().page(page,size).list();
    }

    public long count() {
        return Airport.count();
    }

    @Transactional
    public void delete(Long id) {

        Airport airport = Airport.findById(id);

        if (airport == null) {
            throw new EntityNotFoundException(
                    "Airport with id " + id + " not found."
            );
        }
        airport.delete();
    }

}
